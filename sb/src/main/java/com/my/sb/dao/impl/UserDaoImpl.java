package com.my.sb.dao.impl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.my.sb.dao.UserDao;
import com.my.sb.domain.User;
import com.my.sb.util.db.BaseJdbcDao;
@Repository
public class UserDaoImpl extends BaseJdbcDao implements UserDao{

	@Override
	public void createUser(User user) {
		String sql = "insert into user(user_id,user_name,account,password,role,create_time,update_time)"+""
				+ " values(:userId,:username,:account,:password,:role,:createTime,:updateTime)";
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
		getNamedParameterJdbcTemplate().update(sql, parameters);
	}

}
