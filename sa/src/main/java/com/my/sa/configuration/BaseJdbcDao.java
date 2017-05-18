package com.my.sa.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class BaseJdbcDao extends NamedParameterJdbcDaoSupport{

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void init(){
		this.setJdbcTemplate(jdbcTemplate); 
	}
	
}
