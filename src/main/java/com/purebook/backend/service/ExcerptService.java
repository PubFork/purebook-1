package com.purebook.backend.service;

import com.purebook.backend.dao.ExcerptRepository;
import com.purebook.backend.entity.Excerpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ExcerptService {
    @Autowired
    ExcerptRepository excerptRepository;

    public boolean wirteExcerpt(int bookId, String userId, String content) {
        return excerptRepository.save(new Excerpt(userId, bookId, content, new Timestamp(System.currentTimeMillis()))) != null;
    }

    public List<Excerpt> findByBookId(int bookId) {
        return excerptRepository.findByBookId(bookId);
    }

    public List<Excerpt> findByUserId(String userId) {
        return excerptRepository.findByUserId(userId);
    }

}
