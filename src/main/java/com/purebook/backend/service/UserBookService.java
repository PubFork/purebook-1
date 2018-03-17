package com.purebook.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purebook.backend.dao.UserBookDao;

@Service
public class UserBookService {

	@Autowired
	UserBookDao userBookDao;
	
	public int addCollection(Integer uid, Integer bid){
		return userBookDao.addCollection(uid, bid);
	}
	
	public int removeCollection(Integer uid, Integer bid){
		return userBookDao.removeCollection(uid, bid);
	}
	

	public boolean isCollected(Integer uid, Integer bid){
		int count = userBookDao.isCollected(uid, bid);

		if(count==1)
			return true;
		return false;
	}
}
