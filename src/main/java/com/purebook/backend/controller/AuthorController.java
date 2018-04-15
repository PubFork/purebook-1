package com.purebook.backend.controller;

import com.purebook.backend.result.JsonResult;
import com.purebook.backend.result.ResultCode;
import com.purebook.backend.service.AuthorService;
import com.purebook.backend.service.BookService;
import com.purebook.backend.util.UnifiedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequestMapping(value = "v1/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    //作者详情
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult getAuthorInfo(@RequestParam String name) {
        return UnifiedResult.result(authorService.findByNameLike(name), ResultCode.NOT_FOUND);
    }

    //作者的所有作品
    @RequestMapping(value = "works", method = RequestMethod.GET)
    public JsonResult getAuthorWorks(@RequestParam String name) throws UnsupportedEncodingException {
        String para = URLDecoder.decode(name, "UTF-8");
        return UnifiedResult.result(bookService.findWorkByNameLike(para), ResultCode.NOT_FOUND);
    }
}
