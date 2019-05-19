package com.reptile.proup.tc58.mapper.provider;

import java.util.Map;
import java.util.Set;

import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SqlProvider {

	private static final Logger log = LoggerFactory.getLogger(SqlProvider.class);


	//简单sql查询
	public String selectTableWithParams(Map<String,String> params){

		if(params != null && !params.isEmpty()){
			SQL sql = new SQL();

			sql.SELECT(params.get("value"));
			sql.FROM(params.get("tablename"));

			if(params.get("where") != null && params.get("where").length() > 0){
				sql.WHERE(params.get("where"));
			}

			log.debug("此次简单sql查询的语句: "+sql.toString());

			return sql.toString();

		}

		return null;
	}

	public String updateCitymappedWithMap(Map<String,String> params){

		SQL sql = new SQL();

		Set<String> keys = params.keySet();
		for (String key : keys) {
			sql.UPDATE("citymapped");
			sql.SET("province="+params.get("province")+",tc58_city_param="+params.get(key));
			sql.WHERE("city_name="+key);
		}

		log.debug("此次更新citymapped表的语句: "+sql.toString());
		System.out.println(sql.toString());

		return sql.toString();
	}
}
