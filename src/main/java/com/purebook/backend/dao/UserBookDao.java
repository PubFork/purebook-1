package com.purebook.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.purebook.backend.entity.Book;

@Repository
public class UserBookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addCollection(Integer uid, Integer bid){
		return jdbcTemplate.update("insert into UserBook(UserID, BookID) "
        		+ "values(?, ?)", uid ,bid);
	}
	
	public int removeCollection(Integer uid, Integer bid){
		return jdbcTemplate.update("delete from UserBook "
				+ "where UserID = ? and BookID = ?", uid ,bid);
	}
	
	public int isCollected(Integer uid, Integer bid){
		Integer count =  jdbcTemplate.queryForObject("select count(*) from UserBook where UserID = ? and BookID = ?", 
				 Integer.class,uid, bid);
		return count;
	}
	
}
