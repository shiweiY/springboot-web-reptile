package com.reptile.repository.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelectMapper {
	
	@Select("select hc_name from hotcity")
	public List<Object> getHotCity();
}
