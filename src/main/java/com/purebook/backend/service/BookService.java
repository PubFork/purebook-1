package com.purebook.backend.service;

import java.util.List;

import com.purebook.backend.dao.BookRepository;
import com.purebook.backend.dao.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purebook.backend.dao.BookDao;
import com.purebook.backend.dao.BookTagDao;
import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.Tag;

@Service
public class BookService {

	@Autowired
    BookRepository bookRepository;
	@Autowired
    TagRepository tagRepository;

	public Book findBookByID(int id){
		return bookRepository.findById(id);
	}

	public List<Book> findBookByTag(String tag){
		return tagRepository.findBook(tag);
	}

	public List<Book> findBookByName(String name){
		return bookRepository.findByName(name);
	}

	public List<Book> findTop250(){
		return bookRepository.findTop250();
	}

	public List<Book> findLatest(){
		return bookRepository.findLatest();
	}

	public List<Book> findHot(){
		return bookRepository.findHot();
	}

//	public List<Book> recommend(Integer id){
//		return bookRepository.recommend(id);
//	}
//
	public List<Book> findFavourite(Integer id){
		return bookRepository.findFavourite(id);
	}

	public List<Book> getReviewedBooks(Integer uid){
		return bookRepository.getReviewedBooks(uid);
	}
}
