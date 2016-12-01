package com.my.sa.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.my.sa.configuration.BaseJdbcDao;
import com.my.sa.dao.MessageDao;
import com.my.sa.domain.Message;

@Repository
public class MessageDaoImpl extends BaseJdbcDao implements MessageDao{
	
	static Logger logger = Logger.getLogger(MessageDaoImpl.class);
	
	public List<Message> getMessageList(){
		//查看数据库信息
        String dbSql = "select database();";
        String db = getJdbcTemplate().queryForObject(dbSql, String.class);
		logger.info(db);
		
		String sql = "select * from message;";
		logger.info("--------------sql-------------");
		logger.info(sql);
		List<Message> list = getNamedParameterJdbcTemplate().query(sql, new HashMap(),new BeanPropertyRowMapper(Message.class));
		return list;
	}

	@Override
	@Transactional
	public void insertMessage(Message message) {
		String sql = "INSERT INTO message(MSG_ID,MSG_CAT,MSG_TITLE,MSG_CONTENT,MSG_TYPE,CREATE_TIME,"
	                  +"CREATE_BY,UPDATE_TIME,UPDATE_BY) VALUES(:msgId,:msgCat,:msgTitle,:msgContent,:msgType,:createTime,"+
				":createBy,:updateTime,:updateBy)";
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(message);
		getNamedParameterJdbcTemplate().update(sql, parameters);
		
	}

}
