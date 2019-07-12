package com.reptile.proup.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.reptile.proup.model.Company;
import com.reptile.proup.model.Job;


@Service("tcservice")
public class Tc58PageServiceImpl {

	public static void main(String[] args) throws Throwable {
		getJobList();
	}

	public static List<Job> getJobList() {

		String path = "E:\\58tc.html";
		File file = new File(path);

		List<Job> jobList = new ArrayList<>();
		int j = 0;

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));


			String str = "";
			StringBuffer stringBuffer = new StringBuffer();
			while ((str = in.readLine()) != null){
				stringBuffer.append(str);
			}
			Document doc = Jsoup.parse(stringBuffer.toString());

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

			Job job = new Job();
			for (Element element : ele) {

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

//				if(!"精准".equals(job_time)){//不为精准推广
//					job.setJob_time("发布于 "+job_time);
//				}

				job.setSalary(jobSalary);
				job.setTitle(jobName);
				job.setAddress(jobAddress);//职位地址
				job.setJob_link(jobLink);//原网页职位链接
				job.setDegree(xueli);
				job.setExp(jingyan);

				jobList.add(job);

			}

			String cpname = null;
			String cplink = null;

			Company cpany = new Company();
			List<Company> cpanyList = new ArrayList<>();
			for (Element element : ele) {
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
			}
			
			for (int i = 0; i < jobList.size(); i++) {
				jobList.get(i).setCompany(cpanyList.get(i));
			}
			
			long end = System.currentTimeMillis();
			System.out.println("总时间："+(end-start));
			

		} catch (Exception e) {
			System.out.println("第"+ j + " 个错误");
			e.printStackTrace();
		} 


		return jobList;
	}

}
