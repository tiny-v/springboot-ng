package com.my.sb.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

//springboot中配置分布式事务Atomikos
public class AtomikosDataSourceConfig {
	/*
	@Autowired
	private TomDataSourceConfig datasource;
	*/
	/**
	 * mysql数据库的 XA datasource
	 *
	 * @return
	 */
	/*@Bean
	@Primary
	@Qualifier("dataSourceConfig")
	public AtomikosDataSourceBean db1DataSourceBean() {
	    AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
	    atomikosDataSourceBean.setUniqueResourceName("tomcatDatasource");
	    atomikosDataSourceBean.setXaDataSourceClassName(
	            "com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
	    Properties properties = new Properties();
	    properties.put("URL", datasource.getUrl());
	    properties.put("user", datasource.getUsername());
	    properties.put("password", datasource.getPassword());
	    atomikosDataSourceBean.setXaProperties(properties);
	    return atomikosDataSourceBean;
	}*/
	
	/**
	 * 构造mysql 数据库的 sessionFactory
	 *
	 * @return
	 */
	/*@Bean
	@Autowired
	public AnnotationSessionFactoryBean sessionFactory(@Qualifier("db1") AtomikosDataSourceBean atomikosDataSourceBean) {
	    AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
	    sessionFactory.setDataSource(atomikosDataSourceBean);
	    sessionFactory.setPackagesToScan(db1_entity_package);
	    Properties properties = new Properties();
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
	    properties.put("hibernate.show_sql", "false");
	    properties.put("hibernate.format_sql", "format");
	    properties.put("hibernate.connection.autocommit", "true");
	    properties.put("hibernate.connection.url", atomikosDataSourceBean.getXaProperties().get("URL"));
	    properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	    sessionFactory.setHibernateProperties(properties);
	    return sessionFactory;
	}*/

}
