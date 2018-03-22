package com.purebook.backend.dao;

import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query(value = "select * from  Book where BookID in "
            + "(select BookID from BookTag where Field = ?1) order by rand() limit 10 ;", nativeQuery = true)
    List<Book> findBook(String field);

    List<Tag> findByBookId(int bookId);

    @Query(value = "select * from Tag where Count>10 order by rand() limit 200", nativeQuery = true)
    List<Tag> getTag();
}

