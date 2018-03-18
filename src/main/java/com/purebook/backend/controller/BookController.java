package com.purebook.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.result.JsonResult;
import com.example.result.JsonResultwithData;
import com.example.result.ResultCode;
import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.BookReview;
import com.purebook.backend.entity.Tag;
import com.purebook.backend.service.BookReviewService;
import com.purebook.backend.service.BookService;
import com.purebook.backend.service.TagService;

@RestController
@RequestMapping(value="v1/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	@Autowired
	BookReviewService bookReviewService;
	@Autowired
	TagService tagService;
	
	private JsonResult findBookbyTag(String tag){
		List<Book> list=bookService.findBookbyTag(tag);
		if(list!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(list);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}

	//查询书
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public JsonResult findBookbyID(@PathVariable int id){
		Book book =bookService.findBookbyID(id);
		if(book!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(book);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	//搜索书籍
	@RequestMapping(method=RequestMethod.GET)
	public JsonResult search(@RequestParam(value="namelike",required=false) String namelike, 
			@RequestParam(value="tag",required=false) String tag){
		
		if(namelike!=null){
			return fuzzySearch(namelike);
		}
		else if(tag!=null){
			return findBookbyTag(tag);
		}
		else{
			JsonResult jsonResult = new JsonResult(ResultCode.PARAMS_ERROR);
			return jsonResult;
		}
	}
	
	private JsonResult fuzzySearch(String namelike){
		List<Book> list=bookService.findBookbyName(namelike);
		if(list!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(list);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	//某本书的标签
	@RequestMapping(value="{id}/tags",method=RequestMethod.GET)
	public JsonResult findTag(@PathVariable Integer id){
		List<Tag> tags = tagService.findTag(id);
		if(tags!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(tags);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	//查看用户的所有书评
	@RequestMapping(value="{id}/reviews",method=RequestMethod.GET)
	public JsonResult getReview(@PathVariable Integer id){
		List<BookReview> bookReviews=bookReviewService.findbyBookID(id);
		if(bookReviews!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(bookReviews);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	
	//新书推荐
	@RequestMapping(value="newones")
	public JsonResult getLatest(){
		List<Book> books=bookService.findLatest();
		if(books!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.SUCCESS);
			jsonResultwithData.setData(books);
			return jsonResultwithData;
		}
		JsonResult jsonResult = new JsonResult(ResultCode.EXCEPTION);
		return jsonResult;
	}
	
	//top250
	@RequestMapping(value="top250")
	public JsonResult getTop250(){
		List<Book> books=bookService.findTop250();
		if(books!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.SUCCESS);
			jsonResultwithData.setData(books);
			return jsonResultwithData;
		}
		JsonResult jsonResult = new JsonResult(ResultCode.EXCEPTION);
		return jsonResult;
	}
	
	//热门
	@RequestMapping(value="hotones")
	public JsonResult getHotest(){
		List<Book> books=bookService.findHotest();
		if(books!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.SUCCESS);
			jsonResultwithData.setData(books);
			return jsonResultwithData;
		}
		JsonResult jsonResult = new JsonResult(ResultCode.EXCEPTION);
		return jsonResult;
	}
}