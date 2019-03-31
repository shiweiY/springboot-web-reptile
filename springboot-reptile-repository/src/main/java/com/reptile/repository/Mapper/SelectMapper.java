package com.reptile.repository.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelectMapper {
	
	/***
	 * 查询某表某个值
	 * @return List
	 */
	@Select("select #{value} from #{table} where #{sqlcondition}")
	public String selectTableValue(@Param("table")String table,@Param("value")String value,@Param("sqlcondition")String sqlcondition);
}
