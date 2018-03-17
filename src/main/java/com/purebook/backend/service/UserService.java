package com.purebook.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.purebook.backend.dao.UserDao;
import com.purebook.backend.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User add(User user){
		return userDao.add(user);
	}
	
	public User findUserbyID(int id){
		return userDao.findUserbyID(id);
	}
}
