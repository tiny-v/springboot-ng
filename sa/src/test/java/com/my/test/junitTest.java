/*
 * 
 */
/*package com.my.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.DBCollection;
import com.my.sa.App;
import com.my.sa.configuration.MongoConfig;
import com.my.sa.configuration.properties.MongoProperties;
import com.my.sa.dao.visitRecordDao;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringApplicationConfiguration(classes = App.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@Transactional
@Rollback(false)
public class junitTest extends TestCase{
	
	@Autowired
	private visitRecordDao vrDao;
	@Autowired
	private MongoConfig mongoConfig;
	*/
	/**
	 * mongo save test
	 */
	/*
	@Test
	public void save(){
		try {
			DBCollection collection = null;
			for(int i=0;i<2;i++){
				collection = mongoConfig.getCollection("visitRecord");
				if(null != collection)
					System.out.println(collection.getFullName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}*/
