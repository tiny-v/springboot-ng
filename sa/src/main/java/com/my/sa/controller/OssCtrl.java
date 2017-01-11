package com.my.sa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.my.sa.core.exception.OrtException;
import com.my.sa.core.util.AliyunOSSUtil;

@RestController
@RequestMapping(value="/oss")
public class OssCtrl {
	
	@RequestMapping(value="/uploadToOss",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> uploadToOss(@RequestBody MultipartFile file){
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("path", AliyunOSSUtil.upload(file));
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OrtException(500,"文件上传至OSS出错");
		}
	}

}
