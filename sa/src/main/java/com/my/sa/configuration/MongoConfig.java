package com.my.sa.configuration;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;
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
	
	static Logger logger = Logger.getLogger(MongoConfig.class);

	@Autowired
	private  MongoProperties mongoProperties;//mongo配置信息

	private  DB db = null;

	private MongoClient mongoClient = null;

	private DBCollection dbCollection = null;

	private MongoClientOptions myOptions = null;

	//配置mongo客户端
	public void setClient(){
		MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		build.connectionsPerHost(100);// 与目标数据库可以建立的最大链接数
		build.connectTimeout(1000 * 60 * 20);// 与数据库建立链接的超时时间
		build.maxWaitTime(100 * 60 * 5);// 一个线程成功获取到一个可用数据库之前的最大等待时间
		build.threadsAllowedToBlockForConnectionMultiplier(100);
		build.maxConnectionIdleTime(0);
		build.maxConnectionLifeTime(0);
		build.socketTimeout(0);
		build.socketKeepAlive(true);
		this.myOptions = build.build();
		try {
			this.mongoClient =  new MongoClient(new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort()), myOptions);
		} catch (UnknownHostException e) {
			logger.error("mongo client init error");
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the database.
	 *
	 * @param dbName the db name
	 * @return the database
	 */
	public DB getDatabase(String dbName){
		if (this.mongoClient == null)
		{
			this.setClient();
		}
		if(dbName == null || ("").equals(dbName)){
			return this.mongoClient.getDB(mongoProperties.getDatabase());
		}else{
			return this.mongoClient.getDB(dbName);
		}
	}

	/**
	 * Gets the collection.
	 *
	 * @param dbName the db name
	 * @param collectionName the collection name
	 * @return the collection
	 */
	public DBCollection getCollection(String dbName,String collectionName) {
		db = this.getDatabase(dbName);
		if(db.authenticate(mongoProperties.getUsername(), mongoProperties.getPassword().toCharArray())){
			dbCollection = db.getCollection(collectionName);
		}else{
			logger.error("mongo connection error:invalid username or password");
			return null;
		}
		return dbCollection;
	}

	/**
	 * Gets the collection.
	 *
	 * @param collectionName the collection name
	 * @return the collection
	 */
	public DBCollection getCollection(String collectionName) {
		db = this.getDatabase("");
		if(db.authenticate(mongoProperties.getUsername(), mongoProperties.getPassword().toCharArray())){
			dbCollection = db.getCollection(collectionName);
		}else{
			logger.error("mongo connection error:invalid username or password");
			return null;
		}
		return dbCollection;
	}
}
