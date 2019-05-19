package com.reptile.proup.tc58.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.alibaba.fastjson.JSONObject;
import com.reptile.proup.tc58.mapper.provider.SqlProvider;

@Mapper
public interface Tc58DBMapper {
	
	/***
	 * 更新城市表中58同城的信息
	 * @param params
	 */
	@Update({
		"<script>",
			"<foreach item='value' index='key' collection='params' separator=';'>",
				"update citymapped set province=#{params.province},tc58_city_param = #{value} where city_name like CONCAT(#{key},'%')",
			"</foreach>",
		"</script>"
	})
	public void updateCitymapped(@Param("params") Map<String,String> params);
	
	
	@Select("select c.city_name from citymapped c where c.city_name like CONCAT(#{cityname},'%')")
	public List<Object> selectCityInfoIsNotNull(@Param("cityname") String cityname);
	
	
	@Insert("insert into citymapped values(#{city2DBJson.province},#{city2DBJson.city},null,null,#{city2DBJson.tc58_param})")
	public void insertCity2Citymapped(@Param("city2DBJson") JSONObject city2DBJson );
}
