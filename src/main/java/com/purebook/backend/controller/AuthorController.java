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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping(value = "v1/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(method= RequestMethod.GET)
    public JsonResult getAuthorInfo(@RequestParam String name){
        return UnifiedResult.unifiedResult(authorService.findByNameLike(name), ResultCode.NOT_FOUND);

    }

    //作者的所有作品
    @RequestMapping(value = "works", method = RequestMethod.GET)
    public JsonResult getAuthorWorks(@RequestParam String name) throws UnsupportedEncodingException {
        String para = URLDecoder.decode(name, "UTF-8");
        System.out.print("aaaaaaaa"+para);
        //return UnifiedResult.unifiedResult(authorService.findWorkByNameLike(URLDecoder.decode(para, "UTF-8")), ResultCode.NOT_FOUND);
        return UnifiedResult.unifiedResult(authorService.findWorkByNameLike(para), ResultCode.NOT_FOUND);

    }
}
