package com.my.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.my.sa.App;
import com.my.sa.domain.Message;
import com.my.sa.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringApplicationConfiguration(classes = App.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@Transactional
@Rollback(false)
public class junitTest {
	
	@Autowired
	private MessageService messageService;
	
	@Test
	public void test(){
		
	}
	
	@Test
	public void insertMessage(){
		Message message = new Message();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		message.setMsgId(String.valueOf((int)(Math.random()*1000)));
        message.setMsgContent("hello transaction");
        message.setMsgTitle("go go go,basketball");
        message.setMsgType("test");
        message.setCreateBy("may");
        message.setCreateTime(format.format(new Date()));
        message.setUpdateBy("may");
        message.setUpdateTime(format.format(new Date()));
        messageService.insertMessage(message);
	}

}
