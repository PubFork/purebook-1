package com.purebook.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Excerpt {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private int bookId;

    private String content;

    @Column(name = "create_time")
    private Timestamp createTime;

    public Excerpt() {}

    public Excerpt(int userId, int bookId, String content, Timestamp createTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.content = content;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
