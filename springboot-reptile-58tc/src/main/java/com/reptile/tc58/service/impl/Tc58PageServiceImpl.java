package com.reptile.tc58.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.reptile.tc58.model.Company;
import com.reptile.tc58.model.Job;
import com.reptile.tc58.service.Tc58PageService;
import com.thoughtworks.xstream.security.ForbiddenClassException;


@Service("tcservice")
public class Tc58PageServiceImpl implements Tc58PageService {

	public List<Job> getJobList(String pageDoc) {
		Document doc = Jsoup.parse(pageDoc);

		//职位信息li节点集合				<li class="job_item clearfix">
		Elements ele = doc.getElementsByClass("job_item");

		List<String> sortidList = new ArrayList<>();
		List<Job> jobList = new ArrayList<>();

		for (Element element : ele) {
			Job job = new Job();

			//职位地址、名称等信息div
			Element job_nameDiv = element.getElementsByClass("job_name").first();
			String sortid = job_nameDiv.attr("sortid");//58同城页面每个职位外层div都有一个不重复的sortid
			sortidList.add(sortid);

			String job_link = job_nameDiv.getElementsByTag("a").first().attr("href");
			job.setJob_link(job_link);//原网页职位链接

			//职位地址 span节点			 <span class="address">萧山区 </span>
			Element addressEle = element.getElementsByClass("address").first();
			String address = addressEle.text();
			job.setAddress(address);//职位地址

			//职位名称span节点	名称可能未拼接方式显示页面或者直接显示
			Element nameEle = element.getElementsByClass("name").first();

			//			Elements b_tag = nameEle.getElementsByTag("b");
			//			//此职位的职位名称为关键字拼接方式
			//			if(b_tag != null && !b_tag.isEmpty()){
			//				String jobname = "";
			//				Element b_1 = b_tag.first();
			//				jobname += b_1.text();
			//
			//				nameEle = nameEle.select("b").remove().first();
			//				jobname += nameEle.text();
			//
			//				Element b_2 = b_tag.last();
			//				if(b_2 != null){//存在第二个关键字
			//					jobname += b_2.text();
			//				}
			//				job.setTitle(jobname);
			//			}else{//非关键字拼接方式，直接拿职位名称span的值
			job.setTitle(nameEle.text());
			//			}
			//薪资p节点
			String job_salary = element.getElementsByClass("job_salary").first().text();
			job.setSalary(job_salary);

			String xueli = element.getElementsByClass("xueli").first().text();
			String jingyan = element.getElementsByClass("jingyan").first().text();
			String job_time = element.getElementsByClass("sign").first().text();

			if(!"精准".equals(job_time)){//不为精准推广
				job.setJob_time("发布于 "+job_time);
			}
			job.setDegree(xueli);
			job.setExp(jingyan);

			jobList.add(job);
		}

		List<Company> cpanyList = new ArrayList<>();
		for (Element element : ele) {
			Company cpany = new Company();
			//公司名称
			String comp_name = element.getElementsByClass("fl").first().text();//公司名称
			cpany.setName(comp_name);

			List<String> otherInfo = new ArrayList<>();
			//	58同城页面上方没有公司详细信息，将其他福利待遇信息放入
			Element job_welDiv = element.getElementsByClass("job_wel").first();
			if(job_welDiv != null){
				Elements job_wel_span = job_welDiv.getElementsByTag("span");
				for (Element span : job_wel_span) {
					otherInfo.add(span.text());
				}
			}else{
				otherInfo.add("暂无信息");
			}
			
			cpany.setOtherInfo(otherInfo);
			cpanyList.add(cpany);
		}

		for (int i = 0; i < jobList.size(); i++) {
			jobList.get(i).setCompany(cpanyList.get(i));
		}




		return jobList;
	}

}
