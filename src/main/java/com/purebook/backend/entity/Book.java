package com.purebook.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	//@JsonProperty(value="BookName")
    @Id
    @GeneratedValue
    private int id;

	private String name;
	//@JsonProperty(value="id")

	//@JsonProperty(value="Author")
	private String author;
	//@JsonProperty(value="AuthorIntro")
	private String authorIntro;
	//@JsonProperty(value="Price")
	private String price;
	//@JsonProperty(value="Intro")
	private String intro;
	//@JsonProperty(value="Cover")
	private String cover;
	//@JsonProperty(value="Publisher")
	private String publisher;
	//@JsonProperty(value="ISBN")
	private String ISBN;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
