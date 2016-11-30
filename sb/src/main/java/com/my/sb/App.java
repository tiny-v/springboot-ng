package com.my.sb;

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
import com.my.sb.core.filter.ServletFilter;

//@ServletComponentScan(value = {"com.my.sb.filter.ServletFilter"})//1.3以后才有
@SpringBootApplication
//@EnableAutoConfiguration
@EnableTransactionManagement
public class App{

	static Logger log = Logger.getLogger(App.class);

	/*@Bean
	public ServletRegistrationBean  serv(){
		return new ServletRegistrationBean(new MyServlet1(),"/servlet/*");
	}*/
	
	/**
	 * Security filter.
	 *
	 * @return the filter registration bean
	 */
	@Bean
	public FilterRegistrationBean securityFilter() {
		ServletFilter filter = new ServletFilter();
		filter.setLoginUrl("/app/index.html#/login");

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filter);
		registration.addUrlPatterns("/*");
		registration.setName("securityFilter");
		return registration;
	}

	// 其中 dataSource 框架会自动为我们注入
	//手动注入我们需要的事务管理器
	@Bean(name="txManager1")
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	public static void main( String[] args )
	{
		ApplicationContext ac= SpringApplication.run(App.class, args);
	}
}
