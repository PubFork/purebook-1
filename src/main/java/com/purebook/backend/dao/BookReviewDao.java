package com.purebook.backend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.purebook.backend.entity.BookReview;

@Repository
public class BookReviewDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<BookReview> findbyUserID(Integer userid){
		List<BookReview> bookReviews =jdbcTemplate.query("select * from BookReview where UserID = ?", new Object[]{userid}, new BeanPropertyRowMapper(BookReview.class));
		if(bookReviews!=null&&bookReviews.size()>0){
			return bookReviews;
		}
		return null;
	}

	public List<BookReview> findbyBookID(Integer bookid){
		List<BookReview> bookReviews =jdbcTemplate.query("select * from BookReview where BookID = ?", new Object[]{bookid}, new BeanPropertyRowMapper(BookReview.class));
		if(bookReviews!=null&&bookReviews.size()>0){
			return bookReviews;
		}
		return null;
	}

//	public int add(BookReview bReview) {
//        return jdbcTemplate.update("insert into BookReview(UserID, BookID, Review, Time) "
//        		+ "values(?, ?, ?, ?)",bReview.userID,bReview.bookID,bReview.review,bReview.time);
//    }
}
