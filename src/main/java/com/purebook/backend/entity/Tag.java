package com.purebook.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Tag {

    @Id
    @GeneratedValue
	private int tagId;
	//@JsonProperty(value="BookID")
	//private int bookID;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "book_id")
    private Book book;

	//@JsonProperty(value="Field")
    @Column(nullable = false)
	private String field;
	//@JsonProperty(value="Count")
	private int count;
//	public int getBookID() {
//		return bookID;
//	}
//	public void setBookID(int bookID) {
//		this.bookID = bookID;
//	}

    public int getTagId() {
        return tagId;
    }
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
