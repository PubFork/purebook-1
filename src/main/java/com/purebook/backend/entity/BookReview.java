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
    private int userId;
    @Column(nullable = false)
    private String review;
    @Column(nullable = false)
    private Timestamp time;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
