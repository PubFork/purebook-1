package com.purebook.backend.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BookReview {

    @Id
    @GeneratedValue
    private int reviewId;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

//	@JsonProperty(value="BookID")
//	private int bookID;
//	@JsonProperty(value="UserID")
//	private int userId;
//	@JsonProperty(value="Review")
	private String review;
	private Timestamp time;
	public int getReviewId() { return reviewId; }
	public void setReviewId(int reviewId) { this.reviewId = reviewId; }

    public Book getBook() {
        return book;
    }
    public Book setBook(Book book) {
	    return this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    //	public int getBookID() {
//		return bookID;
//	}
//	public void setBookID(int bookID) {
//		this.bookID = bookID;
//	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
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
