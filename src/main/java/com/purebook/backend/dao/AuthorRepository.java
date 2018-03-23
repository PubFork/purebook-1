package com.purebook.backend.dao;

import com.purebook.backend.entity.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository {
    List<Author> findByName(String name);
}
