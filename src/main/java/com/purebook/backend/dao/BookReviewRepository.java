package com.purebook.backend.dao;

import com.purebook.backend.entity.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Integer>{

    List<BookReview> findByUserId(String userId);
    List<BookReview> findByBookId(int bookId);

    //@Query("select b, u.name, u.avatar from BookReview b, User u where b.id = ?1 and b.userId = u.id ")
    BookReview findById(int id);
}
