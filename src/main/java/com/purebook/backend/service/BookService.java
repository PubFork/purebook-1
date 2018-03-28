package com.purebook.backend.service;

import java.util.List;

import com.purebook.backend.dao.BookRepository;
import com.purebook.backend.dao.TagRepository;
import com.purebook.backend.util.RandomList;
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
        RandomList randomList = new RandomList();
		return randomList.getRandomList(tagRepository.findBook(tag), 10);
	}

	public List<Book> findBookByName(String name){
		return bookRepository.findByName(name);
	}

	public List<Book> findTop250(){
        RandomList randomList = new RandomList();
        return randomList.getRandomList(bookRepository.findTop250(), 40);
	}

	public List<Book> findLatest(){
	    RandomList randomList = new RandomList();
		return randomList.getRandomList(bookRepository.findLatest(), 40);
	}

	public List<Book> findHot(){
        RandomList randomList = new RandomList();
        return randomList.getRandomList(bookRepository.findHot(), 40);
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
