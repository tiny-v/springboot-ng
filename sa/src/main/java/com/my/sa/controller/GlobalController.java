package com.my.sa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.sa.core.global.Constants;

@Controller
@RequestMapping(value="/global")
public class GlobalController {
	
	@RequestMapping(value="/getOnlineNum",method=RequestMethod.GET)
	@ResponseBody
	public long getOnlineNum(){
		return Constants.online_Num;
	}

}
