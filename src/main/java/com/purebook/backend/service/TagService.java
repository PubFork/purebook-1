package com.purebook.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purebook.backend.dao.BookTagDao;
import com.purebook.backend.entity.Tag;

@Service
public class TagService {

	@Autowired
	BookTagDao bookTagDao;
	
	public List<Tag> findTag(Integer id){
		return bookTagDao.findTag(id);
	}
	
	public List<Tag> getTag(){
		return bookTagDao.getTag();
	}
}
