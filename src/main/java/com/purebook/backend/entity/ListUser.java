package com.purebook.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListUser {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "list_id")
    private int listId;

    public ListUser() {}

    public ListUser(String userId, int listId) {
        this.userId = userId;
        this.listId = listId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getListName() {
        return listId;
    }

    public void setListName(int listId) {
        this.listId = listId;
    }
}
