package com.my.sa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/goods")
public class GoodsCtrl {
	
	
	
	public GoodsCtrl(){
		System.out.println("goods ctl");
	}
	
	@ResponseBody
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getGoods(){
		System.out.println("you got here");
		return "you got here";
	}
	
	@RequestMapping(value="/save")
	public String saveGoods(){
		return null;
	}
	

}
