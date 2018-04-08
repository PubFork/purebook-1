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

import com.example.result.JsonResult;
import com.example.result.ResultCode;

@RestController
@RequestMapping(value="v1/books")
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

	//根据id查询书
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public JsonResult findBookbyID(@PathVariable int id){
        return UnifiedResult.unifiedResult(bookService.findBookByID(id), ResultCode.NOT_FOUND);
    }

    //模糊书名搜索书籍
    @RequestMapping(value = "bookname", method=RequestMethod.GET)
    public JsonResult fuzzySearch(@RequestParam String nameLike) throws UnsupportedEncodingException {
        return UnifiedResult.unifiedResult(bookService.findByNameLike(URLDecoder.decode(nameLike, "UTF-8")), ResultCode.NOT_FOUND);
    }

    //根据标签搜索书籍
    @RequestMapping(value = "booktag", method=RequestMethod.GET)
    public JsonResult searchByTag(@RequestParam String tag) throws UnsupportedEncodingException {
        return UnifiedResult.unifiedResult(bookService.findBookByTag(URLDecoder.decode(tag, "UTF-8")), ResultCode.NOT_FOUND);
    }
	
	//某本书的标签
	@RequestMapping(value="{id}/tags",method=RequestMethod.GET)
	public JsonResult findTag(@PathVariable Integer id){
        return UnifiedResult.unifiedResult(tagService.findTag(id), ResultCode.NOT_FOUND);
    }

	//获取单个书评
	@RequestMapping(value = "{id}/review", method = RequestMethod.GET)
    public JsonResult getSingleReview(@PathVariable int id) {
        return UnifiedResult.unifiedResult(bookReviewService.findById(id), ResultCode.NOT_FOUND);
    }

	//查看某本书的所有书评
	@RequestMapping(value="{id}/reviews",method=RequestMethod.GET)
	public JsonResult getReview(@PathVariable int id){
        return UnifiedResult.unifiedResult(bookReviewService.findByBookID(id), ResultCode.NOT_FOUND);
    }
	
	//新书推荐
	@RequestMapping(value="newones", method = RequestMethod.GET)
	public JsonResult getLatest(){
        return UnifiedResult.unifiedResult(bookService.findLatest(), ResultCode.EXCEPTION);
    }
	
	//top250
	@RequestMapping(value="top250" ,method = RequestMethod.GET)
	public JsonResult getTop250(){
        return UnifiedResult.unifiedResult(bookService.findTop250(), ResultCode.NOT_FOUND);
	}
	
	//热门
	@RequestMapping(value="hot", method = RequestMethod.GET)
	public JsonResult getHot(){
        return UnifiedResult.unifiedResult(bookService.findHot(), ResultCode.EXCEPTION);
	}

	//获取书籍摘录
    @RequestMapping(value = "{id}/excerpt", method = RequestMethod.GET)
    public JsonResult getBookExcerpt(@PathVariable Integer id) {
        return UnifiedResult.unifiedResult(excerptService.findByBookId(id), ResultCode.NOT_FOUND);
    }

    //模糊搜索书单
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public JsonResult findByNameLike(@RequestParam String nameLike) throws UnsupportedEncodingException {
        return UnifiedResult.unifiedResult(bookListService.findByNameLike(URLDecoder.decode(nameLike, "UTF-8")), ResultCode.NOT_FOUND);
    }
}