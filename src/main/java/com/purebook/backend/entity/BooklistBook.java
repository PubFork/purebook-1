package com.purebook.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "booklist_book")
public class BooklistBook {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "booklist_id")
    private int bookListId;

    public BooklistBook() {}

    public BooklistBook(int bookId, int bookListId) {
        this.bookId = bookId;
        this.bookListId = bookListId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getBookListId() {
        return bookListId;
    }

    public void setBookListId(int bookListId) {
        this.bookListId = bookListId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
