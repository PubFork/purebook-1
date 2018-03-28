package com.purebook.backend.controller;

import java.util.List;

import com.purebook.backend.entity.*;
import com.purebook.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.result.JsonResult;
import com.example.result.JsonResultwithData;
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
	
	private JsonResult findBookbyTag(String tag){
		List<Book> list=bookService.findBookByTag(tag);
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
		Book book =bookService.findBookByID(id);
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
	public JsonResult search(@RequestParam(value="nameLike",required=false) String nameLike,
			@RequestParam(value="tag",required=false) String tag){
		
		if(nameLike!=null){
			return fuzzySearch(nameLike);
		}
		else if(tag!=null){
			return findBookbyTag(tag);
		}
		else{
			JsonResult jsonResult = new JsonResult(ResultCode.PARAMS_ERROR);
			return jsonResult;
		}
	}
	
	private JsonResult fuzzySearch(String nameLike){
		List<Book> list=bookService.findBookByName(nameLike);
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
		List<BookReview> bookReviews=bookReviewService.findByBookID(id);
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
	@RequestMapping(value="hot")
	public JsonResult getHot(){
		List<Book> books=bookService.findHot();
		if(books!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.SUCCESS);
			jsonResultwithData.setData(books);
			return jsonResultwithData;
		}
		JsonResult jsonResult = new JsonResult(ResultCode.EXCEPTION);
		return jsonResult;
	}

	//获取书籍摘录
    @RequestMapping(value = "{id}/excerpt")
    public JsonResult getBookExcerpt(@PathVariable Integer id) {
	    List<Excerpt> excerpts =  excerptService.findByBookId(id);
	    if (excerpts == null) {
	        return new JsonResult(ResultCode.NOT_FOUND);
        }
        JsonResultwithData jsonResultwithData = new JsonResultwithData(ResultCode.SUCCESS);
	    jsonResultwithData.setData(excerpts);
	    return jsonResultwithData;
    }

    //模糊搜索书单
    @RequestMapping(value = "list", method = RequestMethod.GET)
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