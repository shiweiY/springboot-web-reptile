package com.reptile.boss.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Boss2DBMapper {
	
	@Select("select u.agent from user_agent u where u.agentid = #{agentid}")
	public String getBrowserUserAgent(@Param("agentid") String agentid);
}
