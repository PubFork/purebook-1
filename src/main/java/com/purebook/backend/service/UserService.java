package com.purebook.backend.service;

import com.purebook.backend.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purebook.backend.entity.User;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
	    return userRepository.save(user);
    }

    public User findUserById(String userId) {
        return userRepository.findByUserId(userId);
    }

}
