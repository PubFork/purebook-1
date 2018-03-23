package com.purebook.backend.service;

import com.purebook.backend.dao.AuthorRepository;
import com.purebook.backend.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }
}
