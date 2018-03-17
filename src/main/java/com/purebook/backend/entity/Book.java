package com.purebook.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
	@JsonProperty(value="BookName")
	public String bookName;
	@JsonProperty(value="BookID")
	public int bookID;
	@JsonProperty(value="Author")
	public String author;
	@JsonProperty(value="AuthorIntro")
	public String authorIntro;
	@JsonProperty(value="Price")
	public String price;
	@JsonProperty(value="Intro")
	public String intro;
	@JsonProperty(value="Cover")
	public String cover;
	@JsonProperty(value="Publisher")
	public String publisher;
	@JsonProperty(value="ISBN")
	public String iSBN;
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthorIntro() {
		return authorIntro;
	}
	public void setAuthorIntro(String authorIntro) {
		this.authorIntro = authorIntro;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
