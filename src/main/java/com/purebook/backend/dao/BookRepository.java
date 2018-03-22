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

    List<Book> findByName(String name);

    @Query(value = "select * from Book where BookId in " +
            "(select Book_ID from UserBook group by BookID having Count(UserID) >7) " +
            "order by rand() limit 40", nativeQuery = true)
    List<Book> findTop250();

    @Query(value = "select * from Book where id > 27000000 order by rand() limit 40", nativeQuery = true)
    List<Book> findLatest();

    @Query(value = "select * from Book where BookID in "
            + "(select BookID from BookReview group by BookID having Count(UserID) >1)"
            + " order by rand() limit 40;", nativeQuery = true)
    List<Book> findHotest();

    //recommand

    //TODO findCollection
//    @Query("select b from Book b where b.id in (select BookID from UserBook where UserID=:id)")
//    List<Book> findCollection(@Param("id") int id);

    @Query("select b from Book b where b.id in (select r.bookId from BookReview r where r.userId = ?1)")
    List<Book> getReviewedBooks(int userId);

}
