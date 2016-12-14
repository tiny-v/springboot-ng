package com.my.sa.configuration;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.stereotype.Component;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableConfigurationProperties(MongoProperties.class)
public class MongoConfig{

	@Autowired
	private MongoProperties properties;
	
	@Autowired(required = false)
	private MongoClientOptions options;
	
	private Mongo mongo;
	
	@PreDestroy
	public void close() {
		if (this.mongo != null) {
			this.mongo.close();
		}
	}
	
	@Bean
	public Mongo mongo() throws UnknownHostException {
		this.mongo = this.properties.createMongoClient(this.options);
		System.out.println("address:"+this.mongo.getAddress());
		return this.mongo;
	}  

}
