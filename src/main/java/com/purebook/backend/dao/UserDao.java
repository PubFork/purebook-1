package com.purebook.backend.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.purebook.backend.entity.User;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;


@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User add(User user) {
        jdbcTemplate.update("insert into User(UserName, UserKey, Created) "
        		+ "values(?, ?, ?)",user.getUserName(),user.getUserKey(), user.getCreated());
        List<User> userList=jdbcTemplate.query("select * from User where UserID = (select max(UserID) from User);", new BeanPropertyRowMapper(User.class));
		if(userList!=null&&userList.size()>0){
			User user2=userList.get(0);
			return user2;
		}
		return null;
	}
	

	public User findUserbyID(int id){
		List<User> userList=jdbcTemplate.query("select * from User where UserID = ?", new Object[]{id}, new BeanPropertyRowMapper(User.class));
		if(userList!=null&&userList.size()>0){
			User user=userList.get(0);
			return user;
		}
		return null;
	}
}
