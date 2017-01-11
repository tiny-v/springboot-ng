package com.my.sa.configuration;

import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.my.sa.configuration.properties.MongoProperties;

@Configuration
public class MongoConfig{

	@Autowired
	private  MongoProperties mongoProperties;//mongo配置信息

	private DB db = null;

	private  MongoClient mongoClient = null;

	private DBCollection dbCollection = null;

	private MongoClientOptions myOptions = null;

	//配置mongo客户端
	public void setClient(){
		MongoClientOptions.Builder buide = new MongoClientOptions.Builder();
		buide.connectionsPerHost(100);// 与目标数据库可以建立的最大链接数
		buide.connectTimeout(1000 * 60 * 20);// 与数据库建立链接的超时时间
		buide.maxWaitTime(100 * 60 * 5);// 一个线程成功获取到一个可用数据库之前的最大等待时间
		buide.threadsAllowedToBlockForConnectionMultiplier(100);
		buide.maxConnectionIdleTime(0);
		buide.maxConnectionLifeTime(0);
		buide.socketTimeout(0);
		buide.socketKeepAlive(true);
		this.myOptions = buide.build();
		try {
			this.mongoClient =  new MongoClient(new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort()), myOptions);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
    //根据数据库名称,获取数据库
	public DB getDatabase(String dbName){
		if (mongoClient == null)
		{
			this.setClient();
		}
		if(dbName == null || ("").equals(dbName)){
			return mongoClient.getDB(mongoProperties.getDatabase());
		}else{
			return mongoClient.getDB(dbName);
		}
	}
	
	//根据dbName 和 collectionName 获取 Collection
	public DBCollection getCollection(String dbName,String collectionName) {
		db = this.getDatabase(dbName);
		if(db.authenticate(mongoProperties.getUsername(), mongoProperties.getPassword().toCharArray())){
			dbCollection = db.getCollection(collectionName);
		}
		return dbCollection;
	}
	
	//collectionName 获取 Collection
	public DBCollection getCollection(String collectionName) {
		db = this.getDatabase("");
		if(db.authenticate(mongoProperties.getUsername(), mongoProperties.getPassword().toCharArray())){
			dbCollection = db.getCollection(collectionName);
		}
		return dbCollection;
	}
}
