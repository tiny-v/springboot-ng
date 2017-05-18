package com.my.sa.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("dataSourceProperties")
@ConfigurationProperties(prefix="spring.datasource",ignoreUnknownFields = true)
public class DataSourceProperties {
	
	private String username;
	private String password;
	private String driverClassName;
	private String url;
	private int initialSize;
	private int maxActive;
	private int maxIdle;
	private int minIdle;
	private int maxWait;
	private int removeAbandonedTimeout;
	private boolean removeAbandoned;
	private boolean testOnBorrow;
	private boolean testOnReturn;
	private boolean testWhileIdle;
	private String validationQuery;
	private int timeBetweenEvictionRunsMillis;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getDriverClassName() {
		return driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public int getInitialSize() {
		return initialSize;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public int getMaxIdle() {
		return maxIdle;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public int getMaxWait() {
		return maxWait;
	}
	public int getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}
	public boolean isRemoveAbandoned() {
		return removeAbandoned;
	}
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	public boolean isTestOnReturn() {
		return testOnReturn;
	}
	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}
	public String getValidationQuery() {
		return validationQuery;
	}
	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}
	public void setRemoveAbandoned(boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	
	
	
	
	
	

}
