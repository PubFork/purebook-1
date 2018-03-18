package com.purebook.backend.entity;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User {

    @Id
    @GeneratedValue
	private int id;
	//@JsonProperty(value="UserName")
	private String name;
	//@JsonProperty(value="UserID")

	//@JsonProperty(value="UserKey")
	private String password;
	//@JsonProperty(value="Phone")
	private String phone;
	//@JsonProperty(value="Portrait")
	private String portrait;
	//@JsonProperty(value="Created")
	private Timestamp created;
	//@JsonProperty(value="Desc")
	private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
