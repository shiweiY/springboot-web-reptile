package com.reptile.boss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.reptile.boss.model.Company;
import com.reptile.boss.model.Job;
import com.reptile.boss.service.BossPageService;


/***
 * 
 *  <br>Boss直聘 页面数据爬取及处理
 *  <br>数据爬取使用Jsoup
 * 
 * @author yangsw
 *
 */

@Service("pageService")
public class BossPageServiceImpl implements BossPageService {
	Logger log = LoggerFactory.getLogger(BossPageServiceImpl.class);


	/***
	 * 解析页面Document 获取页面的职位及公司信息
	 * 
	 * @param pageDoc 被转化为String的Document对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getJobList(String pageDoc) {
//		System.out.println(pageDoc);
		Document doc = Jsoup.parse(pageDoc);

		Elements job_lists = doc.select("div[class='job-list']");

		Element job_list = job_lists.first();//职位信息的外层div

		Elements job_primary = job_list.select("div[class='job-primary']");//职位信息div集合

		if(job_primary == null || job_primary.isEmpty()){
			return null;
		}
		String regex = "<em class=\"vline\"></em>";//以此规则进行分割信息
		List<Job> jobList = new ArrayList<Job>();
		for (int i = 0;i < job_primary.size();i++) {
			Element jobEle = job_primary.get(i);

			//职位信息所在的div
			Element info_primary = jobEle.select("div[class='info-primary']").first();

			String job_link = info_primary.getElementsByTag("a").first().attr("href");//职位连接
			String job_title = info_primary.select("div[class='job-title']").first().html();//职位名称
			String job_salary = info_primary.select("span[class='red']").first().html();//薪资待遇

			Element job_p = info_primary.getElementsByTag("p").first();//职位地址所在的<p>	<p>北京 朝阳区 国贸<em class="vline"></em>1年以内<em class="vline"></em>高中</p>


			/***
			 *	获取p标签中的职位信息		待优化
			 */
			String[] p_arr = job_p.toString().split(regex);//分割p中的信息

			String job_address = p_arr[0].substring(3, p_arr[0].length());

			String job_exp = p_arr[1];

			String job_degree = p_arr[2].substring(0, p_arr[2].length()-4);


			/***
			 * 职位发布时间 所在的div
			 */
			Element info_publis = jobEle.getElementsByClass("info-publis").first();

			String job_time = info_publis.getElementsByTag("p").first().html();


			/***
			 * 公司信息所在的div			
			 */
			Element info_company = jobEle.select("div[class='info-company']").first();
			Element company_a_tag = info_company.getElementsByTag("a").first();//职位连接

			String company_name = company_a_tag.html();
			String company_link = company_a_tag.attr("href");

			Element company_p = info_company.getElementsByTag("p").first();//公司信息的p标签

			String[] p_arr2 = company_p.toString().split(regex);//分割p中的信息

			String company_type = "";//公司性质
			String company_stage = "";//融资阶段
			String company_scale = "";//公司规模
			//标签中存在公司信息， 某些公司是可以选择不填写的
			if(p_arr2 != null && p_arr2.length > 0 ){
				company_type = p_arr2[0].substring(3, p_arr2[0].length());//公司性质

				//boss直聘目前公司信息最多有三条	 em：   <p>计算机软件<em class="vline"></em>不需要融资<em class="vline"></em>20-99人</p>
				if(p_arr2.length == 3){
					company_stage = p_arr2[1];//融资阶段
					company_scale = p_arr2[2].substring(0, p_arr2[2].length()-4);//公司规模
				}else if(p_arr2.length == 2){
					company_stage = p_arr2[1].substring(0, p_arr2[1].length()-4);
				}

			}
			
//			公司其他信息
			List<String> otherInfo = new ArrayList<>();
			otherInfo.add(company_type);
			otherInfo.add(company_stage);
			otherInfo.add(company_scale);

			Company cpany = new Company(String.valueOf(i),company_name,company_link,otherInfo);
			
			
			Job job = new Job(job_title,job_salary,job_address,job_exp,job_degree,job_time,job_link,cpany);


			jobList.add(job);

		}


		return jobList;
	}

}
