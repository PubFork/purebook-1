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

//	@Autowired
//	BookDao bookDao;
//	@Autowired
//	BookTagDao bookTagDao;
//
//	public Book findBookbyID(int id){
//		return bookDao.findBookbyID(id);
//	}
//
//	public List<Book> findBookbyTag(String tag){
//		return bookTagDao.findBook(tag);
//	}
//
//	public List<Book> findBookbyName(String name){
//		return bookDao.findBookbyName(name);
//	}
//
//	public List<Book> findTop250(){
//		return bookDao.findTop250();
//	}
//
//	public List<Book> findLatest(){
//		return bookDao.findLatest();
//	}
//
//	public List<Book> findHotest(){
//		return bookDao.findHotest();
//	}
//
//	public List<Book> recommend(Integer id){
//		return bookDao.recommend(id);
//	}
//
//	public List<Book> findCollection(Integer id){
//		return bookDao.findCollection(id);
//	}
//
//	public List<Book> getReviewedBooks(Integer uid){
//		return bookDao.getReviewedBooks(uid);
//	}

	@Autowired
    BookRepository bookRepository;
	@Autowired
    TagRepository tagRepository;

	public Book findBookbyID(int id){
		return bookRepository.findById(id);
	}

	public List<Book> findBookbyTag(String tag){
		return tagRepository.findBook(tag);
	}

	public List<Book> findBookbyName(String name){
		return bookRepository.findByName(name);
	}

	public List<Book> findTop250(){
		return bookRepository.findTop250();
	}

	public List<Book> findLatest(){
		return bookRepository.findLatest();
	}

	public List<Book> findHotest(){
		return bookRepository.findHotest();
	}

//	public List<Book> recommend(Integer id){
//		return bookRepository.recommend(id);
//	}
//
//	public List<Book> findCollection(Integer id){
//		return bookRepository.findCollection(id);
//	}

	public List<Book> getReviewedBooks(Integer uid){
		return bookRepository.getReviewedBooks(uid);
	}
}
