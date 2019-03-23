package com.reptile.boss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reptile.boss.repository.Boss2DBMapper;
import com.reptile.boss.service.Boss2DBService;

@Service
public class Boss2DBServiceImpl implements Boss2DBService{
	
	@Autowired 
	Boss2DBMapper bossmapper;

	@Override
	public String getBrowserUserAgent(String agentid) {
		return null;
	}
	
	
	
	
}
