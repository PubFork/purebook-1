package com.purebook.backend.controller;

import com.example.result.JsonResult;
import com.example.result.JsonResultwithData;
import com.example.result.ResultCode;
import com.purebook.backend.entity.BookList;
import com.purebook.backend.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ListController {
    @Autowired
    BookListService bookListService;

    //模糊查找书单名
    @RequestMapping(value = "", method = RequestMethod.GET)
    public JsonResult findByNameLike(@RequestParam String nameLike) {
        List<BookList> bookLists = bookListService.findByNameLike(nameLike);
        if (bookLists != null) {
            JsonResultwithData jsonResultwithData = new JsonResultwithData(ResultCode.SUCCESS);
            jsonResultwithData.setData(bookLists);
            return jsonResultwithData;
        }
        return new JsonResult(ResultCode.NOT_FOUND);
    }
}
