package com.my.sa;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.my.sa.configuration.properties.AliyunOSSProperties;
import com.my.sa.core.security.interceptor.SecurityInterceptor;
import com.my.sa.core.util.AliyunOSSUtil;

//@ServletComponentScan(value = {"com.my.sb.filter.ServletFilter"})//1.3以后才有
@SpringBootApplication
//@EnableAutoConfiguration
@EnableTransactionManagement
@ServletComponentScan 
@EnableAutoConfiguration
@EnableConfigurationProperties(AliyunOSSProperties.class)
public class App implements CommandLineRunner{

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
	
	@Autowired
    private AliyunOSSProperties aliyunOSS;

    @Override
    public void run(String... strings) throws Exception {
        AliyunOSSUtil.init(aliyunOSS);//初始化阿里云OSS
    }

	public static void main( String[] args )
	{
		ApplicationContext ac= SpringApplication.run(App.class, args);
	}
}
