package com.purebook.backend.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.purebook.backend.service.*;
import com.purebook.backend.util.UnifiedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.purebook.backend.result.JsonResult;
import com.purebook.backend.result.ResultCode;

@RestController
@RequestMapping(value = "v1/books")
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    BookReviewService bookReviewService;
    @Autowired
    TagService tagService;
    @Autowired
    ExcerptService excerptService;
    @Autowired
    BookListService bookListService;

    //搜索
    //根据id搜索书籍
    @RequestMapping(value = "search/{id}", method = RequestMethod.GET)
    public JsonResult findBookbyID(@PathVariable int id) {
        return UnifiedResult.result(bookService.findBookByID(id), ResultCode.NOT_FOUND);
    }

    //根据标签搜索书籍
    @RequestMapping(value = "search/tags", method = RequestMethod.GET)
    public JsonResult searchByTag(@RequestParam String tag) throws UnsupportedEncodingException {
        return UnifiedResult.result(bookService.findBookByTag(URLDecoder.decode(tag, "UTF-8")),
                ResultCode.NOT_FOUND);
    }

    //模糊搜索书籍
    @RequestMapping(value = "search/names", method = RequestMethod.GET)
    public JsonResult fuzzySearch(@RequestParam String nameLike) throws UnsupportedEncodingException {
        return UnifiedResult.result(bookService.findByNameLike(URLDecoder.decode(nameLike, "UTF-8")),
                ResultCode.NOT_FOUND);
    }

    //模糊搜索书单
    @RequestMapping(value = "search/booklists", method = RequestMethod.GET)
    public JsonResult findByNameLike(@RequestParam String nameLike) throws UnsupportedEncodingException {
        return UnifiedResult.result(bookListService.findByNameLike(URLDecoder.decode(nameLike, "UTF-8")),
                ResultCode.NOT_FOUND);
    }

    //书籍信息
    //标签
    @RequestMapping(value = "{id}/tags", method = RequestMethod.GET)
    public JsonResult findTag(@PathVariable Integer id) {
        return UnifiedResult.result(tagService.findTag(id), ResultCode.NOT_FOUND);
    }

    //所有书评
    @RequestMapping(value = "{id}/reviews", method = RequestMethod.GET)
    public JsonResult getReview(@PathVariable int id) {
        return UnifiedResult.result(bookReviewService.findByBookID(id), ResultCode.NOT_FOUND);
    }

    //摘录
    @RequestMapping(value = "{id}/excerpts", method = RequestMethod.GET)
    public JsonResult getBookExcerpt(@PathVariable Integer id) {
        return UnifiedResult.result(excerptService.findByBookId(id), ResultCode.NOT_FOUND);
    }

    //其他
    //书评
    @RequestMapping(value = "reviews/{id}", method = RequestMethod.GET)
    public JsonResult getSingleReview(@PathVariable int id) {
        return UnifiedResult.result(bookReviewService.findById(id), ResultCode.NOT_FOUND);
    }

    //新书推荐
    @RequestMapping(value = "newbooks", method = RequestMethod.GET)
    public JsonResult getLatest() {
        return UnifiedResult.result(bookService.findLatest(), ResultCode.EXCEPTION);
    }

    //top250
    @RequestMapping(value = "top250", method = RequestMethod.GET)
    public JsonResult getTop250() {
        return UnifiedResult.result(bookService.findTop250(), ResultCode.NOT_FOUND);
    }

    //热门
    @RequestMapping(value = "hot", method = RequestMethod.GET)
    public JsonResult getHot() {
        return UnifiedResult.result(bookService.findHot(), ResultCode.EXCEPTION);
    }


}