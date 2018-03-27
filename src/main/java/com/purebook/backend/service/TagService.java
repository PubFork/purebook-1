package com.purebook.backend.service;

import java.util.List;

import com.purebook.backend.dao.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purebook.backend.dao.BookTagDao;
import com.purebook.backend.entity.Tag;

@Service
public class TagService {
	@Autowired
    TagRepository tagRepository;

    public List<Tag> findTag(Integer id){
        return tagRepository.findByBookId(id);
    }

    public List<Tag> getTag(){
        return tagRepository.getTag();
    }
}
