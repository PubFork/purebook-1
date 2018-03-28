package com.purebook.backend.service;

import com.purebook.backend.dao.BookListRepository;
import com.purebook.backend.dao.ListUserRepository;
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

    public List<BookList> findByUserId(int userId) {
        return bookListRepository.searchByUserId(userId);
    }

    public boolean addListUser(int userId, String listName) {
        return listUserRepository.save(new ListUser(userId, bookListRepository.findByName(listName).getId())) != null;
    }

    public boolean deleteByUserIdAndName(int userId, String name) {
        return listUserRepository.deleteByUserIdAndListId(userId, bookListRepository.findByName(name).getId()) == 1;
    }

    public boolean isCollectedList(int userId, String name) {
        return listUserRepository.getByUserIdAndListId(userId, bookListRepository.findByName(name).getId()) != null;
    }

    public List<BookList> findByNameLike(String nameLike) {
        return bookListRepository.findByNameContaining(nameLike);
    }
}
