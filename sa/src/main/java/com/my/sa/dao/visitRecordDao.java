package com.my.sa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.my.sa.core.util.page.Page;
import com.my.sa.domain.visitRecord;

@Repository
public class visitRecordDao implements MongoRepository<visitRecord,String>{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<visitRecord> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<visitRecord> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends visitRecord> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends visitRecord> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends visitRecord> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	public Page findAll(Pageable pageable) {
		Query query = new Query();
		long count = mongoTemplate.count(query,"visitRecord");
		Page page = new Page(pageable.getPageNumber(),pageable.getPageSize(),count);
		page.setTotalPage();
		query.skip(page.getFirstResult());// skip相当于从那条记录开始  
        query.limit(page.getPageSize());// 从skip开始,取多少条记录
        query.with(new Sort(Direction.DESC, "visitTime"));
        page.setDatas(mongoTemplate.find(query, visitRecord.class)); 
        return page;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(visitRecord arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Iterable<? extends visitRecord> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterable<visitRecord> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public visitRecord findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	public visitRecord findByIp(String Ip) {
		// TODO Auto-generated method stub
		return null;
	}


	public void saveVisitRecord(visitRecord vr) {
		mongoTemplate.save(vr,"visitRecord");
	}


	@Override
	public <S extends visitRecord> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
