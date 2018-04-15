package com.purebook.backend.dao;

import com.purebook.backend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findById(int id);

    List<Book> findByNameLike(String name);

    @Query("select b from Book b, Favourite f where b.id = f.bookId group by f.bookId having count(f.userId) > 7")
    List<Book> findTop250();

    @Query("select b from Book b where b.id > 27000000")
    List<Book> findLatest();

    @Query("select b from Book b, BookReview f where b.id = f.bookId group by f.bookId having count(f.userId) > 0")
    List<Book> findHot();

    @Query("select b from Book b, Favourite f where b.id = f.bookId and f.userId = ?1")
    List<Book> findFavourite(String id);

    @Query("select b from Book b, BookReview r where b.id = r.bookId and r.userId = ?1")
    List<Book> getReviewedBooks(String userId);

    @Query("select b from Book b, Author a where a.bookId = b.id and a.name like ?1")
    List<Book> findWorkByNameLike(String name);
}
