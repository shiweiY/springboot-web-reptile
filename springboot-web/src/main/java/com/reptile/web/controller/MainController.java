package com.reptile.web.controller;

import java.net.URLEncoder;
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
@RequestMapping("/main")
class MainController{

	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	FeignBossService boss_service;

	@Autowired
	FeignLagouService lagou_service;

	@Autowired
	FeignTc58Service tc58_service;

	@Autowired
	Main2RepositoryMapper brmapper;

	//不再使用springboot 集成的redis
	//	@Autowired
	//	RedisHelper redis;

	//	static String url = "/c101010100/y_4-d_206-e_103/?ka=sel-salary-4";

	@GetMapping("/searchJob")
	public JSONReturn search(HttpServletRequest request){

		//拼接boss直聘查询的url
		String bossurl = bossParamsHandle(request);

		JSONReturn Jmodel =new JSONReturn();

		long start = System.currentTimeMillis();

		List<Object> bosslist = null;

		try{
			//boss直聘查询
			bosslist = boss_service.getBossPageJob(bossurl);
			//			bosslist = lagou_service.getLagouPageJob("");
			//			bosslist = tc58_service.get58TcPageJob("");



			if(bosslist != null && !bosslist.isEmpty()) {

				Map<String,Object> resultMap = new HashMap<>();
				resultMap.put("list", bosslist);
				Jmodel.setMapData(resultMap);
				RedisHelper.setSerialData("boss_job_data", bosslist);
				Jmodel.setFlag(true);

				long end = System.currentTimeMillis();
				double sum = (end - start) / 1000d;

				Jmodel.setMessage("后端爬取及处理时间："+sum);
			}else {
				Jmodel.setFlag(false);
				Jmodel.setMessage("未查询到数据，请切换条件重试或者联系管理员");
			}

		}catch(Exception e){//查询数据异常时反馈给页面
			e.printStackTrace();
			log.error(e.getMessage());
			Jmodel.setFlag(false);
			Jmodel.setMessage("未查询到数据，请切换条件重试或者联系管理员");
			return Jmodel;
		}

		//		List<Object> list2 = (List<Object>) RedisHelper.getSerialData("boss_job_data");

		return Jmodel;
	}

	/***
	 * 获取页面参数，最终返回拼接的url
	 * @param request
	 * @return String
	 */
	public String bossParamsHandle(HttpServletRequest request){

		try {
			String query = request.getParameter("query");//职位名称
			String cityname = request.getParameter("city");//城市名字
			String exp = request.getParameter("exp");//工作经验
			String degree = request.getParameter("degree");//学历
			String salary = request.getParameter("salary");//薪资
			String stage = request.getParameter("stage");//融资阶段
			String scale = request.getParameter("scale");//公司规模
			String page = request.getParameter("page");//公司规模

			String surl = "";

			Map<String,String >  params = new HashMap<>();

			//y_4-d_203-e_104-s_301-t_804/
			if(salary != null && (salary.indexOf("all") == -1)){
				params.put("tablename", "salarymapped");//表名
				params.put("where", "page_param=\'"+salary+"\'");//条件
				params.put("value", "boss_salary_param");//想要查询的结果
				String salary_path = brmapper.selectTableOneValue(params);
				surl += salary_path+"-";
			}

			if(degree != null && (degree.indexOf("all") == -1)){
				params.put("tablename", "degreemapped");//表名
				params.put("where", "page_param=\'"+degree+"\'");//where条件
				params.put("value", "boss_degree_param");//需要查询出来的值
				String degree_path = brmapper.selectTableOneValue(params);
				surl += degree_path+"-";
			}

			//y_4-d_203-e_104-s_301-t_804/
			if(exp != null && (exp.indexOf("all") == -1)){
				params.put("tablename", "expmapped");//表
				params.put("where", "page_param=\'"+exp+"\'");//where条件
				params.put("value", "boss_exp_param");//需要查询出来的值
				String exp_path = brmapper.selectTableOneValue(params);
				surl += exp_path+"-";
			}

			if(scale != null && (scale.indexOf("all") == -1)){
				params.put("tablename", "scalemapped");
				params.put("where", "page_param=\'"+scale+"\'");
				params.put("value", "boss_scale_param");
				String scale_path = brmapper.selectTableOneValue(params);
				surl += scale_path+"-";
			}

			//y_4-d_203-e_104-s_301-t_804/
			if(stage != null && (stage.indexOf("all") == -1)){
				params.put("tablename", "stagemapped");
				params.put("where", "page_param=\'"+stage+"\'");
				params.put("value", "boss_stage_param");
				String stage_path = brmapper.selectTableOneValue(params);
				surl += stage_path;
			}


			if(cityname != null && !cityname.isEmpty()){
				params.put("tablename", "citymapped");//表格
				params.put("where", "city_name=\'"+cityname+"\'");//where条件
				params.put("value", "boss_city_param");//需要查询出来的值
				String citypath = brmapper.selectTableOneValue(params);
				surl = citypath+surl;
			}

			//如果结尾有  - 符号 则 去除
			if(surl.charAt(surl.length()-1) == '-' ){
				surl = surl.substring(0, surl.length()-1);
			}

			//要搜索的职位名称
			if(query != null && !query.isEmpty()){
				surl = surl+"?query="+filterChineseParams(query);
			}

			//第几页
			if(page != null && !page.isEmpty()){
				if(query != null && !query.isEmpty()){
					surl = surl+"&page="+page;
				}else{
					surl = surl+"?page="+page;
				}
			}
			System.out.println(surl);
			
			return surl;
		} catch (Throwable e) {
			e.printStackTrace();
			log.error("bossParamsHandle：  参数处理异常！");
		}
		
		return "";
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
	 * @param value  参数
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