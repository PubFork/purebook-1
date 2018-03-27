package com.purebook.backend.dao;

import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookListRepository extends JpaRepository<BookList, Integer> {
    BookList findById(int id);
    BookList findByName(String name);
    List<BookList> findByNameContaining(String nameLike);
}
