package com.reptile.repository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.repository.Mapper.SelectMapper;

@RestController
@RequestMapping("/repository/select")
public class SelectController {
	
	@Autowired
	SelectMapper smapper;
	
	@RequestMapping("/selectTableValue")
	public String selectTableValue(String table,String value,String sqlcondition){
		return smapper.selectTableValue(table, value,sqlcondition);
	}
	
}
