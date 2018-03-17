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
import com.purebook.backend.entity.User;
import com.purebook.backend.service.BookReviewService;
import com.purebook.backend.service.BookService;
import com.purebook.backend.service.UserBookService;
import com.purebook.backend.service.UserService;



@RestController
@RequestMapping("v1/users")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	BookReviewService bookReviewService;
	@Autowired
	BookService bookService;
	@Autowired
	UserBookService userBookService;
	
	//注册新用户
	@RequestMapping(method = RequestMethod.POST)
	public JsonResult add(@RequestParam String name,@RequestParam String key){

			User user=new User();
			user.setUserName(name);
			user.setUserKey(key);
			user.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
			userService.add(user);

			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.SUCCESS);
			jsonResultwithData.setData(userService.add(user));
			return jsonResultwithData;

	}
	
	//查询用户
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public JsonResult findbyID(@PathVariable Integer id){
		User user=userService.findUserbyID(id);
		if(user!=null){
			user.setUserKey(null);
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(user);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	//用户的所有书评
	@RequestMapping(value="{id}/reviews",method=RequestMethod.GET)
	public JsonResult findBookReview(@PathVariable Integer id){
		List<BookReview> bookReviews=bookReviewService.findbyUserID(id);
		if(bookReviews!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(bookReviews);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	
	//写书评
	@RequestMapping(value="{id}/reviews",method=RequestMethod.POST)
	public JsonResult writeReview(@PathVariable Integer id,@RequestParam Integer bookid, @RequestParam String review){
		try {
			bookReviewService.writeReview(id, bookid, review);
			JsonResult jsonResult=new JsonResult(ResultCode.SUCCESS);
			return jsonResult;
		} catch (Exception e) {
			JsonResult jsonResult=new JsonResult(ResultCode.EXCEPTION);
			return jsonResult;
		}
	}
	
	//推荐书目
	@RequestMapping(value="{id}/recommendation",method=RequestMethod.GET)
	public JsonResult youMayLike(@PathVariable Integer id){
		List<Book> books=bookService.recommend(id);
		if(books!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(books);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	//用户喜欢的书
	@RequestMapping(value="{id}/collection",method=RequestMethod.GET)
	public JsonResult getCollection(@PathVariable Integer id){
		List<Book> books=bookService.findCollection(id);
		if(books!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData();
			jsonResultwithData.setData(books);
			return jsonResultwithData;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	//收藏书
	@RequestMapping(value="{id}/collection",method=RequestMethod.POST)
	public JsonResult getCollection(@PathVariable Integer id, @RequestParam Integer BookID){
		try {
			userBookService.addCollection(id, BookID);
			JsonResult jsonResult=new JsonResult(ResultCode.SUCCESS);
			return jsonResult;
		} catch (Exception e) {
			JsonResult jsonResult=new JsonResult(ResultCode.EXCEPTION);
			return jsonResult;
		}
	}
	
	//取消收藏
	@RequestMapping(value="{id}/collection",method=RequestMethod.DELETE)
	public JsonResult removeCollection(@PathVariable Integer id, @RequestParam Integer BookID){
		if(userBookService.removeCollection(id, BookID)==1){
			JsonResult jsonResult=new JsonResult(ResultCode.SUCCESS);
			return jsonResult;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	//是否收藏
	@RequestMapping(value="{id}/relation",method=RequestMethod.GET)
	public JsonResult isCollected(@PathVariable Integer id, @RequestParam Integer BookID){
		if(userBookService.isCollected(id, BookID)){
			JsonResult jsonResult=new JsonResult(ResultCode.SUCCESS);
			return jsonResult;
		}
		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
	
	//用户评论过的书
	@RequestMapping(value="{id}/reviewedbooks",method=RequestMethod.GET)
	public JsonResult getReviewedBooks(@PathVariable Integer id){
		List<Book> books = bookService.getReviewedBooks(id);
		if(books!=null){
			JsonResultwithData jsonResultwithData = new JsonResultwithData(ResultCode.SUCCESS);
			jsonResultwithData.setData(books);
			return jsonResultwithData;
		}
		JsonResult jsonResult = new JsonResult(ResultCode.NOT_FOUND);
		return jsonResult;
	}
}
