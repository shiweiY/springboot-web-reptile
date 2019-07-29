package com.reptile.tc58.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.reptile.tc58.controller.Tc58Controller;
import com.reptile.tc58.model.Company;
import com.reptile.tc58.model.Job;
import com.reptile.tc58.service.Tc58PageService;


@Service("tcservice")
public class Tc58PageServiceImpl implements Tc58PageService {

	private static final Logger LOG = LoggerFactory.getLogger(Tc58Controller.class);

	public List<Job> getJobList(String pageDoc) {
		if(pageDoc == null || pageDoc.isEmpty())
			return null;

		List<Job> jobList = new ArrayList<>();
		int jnum = 0;//记录job第几条数据
		int cnum = 0;//记录company第几条数据
		try{
			Document doc = Jsoup.parse(pageDoc);


			long start = System.currentTimeMillis();
			//职位信息li节点集合				<li class="job_item clearfix">
			Elements ele = doc.getElementsByClass("job_item");

			List<String> sortidList = new ArrayList<>();

			String sortid = null;
			String jobAddress = null;
			String jobName = null;
			String jobSalary = null;
			String xueli = null;
			String jingyan = null;
			String jobLink = null;

			for (Element element : ele) {
				Job job = new Job();

				//每个职位的唯一sortid
				Elements sortidEles = element.getElementsByAttribute("sortid");
				Element sortidDiv = sortidEles.first();
				sortid = sortidDiv.attr("sortid");//58同城页面每个职位外层div都有一个不重复的sortid
				sortidList.add(sortid);

				Elements linkEles = sortidDiv.getElementsByTag("a");
				Element linkA = linkEles.first();
				jobLink = (linkA == null) ? "职位链接地址暂无" : linkA.attr("href");

				//<!-- > 职位信息节点<-->
				Element job_title =  element.select(".job_title").first();

				//地址 address			 <span class="address">萧山区 </span>
				Elements addressEles = job_title.getElementsByClass("address");
				Element addressSpan = addressEles.first();
				jobAddress = (addressSpan == null ? "无地址信息" : addressSpan.html());


				//职位名称   name
				Elements nameEles = job_title.getElementsByClass("name");
				Element nameSpan = nameEles.first();
				jobName = (nameSpan == null ? "无职位名称信息" : nameSpan.html());

				//薪资 job_salary
				Elements salaryEles = job_title.getElementsByClass("job_salary");
				Element salaryP = salaryEles.first();
				jobSalary = (salaryP == null ? "无薪资信息" : salaryP.text());


				Elements job_requireEles = element.getElementsByClass("job_comp").first().getElementsByClass("job_require");
				if(job_requireEles != null){
					Element job_requireP = job_requireEles.first();

					//学历
					Elements xueliEles = job_requireP.getElementsByClass("xueli");
					Element xueleSpan = xueliEles.first();
					xueli = (xueleSpan == null ? "不限学历" : xueleSpan.text());

					//经验
					Elements jingyanEles = job_requireP.getElementsByClass("jingyan");
					Element jingyanSpan = jingyanEles.first();
					jingyan = (jingyanSpan == null ? "不限经验" : jingyanSpan.text());
				}

				//			if(!"精准".equals(job_time)){//不为精准推广
				//				job.setJob_time("发布于 "+job_time);
				//			}

				job.setSalary(jobSalary);
				job.setTitle(jobName);
				job.setAddress(jobAddress);//职位地址
				job.setJob_link(jobLink);//原网页职位链接
				job.setDegree(xueli);
				job.setExp(jingyan);

				jnum++;

				jobList.add(job);

			}

			jnum = 0;

			String cpname = null;
			String cplink = null;

			List<Company> cpanyList = new ArrayList<>();
			for (Element element : ele) {
				Company cpany = new Company();
				//公司名称
				Elements companyELes = element.getElementsByClass("fl");
				Element companyALink = companyELes.first();
				cpname = companyALink.text();
				cplink = companyALink.attr("href");

				//待遇等信息
				List<String> welList = new ArrayList<String>();
				Elements job_welDivs = element.getElementsByClass("job_wel");
				if(job_welDivs != null){
					Element job_wel = job_welDivs.first();
					if(job_wel != null){
						Elements job_wel_span = job_wel.getElementsByTag("span");
						for (Element span : job_wel_span) {
							welList.add(span.text());
						}
					}
				}else{
					welList.add("暂无待遇信息");
				}

				cpany.setName(cpname);
				cpany.setLink(cplink);
				cpany.setOtherInfo(welList);
				cpanyList.add(cpany);
				cnum++;
			}

			for (int i = 0; i < jobList.size(); i++) {
				jobList.get(i).setCompany(cpanyList.get(i));
			}

			cnum = 0;

			long end = System.currentTimeMillis();

			LOG.debug("本次解析时间：" + (end-start) + "ms");
		}catch(Exception e){
			String logerror = null;
			if(jnum == 0)
				logerror = "58同城 第"+cnum+"条company解析错误";
			else
				logerror = "58同城 第"+jnum+"条job解析错误";
				LOG.error(logerror);
			e.printStackTrace();
		}

		return jobList;
	}

}
