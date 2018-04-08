package com.purebook.backend.service;

import java.util.List;

import com.purebook.backend.dao.BookRepository;
import com.purebook.backend.dao.TagRepository;
import com.purebook.backend.util.RandomList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purebook.backend.entity.Book;

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

	public List<Book> findByNameLike(String nameLike){
		return bookRepository.findByNameLike("%" + nameLike + "%");
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

	public List<Book> findFavourite(String id){
		return bookRepository.findFavourite(id);
	}

	public List<Book> getReviewedBooks(String uid){
	    return bookRepository.getReviewedBooks(uid);
	}

    public List<Book> findWorkByNameLike(String name) {
        return bookRepository.findWorkByNameLike("%" + name + "%");
    }
}
