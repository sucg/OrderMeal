package com.glodon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController extends BaseController{

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
