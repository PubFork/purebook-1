package com.purebook.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purebook.backend.dao.BookDao;
import com.purebook.backend.dao.BookTagDao;
import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.Tag;

@Service
public class BookService {

	@Autowired
	BookDao bookDao;
	@Autowired
	BookTagDao bookTagDao;
	
	public Book findBookbyID(int id){
		return bookDao.findBookbyID(id);
	}
	
	public List<Book> findBookbyTag(String tag){
		return bookTagDao.findBook(tag);
	}
	
	public List<Book> findBookbyName(String name){
		return bookDao.findBookbyName(name);
	}
	
	public List<Book> findTop250(){
		return bookDao.findTop250();
	}
	
	public List<Book> findLatest(){
		return bookDao.findLatest();
	}
	
	public List<Book> findHotest(){
		return bookDao.findHotest();
	}
	
	public List<Book> recommend(Integer id){
		return bookDao.recommend(id);
	}
	
	public List<Book> findCollection(Integer id){
		return bookDao.findCollection(id);
	}
	
	public List<Book> getReviewedBooks(Integer uid){
		return bookDao.getReviewedBooks(uid);
	}
}
