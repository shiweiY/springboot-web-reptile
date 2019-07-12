package com.reptile.web.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.web.mapper.Main2RepositoryMapper;
import com.reptile.web.model.JSONReturn;
import com.reptile.web.service.FeignBossService;
import com.reptile.web.service.FeignLagouService;
import com.reptile.web.service.FeignTc58Service;
import com.reptile.web.tech.cache.service.RedisHelper;

@RestController
@RequestMapping("/web/controller/tc58")
class WebTc58Controller{

	private static final Logger log = LoggerFactory.getLogger(WebTc58Controller.class);
	private static final String URLTMP = "https://city.58.com/job/";

//
	@Autowired
	FeignTc58Service tc58_service;

	@Autowired
	Main2RepositoryMapper brmapper;

	//不再使用springboot 集成的redis
	//	@Autowired
	//	RedisHelper redis;
	
	@GetMapping("/searchJob")
	public JSONReturn SingleSearch(HttpServletRequest request){
		String showid = request.getParameter("showid");
		String page = request.getParameter("page");//源页面页码
		
		String url  = tc58ParamsHandle(request);
		
		JSONReturn Jmodel =new JSONReturn();

		long start = System.currentTimeMillis();

		List<Object> joblist = new ArrayList<Object>();

		try{
			//boss直聘查询
			joblist = tc58_service.get58TcPageJob(url);
			
			if(joblist == null){
				joblist = new ArrayList<Object>();
			}

			Map<String,Object> resultMap = new HashMap<>();
			
			resultMap.put("resultJobArray", joblist);
			RedisHelper.setSerialData(showid+"JobArray"+page, joblist);//redis中存放所有查询过的数据

			Jmodel.setMapData(resultMap);

			Jmodel.setFlag(true);
			
			long end = System.currentTimeMillis();
			
			System.out.println("本次58同城后端处理时间: "+(end-start)+" ms");
			
		}catch(Exception e){//查询数据异常时反馈给页面
			e.printStackTrace();
			log.error(e.getMessage());
			Jmodel.setFlag(false);
			Jmodel.setMessage("58同城查询异常！！可能未查询出数据。");
			return Jmodel;
		}
		
		return Jmodel;
	}
	
	
	

	/***
	 * 获取页面参数，最终返回拼接的url
	 * @param request
	 * @return String
	 */
	public String tc58ParamsHandle(HttpServletRequest request){

		StringBuffer surl = new StringBuffer(URLTMP);

		try {
			String query = request.getParameter("query");//职位名称
			String cityname = request.getParameter("city");//城市名字
			String exp = request.getParameter("exp");//工作经验
			String degree = request.getParameter("degree");//学历
			String salary = request.getParameter("salary");//薪资
			String stage = request.getParameter("stage");//融资阶段
			String scale = request.getParameter("scale");//公司规模
			String pagenum = request.getParameter("page");//源页面页码

			Map<String,String>  params = new HashMap<>();

			//https://bj.58.com/job/pn3
			if(cityname != null && !cityname.isEmpty()){
				params.put("tablename", "citymapped");//表格
				params.put("where", "city_name=\'"+cityname+"\'");//where条件
				params.put("value", "tc58_city_param");//需要查询出来的值
				cityname = brmapper.selectTableOneValue(params);
				surl = surl.replace(8,12,cityname);
			}else{
				return null;
			}
			
			//页码   https://bj.58.com/job/pn3
			if(pagenum != null && !pagenum.isEmpty()){
				surl.append("pn"+pagenum+"/");
			}

			boolean exp_degreeFlag = false;
			//经验   https://bj.58.com/job/pve_5357_6/?key=java
			if(exp != null && (exp.indexOf("all") == -1)){
				params.put("tablename", "expmapped");//表
				params.put("where", "page_param=\'"+exp+"\'");//where条件
				params.put("value", "tc58_exp_param");//需要查询出来的值
				String exp_path = brmapper.selectTableOneValue(params);
				surl.append(exp_path);
				exp_degreeFlag = true;
			}

			//学历   https://bj.58.com/job/pve_5357_6_pve_5356_6/
			if(degree != null && (degree.indexOf("all") == -1)){
				params.put("tablename", "degreemapped");//表
				params.put("where", "page_param=\'"+degree+"\'");//where条件
				params.put("value", "tc58_degree_param");//需要查询出来的值
				String degree_path = brmapper.selectTableOneValue(params);
				if(exp_degreeFlag == true){
					surl.append("_"+degree_path+"/");
				}else{
					surl.append(degree_path+"/");
				}
			}

			surl.append("?");

			//查询条件
			if(query != null && !query.isEmpty()){
				surl.append("key="+query);
			}

			//薪资
			if(salary != null && (salary.indexOf("all") == -1)){
				params.put("tablename", "salarymapped");//表名
				params.put("where", "page_param=\'"+salary+"\'");//条件
				params.put("value", "tc58_salary_param");//想要查询的结果
				String salary_mp = brmapper.selectTableOneValue(params);
				surl.append("minxinzi="+salary_mp);
			}


			if (surl.indexOf("?") != (surl.length()-1)){
				surl.append("&");
			}

			surl.append("classpolicy=main_null,job_A&final=1&jump=1");

			System.out.println("本次获取的url: "+surl);

		} catch (Throwable e) {
			e.printStackTrace();
			log.error("bossParamsHandle：  参数处理异常！");
		}

		return surl.toString();
	}

	/***
	 * 中文转码
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	public static String enChinese(String value) throws Throwable{

		return (value != null && !value.isEmpty()) ? URLEncoder.encode(value, "utf-8"):"";
	}

	/****
	 * 将参数中的中文字符转码
	 * @return String 中文转码后的参数
	 * @throws Throwable 
	 */
	public static String filterChineseParams(String param) throws Throwable{
		String reg = "[^\u4E00-\u9FA5]";//中文正则表达
		Pattern pat = Pattern.compile(reg);
		Matcher matcher = pat.matcher(param);

		String chineseText = matcher.replaceAll("");//过滤出的中文
		String encode = enChinese(chineseText);//将此中文转码

		return param.replace(chineseText, encode);
	}

}