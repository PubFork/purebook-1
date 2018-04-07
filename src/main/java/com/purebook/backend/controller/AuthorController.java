package com.purebook.backend.controller;

import com.example.result.JsonResult;
import com.example.result.JsonResultwithData;
import com.example.result.ResultCode;
import com.purebook.backend.entity.Author;
import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.BookList;
import com.purebook.backend.service.AuthorService;
import com.purebook.backend.util.UnifiedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(method= RequestMethod.GET)
    public JsonResult getAuthorInfo(@RequestParam String name){
        List<Author> authorInfo = authorService.findByNameLike(name);
//        if(authorInfo!=null){
//            JsonResultwithData jsonResultwithData=new JsonResultwithData();
//            jsonResultwithData.setData(authorInfo);
//            return jsonResultwithData;
//        }
//        JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
//        return jsonResult;

//        UnifiedResult unifiedResult = new UnifiedResult();
//        return unifiedResult.unifiedResult(authorInfo, ResultCode.NOT_FOUND);

        return UnifiedResult.unifiedResult(authorInfo, ResultCode.NOT_FOUND);

    }

    @RequestMapping(value = "works", method = RequestMethod.GET)
    public JsonResult getAuthorWorks(@RequestParam String name) {
        List<Book> bookLists = authorService.findWorkByNameLike(name);
        return UnifiedResult.unifiedResult(bookLists, ResultCode.NOT_FOUND);
    }
}
