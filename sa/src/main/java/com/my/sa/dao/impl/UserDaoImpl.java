package com.my.sa.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.my.sa.configuration.BaseJdbcDao;
import com.my.sa.dao.UserDao;
import com.my.sa.domain.User;

@Repository
public class UserDaoImpl extends BaseJdbcDao implements UserDao{

	@Override
	public void createUser(User user) {
		String sql = "insert into user(user_id,user_name,account,password,role,create_time,update_time)"+""
				+ " values(:userId,:userName,:account,:password,:role,:createTime,:updateTime)";
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
		getNamedParameterJdbcTemplate().update(sql, parameters);
	}

	@Override
	public User getUserByAccount(String account) {
		String sql = "select * from user where account=:account";
		Map<String,String> map = new HashMap<String,String>();
		map.put("account", account);
		List<User> list =  getNamedParameterJdbcTemplate().query(sql, map,new BeanPropertyRowMapper(User.class));
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}

}
