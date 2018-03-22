//package com.purebook.backend.dao;
//
//import java.util.List;
//
//import javax.print.DocFlavor.STRING;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.purebook.backend.entity.Book;
//import com.purebook.backend.entity.Tag;
//
//@Repository
//public class BookTagDao {
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	public List<Book> findBook(String tag){
//		List<Book> bookList=jdbcTemplate.query("select * from  Book where BookID in "
//				+ "(select BookID from BookTag where Field = ?  ) order by rand() limit 10 ;"
//				, new Object[]{tag}, new BeanPropertyRowMapper(Book.class));
//		if(bookList!=null&&bookList.size()>0){
//			return bookList;
//		}
//		return null;
//	}
//
//	public List<Tag> findTag(int id){
//		List<Tag> tags=jdbcTemplate.query("(select * from BookTag where BookID = ?)"
//				, new Object[]{id}, new BeanPropertyRowMapper(Tag.class));
//		if(tags!=null&&tags.size()>0){
//			return tags;
//		}
//		return null;
//	}
//
//	public List<Tag> getTag(){
//		List<Tag> tags=jdbcTemplate.query("(select * from BookTag where Count>10 order by rand() limit 200)"
//				, new BeanPropertyRowMapper(Tag.class));
//		if(tags!=null&&tags.size()>0){
//			return tags;
//		}
//		return null;
//	}
//}