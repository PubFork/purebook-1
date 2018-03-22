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

//	@Autowired
//	BookReviewDao bookReviewDao;
//
//	public List<BookReview> findbyUserID(Integer userid){
//		return bookReviewDao.findbyUserID(userid);
//	}
//
//	public List<BookReview> findbyBookID(Integer bookid){
//		return bookReviewDao.findbyBookID(bookid);
//	}
//
//	public int writeReview(Integer uid, Integer bid, String review){
//		BookReview bookReview = new BookReview();
//		bookReview.setBookID(bid);
//		bookReview.setUserID(uid);
//		bookReview.setReview(review);
//		bookReview.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
//		return bookReviewDao.add(bookReview);
//		return 1;
//	}

    @Autowired
    BookReviewRepository bookReviewRepository;

    public List<BookReview> findbyUserID(int userid){
        return bookReviewRepository.findByUserId(userid);
    }

    public List<BookReview> findbyBookID(int bookid){
        return bookReviewRepository.findByBookId(bookid);
    }

    public int writeReview(int bookId, int userId, String review){
        if(bookReviewRepository.save(
                new BookReview(bookId, userId, review, new Timestamp(System.currentTimeMillis()))) == null) {
            return 0;
        }
        return 1;
    }
}
