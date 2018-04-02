package com.purebook.backend.service;

import java.sql.Timestamp;
import java.util.List;

import com.purebook.backend.dao.BookReviewRepository;
import com.purebook.backend.dao.UserRepository;
import com.purebook.backend.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;
import com.purebook.backend.dao.BookReviewDao;
import com.purebook.backend.entity.BookReview;

@Service
public class BookReviewService {
    @Autowired
    BookReviewRepository bookReviewRepository;
    @Autowired
    UserRepository userRepository;

    public List<BookReview> findByUserID(String userid){
        return bookReviewRepository.findByUserId(userid);
    }

    public List<BookReview> findByBookID(int bookid){
        return bookReviewRepository.findByBookId(bookid);
    }

    public boolean writeReview(int bookId, String userId, String review, String title) {
        return bookReviewRepository.save(new BookReview(bookId, userId,
                userRepository.findByUserId(userId).getName(),
                userRepository.findByUserId(userId).getAvatar(),
                review, new Timestamp(System.currentTimeMillis()), title)) != null;
    }

    public BookReview findById(int id) {
        return bookReviewRepository.findById(id);
    }
}
