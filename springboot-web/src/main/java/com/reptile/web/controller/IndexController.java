package com.reptile.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	@RequestMapping("")
	public String index() {
		
		return "main";
	}
}
