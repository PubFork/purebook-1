package com.purebook.backend.service;

import com.purebook.backend.dao.AuthorRepository;
import com.purebook.backend.entity.Author;
import com.purebook.backend.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> findByNameLike(String name) {
        return authorRepository.findByNameLike("%" + name + "%");
    }

    public List<Book> findWorkByNameLike(String name) {
        return authorRepository.findWorkByNameLike("%" + name + "%");
    }
}
