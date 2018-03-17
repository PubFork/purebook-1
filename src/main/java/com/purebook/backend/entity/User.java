package com.purebook.backend.entity;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty(value="UserName")
	public String userName;
	@JsonProperty(value="UserID")
	public int userID;
	@JsonProperty(value="UserKey")
	public String userKey;
	@JsonProperty(value="Phone")
	public String phone;
	@JsonProperty(value="Portrait")
	public String portrait;
	@JsonProperty(value="Created")
	public Timestamp created;
	@JsonProperty(value="Desc")
	public String desc;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
