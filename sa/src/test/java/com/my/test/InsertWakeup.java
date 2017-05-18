/*package com.my.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.my.sa.App;
import com.my.sa.lucene.InsertWakeUpTimeData;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringApplicationConfiguration(classes = App.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@Transactional
//@Rollback(false)
public class InsertWakeup extends TestCase{
	
	@Autowired
	private InsertWakeUpTimeData i;
	
	@Test
	public void test(){
		i.readDataFromFile();
	}

}*/
