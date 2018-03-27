package com.purebook.backend.service;

import com.example.result.JsonResult;
import com.example.result.ResultCode;
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

    public JsonResult wirteExcerpt(int bookId, int userId, String content) {
        excerptRepository.save(new Excerpt(bookId, userId, content, new Timestamp(System.currentTimeMillis())));
        return new JsonResult(ResultCode.SUCCESS);
    }

    public List<Excerpt> findByBookId(int bookId) {
        return excerptRepository.findByBookId(bookId);
    }

    public List<Excerpt> findByUserId(int userId) {
        return excerptRepository.findByUserId(userId);
    }

}
