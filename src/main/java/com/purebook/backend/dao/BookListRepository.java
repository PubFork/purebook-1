package com.purebook.backend.dao;

import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookListRepository extends JpaRepository<BookList, Integer> {
    BookList findById(int id);
    BookList findByName(String name);
    List<BookList> findByNameContaining(String nameLike);

    @Query("select b from BookList b, ListUser l where b.id = l.listId and l.userId = ?1")
    List<BookList> searchByUserId(int id);
}
