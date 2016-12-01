package com.my.sa;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.my.sa.core.filter.ServletFilter;
import com.my.sa.core.security.interceptor.SecurityInterceptor;

//@ServletComponentScan(value = {"com.my.sb.filter.ServletFilter"})//1.3以后才有
@SpringBootApplication
//@EnableAutoConfiguration
@EnableTransactionManagement
public class App{

	static Logger log = Logger.getLogger(App.class);

	// 其中 dataSource 框架会自动为我们注入
	//手动注入我们需要的事务管理器
	@Bean(name="txManager1")
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	//添加拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SecurityInterceptor());
	}

	public static void main( String[] args )
	{
		ApplicationContext ac= SpringApplication.run(App.class, args);
	}
}
