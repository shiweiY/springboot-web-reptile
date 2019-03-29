package com.reptile.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.web.mapper.Main2RepositoryMapper;
import com.reptile.web.model.JSONReturn;
import com.reptile.web.service.ReptileBossJobService;
import com.reptile.web.tech.cache.service.RedisHelper;

@RestController
@RequestMapping("/main")
class MainController{

	@Autowired
	ReptileBossJobService boss_service;

	@Autowired
	Main2RepositoryMapper brmapper;

	//不再使用springboot 集成的redis
	//	@Autowired
	//	RedisHelper redis;

	//	static String url = "/c101010100/y_4-d_206-e_103/?ka=sel-salary-4";

	@GetMapping("/searchJob")
	public JSONReturn search(HttpServletRequest request){

		String surl = bossParamsHandle(request);


		long start = System.currentTimeMillis();

		List<Object> list = boss_service.getBossPageJob(surl);

		JSONReturn Jmodel =new JSONReturn();
		if(list != null && !list.isEmpty()) {

			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("list", list);
			Jmodel.setMapData(resultMap);
			RedisHelper.setSerialData("boss_job_data", list);
			Jmodel.setFlag(true);
		}else {
			Jmodel.setFlag(false);
			Jmodel.setMessage("Boss 直聘,职位数据爬去失败");
		}
		long end = System.currentTimeMillis();

		long num = end - start;
		double sum = num / 1000d;

		Jmodel.setMessage("后端爬取及处理时间："+sum);
		//		List<Object> list2 = (List<Object>) RedisHelper.getSerialData("boss_job_data");

		return Jmodel;
	}

	public String bossParamsHandle(HttpServletRequest request){

		String query = request.getParameter("query");//职位名称
		String cityname = request.getParameter("city");//城市名字
		String exp = request.getParameter("exp");//工作经验
		String degree = request.getParameter("degree");//学历
		String salary = request.getParameter("salary");//薪资
		String stage = request.getParameter("stage");//融资阶段
		String scale = request.getParameter("scale");//公司规模

		String surl = "";

		Map<String,String >  params = new HashMap<>();

		//y_4-d_203-e_104-s_301-t_804/
		if(salary != null && (salary.indexOf("all") == -1)){
			params.put("tablename", "salarymapped");
			params.put("where", "page_param=\'"+salary+"\'");
			params.put("value", "salary_path");
			String salary_path = brmapper.selectTableOneValue(params);
			surl += salary_path+"-";
		}
		
		if(degree != null && (degree.indexOf("all") == -1)){
			params.put("tablename", "degreemapped");//表格
			params.put("where", "page_param=\'"+degree+"\'");//where条件
			params.put("value", "degree_path");//需要查询出来的值
			String degree_path = brmapper.selectTableOneValue(params);
			surl += degree_path+"-";
		}

		//y_4-d_203-e_104-s_301-t_804/
		if(exp != null && (exp.indexOf("all") == -1)){
			params.put("tablename", "expmapped");//表格
			params.put("where", "page_param=\'"+exp+"\'");//where条件
			params.put("value", "exp_path");//需要查询出来的值
			String exp_path = brmapper.selectTableOneValue(params);
			surl += exp_path+"-";
		}
		
		if(scale != null && (scale.indexOf("all") == -1)){
			params.put("tablename", "scalemapped");
			params.put("where", "page_param=\'"+scale+"\'");
			params.put("value", "scale_path");
			String scale_path = brmapper.selectTableOneValue(params);
			surl += scale_path+"-";
		}

		//y_4-d_203-e_104-s_301-t_804/
		if(stage != null && (stage.indexOf("all") == -1)){
			params.put("tablename", "stagemapped");
			params.put("where", "page_param=\'"+stage+"\'");
			params.put("value", "stage_path");
			String stage_path = brmapper.selectTableOneValue(params);
			surl += stage_path;
		}


		if(cityname != null && !cityname.isEmpty()){
			params.put("tablename", "citymapped");//表格
			params.put("where", "city_name=\'"+cityname+"\'");//where条件
			params.put("value", "city_path");//需要查询出来的值
			String citypath = brmapper.selectTableOneValue(params);
			surl = citypath+surl;
		}

		if(surl.charAt(surl.length()-1) == '-' ){
			surl = surl.substring(0, surl.length()-1);
		}
		
		if(query != null && !query.isEmpty()){
			surl = surl+"/?query="+query;
		}

		System.out.println(surl);
		System.out.println();
		System.out.println();


		return surl;
	}

}