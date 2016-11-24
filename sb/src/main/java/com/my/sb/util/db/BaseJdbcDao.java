package com.my.sb.util.db;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseJdbcDao extends NamedParameterJdbcDaoSupport{
	

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void init(){
		this.setJdbcTemplate(jdbcTemplate); 
	}
	
	
	

}
