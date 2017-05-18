package com.my.sa.domain;

import com.mongodb.ReflectionDBObject;

/*
 * mongodb 
 * 访问记录*/
public class visitRecord extends ReflectionDBObject {
	
	private String account;
	private String ip;
	private String area;
	private String addressDetail;
	private String confidence;
	private String radius;
	private String visitTime;
	private String leaveTime;
	
	public visitRecord() {
		super();
	}
	
	public visitRecord(String account, String ip, String area, String addressDetail, String confidence,
			String radius, String visitTime, String leaveTime) {
		super();
		this.account = account;
		this.ip = ip;
		this.area = area;
		this.addressDetail = addressDetail;
		this.confidence = confidence;
		this.radius = radius;
		this.visitTime = visitTime;
		this.leaveTime = leaveTime;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getIp() {
		return ip;
	}
	public String getArea() {
		return area;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getConfidence() {
		return confidence;
	}
	public String getRadius() {
		return radius;
	}
	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}
	

}
