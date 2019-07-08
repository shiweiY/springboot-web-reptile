package com.reptile.proup.test;

import com.reptile.proup.model.Company;
import com.reptile.proup.model.TC58Job;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileReptileForThreadTest {

    public static void main(String[] args) {
        String path = "E:\\58tc.html";
        File file = new File(path);

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

            String str = "";
            StringBuffer stringBuffer = new StringBuffer();
            while ((str = in.readLine()) != null){
                stringBuffer.append(str);
            }
            Document doc = Jsoup.parse(stringBuffer.toString());
//            System.out.println(doc.toString());
//
//            System.out.println("test");

            //职位信息所在的ul
            Elements list_con = doc.select("#list_con");
            Elements jobs_li = list_con.select(".job_item");//职位信息的li标签的所有集合

            ExecutorService executepool = Executors.newCachedThreadPool();
//
//            Future<Map<String,TC58Job>> jobInfoResult = executepool.submit(new Callable<Map<String,TC58Job>>() {
//                @Override
//                public Map<String,TC58Job> call() throws Exception {
//                    return getJobInfo(jobs_li);
//                }
//            });
            
            Future<Map<String,Company>> comInfoResult = executepool.submit(new Callable<Map<String,Company>>() {
                @Override
                public Map<String,Company> call() throws Exception {
                    return getComInfo(jobs_li);
                }
            });
            
            executepool.shutdown();
            
            
            Map<String, Company> cpaResult = comInfoResult.get();
            Map<String,TC58Job> jobResult = getJobInfo(jobs_li);
            
            for (Map.Entry<String, TC58Job> jobEntry : jobResult.entrySet()) {
				
            	String sortIDkey = jobEntry.getKey();
            	
            	jobEntry.getValue().setCompany(cpaResult.get(sortIDkey));
            	
            	
			}
            
            System.out.println("...");
            System.out.println("...");
            System.out.println("...");
            System.out.println("...");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static Map<String,TC58Job> getJobInfo(Elements jobs_li){


        if(jobs_li == null || jobs_li.isEmpty()) {
            return null;
        }
        Map<String,TC58Job> resultMap = new HashMap<>();

        String sortid = null;
        String jobAddress = null;
        String jobName = null;
        String jobSalary = null;
        String xueli = null;
        String jingyan = null;

        int i = 0;
        TC58Job job = new TC58Job();
        for (Element element: jobs_li ) {

            //每个职位的唯一sortid
            Elements sortidEles = element.getElementsByAttribute("sortid");
            Element sortidDiv = sortidEles.first();
            if (sortidDiv == null){
                System.out.println("sorid错误！");
                return null;
            }
            
            sortid = sortidDiv.attr("sortid");

            //<!-- > 职位信息节点<-->
            Element job_title =  element.select(".job_title").first();

            //地址 address
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

            Elements job_requireEles = element.getElementsByClass("job_comp").first().getElementsByClass("job_require");
            if(job_requireEles != null){
                Element job_requireP = job_requireEles.first();

                //学历
                Elements xueliEles = job_requireP.getElementsByClass("xueli");
                Element xueleSpan = xueliEles.first();
                xueli = (xueleSpan == null ? "无薪资信息" : xueleSpan.text());

                //经验
                Elements jingyanEles = job_requireP.getElementsByClass("jingyan");
                Element jingyanSpan = jingyanEles.first();
                jingyan = (jingyanSpan == null ? "无薪资信息" : jingyanSpan.text());
            }

            job.setAddress(jobAddress);
            job.setSalary(jobSalary);
            job.setTitle(jobName);
            job.setDegree(xueli);
            job.setExp(jingyan);
            job.setWel(welList);
            job.setSortid(sortid);
            
            
            resultMap.put(sortid,job);

        }
        i++;
        return resultMap;
    }
    
    
    public static Map<String,Company> getComInfo(Elements jobs_li){
    	 if(jobs_li == null || jobs_li.isEmpty()) {
             return null;
         }
    	 
    	 String sortid = null;
    	 String name = null;
    	 String link = null;
    	 
    	  
         Map<String,Company> resultMap = new HashMap<>();
         
         int i=0;
         for (Element element : jobs_li) {
        	
        	 //每个职位的唯一sortid
             Elements sortidEles = element.getElementsByAttribute("sortid");
             Element sortidDiv = sortidEles.first();
             if (sortidDiv == null){
                 System.out.println("第"+i+"个sorid错误！");
                 return null;
             }
             
             sortid = sortidDiv.attr("sortid");
        	 
        	 Elements companyELes = element.getElementsByClass("fl");
        	 Element companyALink = companyELes.first();
        	 name = companyALink.text();
        	 link = companyALink.attr("href");
        	 
        	 Company cpa = new Company();
        	 cpa.setSortid(sortid);
        	 cpa.setName(name);
        	 cpa.setLink(link);
        	 
        	 i++;
        	 resultMap.put(sortid, cpa);
			
		}
         
		return resultMap;
    }


}
