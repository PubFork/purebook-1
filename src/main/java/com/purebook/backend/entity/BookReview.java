package com.purebook.backend.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookReview {

	@JsonProperty(value="BookID")
	public int bookID;
	@JsonProperty(value="UserID")
	public int userID;
	@JsonProperty(value="Review")
	public String review;
	@JsonProperty(value="Time")
	public Timestamp time;
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
