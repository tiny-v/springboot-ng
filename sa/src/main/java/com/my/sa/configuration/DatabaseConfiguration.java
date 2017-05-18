package com.my.sa.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * The Class DatabaseConfiguration.
 */
//method one

@Configuration
public class DatabaseConfiguration {
	
	@Autowired
	private DataSource datasource;
	
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(datasource);
    }
	
}

// method two

/*@Configuration
public class DatabaseConfiguration {
	
	@Resource
	private DataSourceProperties dataSourceProperties;
	
	@Bean
    public DataSource dataSource() {
        return getTomcatPoolingDataSource(dataSourceProperties);
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.dataSource());
    }
    
	private DataSource getTomcatPoolingDataSource(DataSourceProperties config) {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());
        dataSource.setInitialSize(config.getInitialSize()); // 连接池启动时创建的初始化连接数量（默认值为0）
        dataSource.setMaxActive(config.getMaxActive()); // 连接池中可同时连接的最大的连接数
        dataSource.setMaxIdle(config.getMaxIdle()); // 连接池中最大的空闲的连接数，超过的空闲连接将被释放，如果设置为负数表示不限
        dataSource.setMinIdle(config.getMinIdle()); // 连接池中最小的空闲的连接数，低于这个数量会被创建新的连接
        dataSource.setMaxWait(config.getMaxWait()); // 最大等待时间，当没有可用连接时，连接池等待连接释放的最大时间，超过该时间限制会抛出异常，如果设置-1表示无限等待
        dataSource.setRemoveAbandonedTimeout(config.getRemoveAbandonedTimeout()); // 超过时间限制，回收没有用(废弃)的连接
        dataSource.setRemoveAbandoned(config.isRemoveAbandoned()); // 超过removeAbandonedTimeout时间后，是否进 行没用连接（废弃）的回收
        dataSource.setTestOnBorrow(config.isTestOnBorrow());
        dataSource.setTestOnReturn(config.isTestOnReturn());
        dataSource.setTestWhileIdle(config.isTestWhileIdle());
        dataSource.setValidationQuery(config.getValidationQuery());
        dataSource.setTimeBetweenEvictionRunsMillis(config.getTimeBetweenEvictionRunsMillis()); // 检查无效连接的时间间隔 设为30分钟
        return dataSource;
    }
}*/
