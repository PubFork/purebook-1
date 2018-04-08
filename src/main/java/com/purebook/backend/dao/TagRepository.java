package com.purebook.backend.dao;

import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    @Query("select b from Book b, Tag t where b.id = t.bookId and t.field = ?1")
    List<Book> findBook(String field);

    List<Tag> findByBookId(int bookId);

    @Query("select t from Tag t where t.count > 10")
    List<Tag> getTag();
}

