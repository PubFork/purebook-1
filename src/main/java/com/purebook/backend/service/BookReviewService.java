package com.purebook.backend.service;

import java.sql.Timestamp;
import java.util.List;

import com.purebook.backend.dao.BookReviewRepository;
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

    public List<BookReview> findByUserID(String userid){
        return bookReviewRepository.findByUserId(userid);
    }

    public List<BookReview> findByBookID(int bookid){
        return bookReviewRepository.findByBookId(bookid);
    }

    public boolean writeReview(int bookId, String userId, String review) {
        return bookReviewRepository.save(new BookReview(bookId, userId, review, new Timestamp(System.currentTimeMillis()))) != null;
    }
}
