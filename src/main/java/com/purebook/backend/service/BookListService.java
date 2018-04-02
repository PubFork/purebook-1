package com.purebook.backend.service;

import com.purebook.backend.dao.BookListRepository;
import com.purebook.backend.dao.BooklistBookRepository;
import com.purebook.backend.dao.ListUserRepository;
import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.BookList;
import com.purebook.backend.entity.ListUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookListService {
    @Autowired
    BookListRepository bookListRepository;

    @Autowired
    ListUserRepository listUserRepository;

    @Autowired
    BooklistBookRepository booklistBookRepository;

    public List<BookList> findByUserId(String userId) {
        return bookListRepository.searchByUserId(userId);
    }

    public boolean addListUser(String userId, String listName) {
        return listUserRepository.save(new ListUser(userId, bookListRepository.findByName(listName).getId())) != null;
    }

    public boolean deleteByUserIdAndName(String userId, String name) {
        return listUserRepository.deleteByUserIdAndListId(userId, bookListRepository.findByName(name).getId()) == 1;
    }

    public boolean isCollectedList(String userId, String name) {
        return listUserRepository.getByUserIdAndListId(userId, bookListRepository.findByName(name).getId()) != null;
    }

    public List<BookList> findByNameLike(String nameLike) {
        return bookListRepository.findByNameContaining(nameLike);
    }

    public List<Book> searchBookByBooklistId(String userId, int booklistId) {
        return booklistBookRepository.searchByBooklistId(userId, booklistId);
    }
}
