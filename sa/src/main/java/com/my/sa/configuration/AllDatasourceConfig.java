package com.my.sa.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AllDatasourceConfig {
	
	/*@Bean
    @ConfigurationProperties(prefix="spring.datasource")
	public DataSource tomcatDataSource(){
		return new DriverManagerDataSource();
	}*/
	

}
