package com.my.sa.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("mongoProperties")
@ConfigurationProperties(prefix = "spring.data.mongodb", ignoreUnknownFields = false)
public class MongoProperties {
	
	private String host;
	private Integer port;
	private String database;
	private String uri;
	private String username;
	private String password;
	
	public String getHost() {
		return host;
	}
	public Integer getPort() {
		return port;
	}
	public String getDatabase() {
		return database;
	}
	public String getUri() {
		return uri;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
