package com.purebook.backend.service;

import com.purebook.backend.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.purebook.backend.dao.UserDao;
import com.purebook.backend.entity.User;

@Service
public class UserService {

//	@Autowired
//	UserDao userDao;

//	public User add(User user){
//		return userDao.add(user);
//	}
//	public User findUserbyID(int id){
//		return userDao.findUserbyID(id);
//	}

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
	    return userRepository.save(user);
    }

    public User findUserById(int id) {
        return userRepository.findById(id);
    }

}
