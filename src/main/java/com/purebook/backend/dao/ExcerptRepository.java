package com.purebook.backend.dao;

import com.purebook.backend.entity.Excerpt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcerptRepository extends JpaRepository<Excerpt, Integer>{
    List<Excerpt> findByUserId(String userId);

    List<Excerpt> findByBookId(int bookId);
}
