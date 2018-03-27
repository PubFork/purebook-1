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
        List<ListUser> listUsers = listUserRepository.findByUserId(userId);
        List<BookList> bookLists = new ArrayList<>();
        for (ListUser i : listUsers) {
            bookLists.add(bookListRepository.findById(i.getId()));
        }
        return bookLists;
    }

    public ListUser addListUser(int userId, String listName) {
        return listUserRepository.save(new ListUser(userId, bookListRepository.findByName(listName).getId()));
    }

    public int deleteByUserIdAndName(int userId, String name) {
        return listUserRepository.deleteByUserIdAndBookId(userId, bookListRepository.findByName(name).getId());
    }

    public boolean isCollectedList(int userId, String name) {
        return listUserRepository.getByUserIdAndName(userId, name)!=null;
    }

    public List<BookList> findByNameLike(String nameLike) {
        return bookListRepository.findByNameContaining(nameLike);
    }
}
