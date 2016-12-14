package com.my.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.my.sa.App;
import com.my.sa.dao.visitRecordDao;
import com.my.sa.domain.visitRecord;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringApplicationConfiguration(classes = App.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@Transactional
@Rollback(false)
public class junitTest {
	
	@Autowired
	private visitRecordDao vrDao;
	
	@Test
	public void save(){
		visitRecord vr = new visitRecord();
		vr.setArea("南京");
		vr.setIp("111.111.111.111");
		vrDao.saveVisitRecord(vr);
	}
	
	
	/*@Test
	public void mongoQuery(){
		List<visitRecord> vr = vrDao.findAll();
		System.out.println("vrsize:"+vr.size());
		for(visitRecord a:vr){
			System.out.println(JSONObject.fromObject(a).toString());
		}
	}*/

}
