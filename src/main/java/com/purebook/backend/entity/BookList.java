package com.purebook.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "booklist")
public class BookList {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String intro;

    @Column(name = "user_id")
    private String userId;

    private String cover;

    public BookList() {}

    public BookList(String name, String userId) { this.name = name; this.userId = userId; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
