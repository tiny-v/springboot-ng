package com.my.sa.core.data.mybatis.dialect;

public interface Dialect {
	
	String getPageSql(String sql, int offset, int limit);
	
	String getCountSql(String sql);
}
