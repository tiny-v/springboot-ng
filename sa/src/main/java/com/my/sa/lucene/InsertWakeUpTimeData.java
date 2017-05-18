package com.my.sa.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.my.sa.configuration.MongoConfig;
/*
 * 向   mongo ->  wakeUpTime 中写入数据
 * Date: 2017-05-12
 * Author:  
 */
@Repository
public class InsertWakeUpTimeData {

	@Autowired
	private MongoConfig mongoConfig;

	//起床时间数据文件路径
	public  String filePath = "src/main/resources/source/wakeUpTime.csv";

	/**
	 * Read data from file.
	 */
	public void readDataFromFile(){
		ArrayList<DBObject> list = new ArrayList<DBObject>();
		File file = new File(filePath);
		if(file.exists()){//
			BufferedReader br = null;
			try{
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
				String temp = "";
				DBObject object = null;
				while((temp = br.readLine())!= null){
				  object = new BasicDBObject();
                  object.put("date", Arrays.asList(temp.split(",")).get(0));
                  object.put("time", Arrays.asList(temp.split(",")).get(1));
                  list.add(object);
				}
			}catch(Exception e){
				e.printStackTrace();        	   
			}finally{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(list.size()!=0){
					this.insert(list);
				}
			}
		}
	}


	/**
	 * Insert.
	 *
	 * @param list the list
	 */
	public void insert(List<DBObject> list){
		DBCollection collection = mongoConfig.getCollection("spring-ng","wakeUpTime");
		collection.insert(list);
	}

}
