package com.purebook.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {

	@JsonProperty(value="BookID")
	public Integer bookID;
	@JsonProperty(value="Field")
	public String field;
	@JsonProperty(value="Count")
	public Integer count;
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
