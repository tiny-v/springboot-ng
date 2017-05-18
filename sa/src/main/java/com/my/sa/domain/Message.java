package com.my.sa.domain;

public class Message {
	
	private String msgId;
	private String msgTitle;
	private String msgContent;
	private String msgType;
	private String createTime;
	private String createBy;
	private String updateTime;
	private String updateBy;
	
	public Message(){}
	
	public Message(String msgId, String msgTitle, String msgContent, String msgType, String createTime, String createBy,
			String updateTime, String updateBy) {
		super();
		this.msgId = msgId;
		this.msgTitle = msgTitle;
		this.msgContent = msgContent;
		this.msgType = msgType;
		this.createTime = createTime;
		this.createBy = createBy;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
	}
	
	public String getMsgId() {
		return msgId;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public String getMsgType() {
		return msgType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	

}
