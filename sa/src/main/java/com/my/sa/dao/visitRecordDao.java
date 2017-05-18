package com.my.sa.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.my.sa.configuration.MongoConfig;
import com.my.sa.core.util.page.Page;
import com.my.sa.domain.visitRecord;

@Repository
public class visitRecordDao {
	
	@Autowired
	private MongoConfig mongoConfig;
	
	public Page findAll(Pageable pageable) {
		DBCollection collection = mongoConfig.getCollection("visitRecord");//获取collection
		long count = collection.count();//查询总数
		DBCursor cursor = collection.find().sort(new BasicDBObject("visitTime",-1)).skip((pageable.getPageNumber()-1)*pageable.getPageSize()).limit(pageable.getPageSize());//查询数据
		List<DBObject> result = new ArrayList<DBObject>();
		cursor.forEachRemaining(res -> result.add(res));
		Page page = new Page(pageable.getPageNumber(),pageable.getPageSize(),count);
		page.setDatas(result);
		page.setTotalPage();
        return page;
	}


	public visitRecord findByIp(String Ip) {
		// TODO Auto-generated method stub
		return null;
	}


	public void saveVisitRecord(visitRecord vr) {
		DBCollection collection = mongoConfig.getCollection("visitRecord");//获取collection
		collection.insert(vr);
	}


	


	

}
