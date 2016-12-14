package com.my.sa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.sa.core.global.Constants;
import com.my.sa.core.util.page.Page;
import com.my.sa.dao.visitRecordDao;

@Controller
@RequestMapping(value="/global")
public class GlobalController {
	
	
	@Autowired
	private visitRecordDao vr;
	
	@RequestMapping(value="/getOnlineNum",method=RequestMethod.GET)
	@ResponseBody
	public long getOnlineNum(){
		return Constants.onlineNum;
	}
	
	@RequestMapping(value="/getVisitRecord",method=RequestMethod.GET)
	@ResponseBody
	public Page getVisitRecord(@PageableDefault(page = 0, size = 10) Pageable pageable){
		return vr.findAll(pageable);
	}
	

}
