package com.my.sa.core.data.mybatis.dialect;

public class MySQLDialect implements Dialect {

	@Override
	public String getPageSql(String sql, int offset, int limit) {
		StringBuilder sqlBuilder = new StringBuilder(sql);
		
		if(offset <= 0){
			return sqlBuilder.append(" limit ").append(limit).toString();
		}
		
		return sqlBuilder.append(" limit ").append(offset)
				.append(",").append(limit).toString();
	}

	@Override
	public String getCountSql(String sql) {
		StringBuilder sqlBuilder = new StringBuilder();
		
		return sqlBuilder.append("select count(*) from (").
				append(sql).append(") tmp_count").toString();
	}

}
