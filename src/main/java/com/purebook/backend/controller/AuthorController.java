package com.purebook.backend.controller;

import com.example.result.JsonResult;
import com.example.result.JsonResultwithData;
import com.example.result.ResultCode;
import com.purebook.backend.entity.Author;
import com.purebook.backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/author/")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(value="{name}", method= RequestMethod.GET)
    public JsonResult getAuthorInfo(@PathVariable String name){
        List<Author> authorInfo = authorService.findByName(name);
        if(authorInfo!=null){
            JsonResultwithData jsonResultwithData=new JsonResultwithData();
            jsonResultwithData.setData(authorInfo);
            return jsonResultwithData;
        }
        JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
        return jsonResult;
    }
}
