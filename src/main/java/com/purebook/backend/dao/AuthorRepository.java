package com.purebook.backend.dao;

import com.purebook.backend.entity.Author;
import com.purebook.backend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByNameLike(String name);

    @Query("select b from Book b, Author a where a.bookId = b.id and a.name like ?1")
    List<Book> findWorkByNameLike(String name);
}
