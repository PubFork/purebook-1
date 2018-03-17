package com.purebook.backend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.purebook.backend.entity.Book;


//与book表交互
@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Book findBookbyID(int id){
		List<Book> bookList=jdbcTemplate.query("select * from Book where BookID = ?", 
				new Object[]{id}, new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			Book book=bookList.get(0);
			return book;
		}
		return null;
	}
	
	public List<Book> findBookbyTag(String tag){
		List<Book> bookList=jdbcTemplate.query("select * from Book where BookTag = ?", 
				new Object[]{tag}, new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			return bookList;
		}
		return null;
	}
	
	public List<Book> findBookbyName(String name){
		name="%"+name+"%";
		List<Book> bookList=jdbcTemplate.query("select * from Book "
				+ "where BookName like ? order by rand() limit 10", 
				new Object[]{name}, new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			return bookList;
		}
		return null;
	}
	
	public List<Book> findTop250(){
		List<Book> bookList=jdbcTemplate.query("select * from Book where BookID in "
				+ "(select BookID from UserBook "
				+ "		group by BookID having Count(UserID) >7)  "
				+ "order by rand() limit 40;", new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			return bookList;
		}
		return null;
	}
	
	public List<Book> findLatest(){
		List<Book> bookList=jdbcTemplate.query("select * from Book where BookID > 27000000 order by rand() limit 40", new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			return bookList;
		}
		return null;
	}
	
	public List<Book> findHotest(){
		List<Book> bookList=jdbcTemplate.query("select * from Book where BookID in "
				+ "(select BookID from BookReview group by BookID having Count(UserID) >1)"
				+ " order by rand() limit 40;", new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			return bookList;
		}
		return null;
	}
	
	public List<Book> recommend(Integer id){
		List<Book> bookList=jdbcTemplate.query("select * from Book where BookID in "
				+ "(select distinct BookID from UserBook  where UserID in "
				+ "(select B.UserID from UserBook as A join UserBook as B on A.BookID=B.BookID "
				+ 		"where A.UserID=? AND B.UserID!=A.UserID)) "
				+ "order by rand() limit 20;", new Object[]{id}, new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			return bookList;
		}
		return null;
	}
	
	public List<Book> findCollection(Integer id){
		List<Book> bookList=jdbcTemplate.query("select * from Book where BookID in	"
				+ "(select BookID from UserBook where UserID = ?);",
				new Object[]{id}, new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			return bookList;
		}
		return null;
	}
	
	public List<Book> getReviewedBooks(Integer uid){
		List<Book> bookList=jdbcTemplate.query("select * from Book where BookID in"
				+ "(select BookID from BookReview where UserID = ?);",
				new Object[]{uid}, new BeanPropertyRowMapper(Book.class));
		if(bookList!=null&&bookList.size()>0){
			return bookList;
		}
		return null;
	}
}
