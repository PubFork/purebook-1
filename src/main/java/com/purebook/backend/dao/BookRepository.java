package com.purebook.backend.dao;

import com.purebook.backend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findById(int id);

    List<Book> findByNameLike(String name);

//    @Query(value = "select * from Book where BookId in " +
//            "(select Book_ID from Favourtie group by BookID having Count(UserID) >7) " +
//            "order by rand() limit 40", nativeQuery = true)
    @Query("select b from Book b, Favourite f where b.id = f.bookId group by f.bookId having count(f.userId) > 7")
    List<Book> findTop250();

    @Query("select b from Book b where b.id > 27000000")
    List<Book> findLatest();

//    @Query(value = "select * from Book where BookID in "
//            + "(select BookID from BookReview group by BookID having Count(UserID) >1)"
//            + " order by rand() limit 40;", nativeQuery = true)
    @Query("select b from Book b, BookReview f where b.id = f.bookId group by f.bookId having count(f.userId) > 1")
    List<Book> findHot();

    //recommand

    @Query("select b from Book b, Favourite f where b.id = f.bookId and f.userId = ?1")
    List<Book> findFavourite(String id);

    @Query("select b from Book b, BookReview r where b.id = r.bookId and r.userId = ?1")
    List<Book> getReviewedBooks(String userId);

}
