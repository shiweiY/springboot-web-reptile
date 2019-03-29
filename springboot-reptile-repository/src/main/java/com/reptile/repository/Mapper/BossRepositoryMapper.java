package com.reptile.repository.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BossRepositoryMapper {
	
	/***
	 * 获取热门城市city list
	 * @return List
	 */
	@Select("select hc_name from hotcity")
	public List<Object> getHotCity();
	
	
	/***
	 * @param 查询城市path
	 * @return String
	 */
	@Select("select c.city_path from citymapped c where c.city_name = #{cityname}")
	public String selectBossCityPath(@Param("cityname") String cityname);
	
	
	/***
	 * @param 查询城市path
	 * @return String
	 */
	@Select("select e.exp_path from expmapped e where e.page_param = #{exp}")
	public String selectBossExpPath(@Param("exp") String exp);
}
