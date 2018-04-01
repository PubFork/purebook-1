package com.purebook.backend.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class BookReview {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(nullable = false)
    private String review;
    @Column(nullable = false)
    private Timestamp time;

    private String title;

    public BookReview() {}

    public BookReview(int bookId, String userId, String review, Timestamp time, String title) {
        this.bookId = bookId;
        this.userId = userId;
        this.review = review;
        this.time = time;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
