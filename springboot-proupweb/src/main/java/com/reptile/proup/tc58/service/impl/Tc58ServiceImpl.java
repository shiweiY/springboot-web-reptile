package com.reptile.proup.tc58.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.reptile.proup.tc58.mapper.Tc58DBMapper;
import com.reptile.proup.tc58.mapper.provider.SqlProvider;
import com.reptile.proup.tc58.service.Tc58Service;
import com.reptile.proup.utils.StringUtil;

@Service("tc58service")
public class Tc58ServiceImpl implements Tc58Service {
	
	private static final Logger log = LoggerFactory.getLogger(SqlProvider.class);
	
	@Autowired
	Tc58DBMapper tc58mapper;

	@Override
	public boolean cityInfoUpdate(String result){
		long CITYNUM = 0;

		Document doc = Jsoup.parse(result);

		Elements scripts = doc.getElementsByTag("script");

		String cityInfoStr = "";
		for (Element element : scripts) {
			String scriptText = element.html();//找到所在的script
			if(scriptText.indexOf("provinceList") != -1 && scriptText.indexOf("cityList") != -1){
				cityInfoStr = scriptText;
				break;
			}
		}

		if(cityInfoStr == ""){
			return false;
		}



		//四个直辖市的json信息
		int independentCityListIndex =  cityInfoStr.indexOf("independentCityList");
		int independentCityListLeftKuoHao = cityInfoStr.indexOf("{", independentCityListIndex);//左括号位置
		int independentCityListRightKuoHao = cityInfoStr.indexOf("}", independentCityListLeftKuoHao);//右括号位置

		String independentCityListStr = cityInfoStr.substring(independentCityListLeftKuoHao, independentCityListRightKuoHao+1);
		JSONObject fourJson = JSON.parseObject(independentCityListStr.trim());//四个直辖市 json
		Set<String> fourJsonKey = fourJson.keySet();


		//普通省市 json
		int cityListIndex = cityInfoStr.indexOf("cityList");
		int cityListIndexLeftKuoHao = cityInfoStr.indexOf("{", cityListIndex);//左括号位置
		int cityListIndexRightKuoHao = cityInfoStr.lastIndexOf("}");
		String cityListStr = cityInfoStr.substring(cityListIndexLeftKuoHao, cityListIndexRightKuoHao+1);
//		System.out.println(cityListStr);

		JSONObject cityJson = JSON.parseObject(cityListStr.trim());
		Set<String> cityJsonKey = cityJson.keySet();

		//		 "安徽":{"合肥":"hf|837","芜湖":"wuhu|2045",
		for (String provinceKey : cityJsonKey) {
			JSONObject json = cityJson.getJSONObject(provinceKey);
			Set<String> cityKey = json.keySet();
			
			//Map的key将会为城市名字，value为58同城的参数
			Map<String,String> city2DBMap = new HashMap<>();
			city2DBMap.put("province", provinceKey);//省份名称
			for (String cityname : cityKey) {
				if("阿拉善盟".equals(cityname)){
					System.out.println();
				}
				String cityval = json.getString(cityname);
				if(cityname.indexOf("盟") != -1 || cityname.indexOf("市") != -1){
					cityname = StringUtil.replaceProvince(cityname);
				}
				
//				"合肥":"hf|837"
				int shuIndex = cityval.indexOf("|");
				if(shuIndex != -1){
					String cityPathName = cityval.substring(0, shuIndex);
					city2DBMap.put(cityname, cityPathName);
				}else{
					city2DBMap.put(cityname, cityval);
				}
				CITYNUM++;
				
				List<Object> list = tc58mapper.selectCityInfoIsNotNull(cityname);
				if(list == null || list.isEmpty()){
					JSONObject city2DBJson = new JSONObject();
					city2DBJson.put("province", provinceKey);
					city2DBJson.put("city", cityname);
					city2DBJson.put("tc58_param", city2DBMap.get(cityname));
					tc58mapper.insertCity2Citymapped(city2DBJson);
				}
				
			}
			tc58mapper.updateCitymapped(city2DBMap);
		}


		
		//将解析的参数存入map
		//四个直辖市
		for (String key : fourJsonKey) {
			if(StringUtil.notNull(key)){
				Map<String,String> fourCity2SqlMap = new HashMap<>();
				String cityval = fourJson.getString(key);
				fourCity2SqlMap.put("province", "fourcity");

				//"北京":"bj|1","上海":"sh|2",
				int shuIndex = cityval.indexOf("|");
				String cityPathName = cityval.substring(0, shuIndex);

				fourCity2SqlMap.put(key, cityPathName);
				tc58mapper.updateCitymapped(fourCity2SqlMap);
				CITYNUM++;
			}
		}

		System.out.println("城市信息更入citymapped完成,共计 "+CITYNUM+" 个城市信息被更新！");
		
		log.info("城市信息更入citymapped完成,共计 "+CITYNUM+" 个城市信息被更新！");

		//---------------------------------
		//		File file = new File("E:\\test.js");
		//		
		//		BufferedReader bre = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));  
		//
		//		String strs = "";
		//		String count = "";
		//		while((count = bre.readLine())!=null){ 
		//			strs+=count;
		//        }
		//		
		//		int cityIndex = strs.indexOf("cityList");
		//		int cityIndexLeftKuoHao = strs.indexOf("{", cityIndex);//左括号位置
		//-----------------------------------------

		//		String str = StrChecker.formatVarJSON(cityInfoStr, cityListIndexLeftKuoHao);
		//		System.out.println(str);

		return true;
	}
}
