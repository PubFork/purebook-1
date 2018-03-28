package com.purebook.backend.controller;

import java.sql.Timestamp;
import java.util.List;

import com.purebook.backend.entity.*;
import com.purebook.backend.service.*;
import com.purebook.backend.util.UnifiedResult;
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
@RequestMapping("v1/users")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	BookReviewService bookReviewService;
	@Autowired
	BookService bookService;
	@Autowired
    FavouriteService favouriteService;
	@Autowired
    ExcerptService excerptService;
	@Autowired
    BookListService bookListService;

	//注册新用户
	@RequestMapping(method = RequestMethod.POST)
	public JsonResult add(@RequestParam String name,@RequestParam String key){

//			User user=new User();
//			user.setName(name);
//			user.setPassword(key);
//			user.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
            User user = new User(name, key, new Timestamp(System.currentTimeMillis()));
			userService.addUser(user);

			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.SUCCESS);
//			jsonResultwithData.setData(userService.addUser(user));
            jsonResultwithData.setData(user);
			return jsonResultwithData;

	}
	
	//查询用户
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public JsonResult findbyID(@PathVariable Integer id){
		User user=userService.findUserById(id);
//		if(user!=null){
//			user.setPassword(null);
//			JsonResultwithData jsonResultwithData=new JsonResultwithData();
//			jsonResultwithData.setData(user);
//			return jsonResultwithData;
//		}
//		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
//		return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(user, ResultCode.NOT_FOUND);
	}
	
	//用户的所有书评
	@RequestMapping(value="{id}/reviews",method=RequestMethod.GET)
	public JsonResult findBookReview(@PathVariable Integer id){
		List<BookReview> bookReviews=bookReviewService.findByUserID(id);
//		if(bookReviews!=null){
//			JsonResultwithData jsonResultwithData=new JsonResultwithData();
//			jsonResultwithData.setData(bookReviews);
//			return jsonResultwithData;
//		}
//		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
//		return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(bookReviews, ResultCode.NOT_FOUND);
	}
	
	
	//写书评
	@RequestMapping(value="{id}/reviews",method=RequestMethod.POST)
	public JsonResult writeReview(@PathVariable Integer id,@RequestParam Integer bookid, @RequestParam String review){
//		try {
//			bookReviewService.writeReview(id, bookid, review);
//			JsonResult jsonResult=new JsonResult(ResultCode.SUCCESS);
//			return jsonResult;
//		} catch (Exception e) {
//			JsonResult jsonResult=new JsonResult(ResultCode.EXCEPTION);
//			return jsonResult;
//		}
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(ResultCode.EXCEPTION, bookReviewService.writeReview(id, bookid, review));
	}
	
	//推荐书目
//	@RequestMapping(value="{id}/recommendation",method=RequestMethod.GET)
//	public JsonResult youMayLike(@PathVariable Integer id){
//		List<Book> books=bookService.recommend(id);
//		if(books!=null){
//			JsonResultwithData jsonResultwithData=new JsonResultwithData();
//			jsonResultwithData.setData(books);
//			return jsonResultwithData;
//		}
//		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
//		return jsonResult;
//	}
	
	//用户喜欢的书
	@RequestMapping(value="{id}/collection",method=RequestMethod.GET)
	public JsonResult getCollection(@PathVariable Integer id){
		List<Book> books=bookService.findFavourite(id);
//		if(books!=null){
//			JsonResultwithData jsonResultwithData=new JsonResultwithData();
//			jsonResultwithData.setData(books);
//			return jsonResultwithData;
//		}
//		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
//		return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(books, ResultCode.NOT_FOUND);
	}
	
	//收藏书
	@RequestMapping(value="{id}/collection",method=RequestMethod.POST)
	public JsonResult getCollection(@PathVariable Integer id, @RequestParam Integer BookID){
//		try {
//			favouriteService.addFavourite(id, BookID);
//			JsonResult jsonResult=new JsonResult(ResultCode.SUCCESS);
//			return jsonResult;
//		} catch (Exception e) {
//			JsonResult jsonResult=new JsonResult(ResultCode.EXCEPTION);
//			return jsonResult;
//		}
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(ResultCode.EXCEPTION, favouriteService.addFavourite(id, BookID));
	}
	
	//取消收藏
	@RequestMapping(value="{id}/collection",method=RequestMethod.DELETE)
	public JsonResult removeCollection(@PathVariable Integer id, @RequestParam Integer BookID){
//		if(favouriteService.removeFavourite(id, BookID)){
//			JsonResult jsonResult=new JsonResult(ResultCode.SUCCESS);
//			return jsonResult;
//		}
//		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
//		return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(ResultCode.NOT_FOUND, favouriteService.removeFavourite(id, BookID));
	}
	
	//是否收藏
	@RequestMapping(value="{id}/relation",method=RequestMethod.GET)
	public JsonResult isCollected(@PathVariable Integer id, @RequestParam Integer BookID){
//		if(favouriteService.isFavourite(id, BookID)){
//			JsonResult jsonResult=new JsonResult(ResultCode.SUCCESS);
//			return jsonResult;
//		}
//		JsonResult jsonResult=new JsonResult(ResultCode.NOT_FOUND);
//		return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(ResultCode.NOT_FOUND, favouriteService.isFavourite(id, BookID));
	}
	
	//用户评论过的书
	@RequestMapping(value="{id}/reviewedbooks",method=RequestMethod.GET)
	public JsonResult getReviewedBooks(@PathVariable Integer id){
		List<Book> books = bookService.getReviewedBooks(id);
//		if(books!=null){
//			JsonResultwithData jsonResultwithData = new JsonResultwithData(ResultCode.SUCCESS);
//			jsonResultwithData.setData(books);
//			return jsonResultwithData;
//		}
//		JsonResult jsonResult = new JsonResult(ResultCode.NOT_FOUND);
//		return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(books, ResultCode.NOT_FOUND);
	}

	//获取用户摘录
    @RequestMapping(value = "{id}/excerpt", method = RequestMethod.GET)
    public JsonResult getUserExcerpt(@PathVariable Integer id) {
	    List<Excerpt> excerpts = excerptService.findByUserId(id);
//        if(excerpts!=null){
//            JsonResultwithData jsonResultwithData = new JsonResultwithData(ResultCode.SUCCESS);
//            jsonResultwithData.setData(excerpts);
//            return jsonResultwithData;
//        }
//        JsonResult jsonResult = new JsonResult(ResultCode.NOT_FOUND);
//        return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(excerpts, ResultCode.NOT_FOUND);
    }

    //用户添加摘录
    @RequestMapping(value = "{id}/excerpt", method = RequestMethod.POST)
    public JsonResult addExcerpt(@PathVariable Integer id,
                                 @RequestParam Integer bookId,
                                 @RequestParam String content) {
//	    User user = userService.findUserById(id);
//	    if (user == null) {
//	        return new JsonResult(ResultCode.NOT_FOUND);
//        }
//        excerptService.wirteExcerpt(bookId, id, content);
//        return new JsonResult(ResultCode.SUCCESS);
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(ResultCode.NOT_FOUND, excerptService.wirteExcerpt(bookId, id, content));
    }

    //查看某个用户收藏的书单
    @RequestMapping(value = "{id}/booklist", method = RequestMethod.GET)
    public JsonResult getUserBookList(@PathVariable Integer id) {
        List<BookList> bookList = bookListService.findByUserId(id);
//        if (bookList == null) {
//            return new JsonResult(ResultCode.NOT_FOUND);
//        }
//        JsonResultwithData jsonResultwithData = new JsonResultwithData(ResultCode.SUCCESS);
//        jsonResultwithData.setData(bookList);
//        return jsonResultwithData;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(bookList, ResultCode.NOT_FOUND);
    }

    //收藏书单
    @RequestMapping(value = "{id}/booklist", method = RequestMethod.POST)
    public JsonResult addListUser(@PathVariable Integer id,
                                  @RequestParam String name) {
//        if (bookListService.addListUser(id, name) != null) {
//            JsonResult jsonResult = new JsonResult(ResultCode.SUCCESS);
//            return jsonResult;
//        }
//        JsonResult jsonResult = new JsonResult(ResultCode.NOT_FOUND);
//        return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(ResultCode.NOT_FOUND, bookListService.addListUser(id, name));
    }

    //取消收藏书单
    @RequestMapping(value = "{id}/booklist", method = RequestMethod.DELETE)
    public JsonResult removeListUser(@PathVariable Integer id,
                                     @RequestParam String name) {
//        if (bookListService.deleteByUserIdAndName(id, name)) {
//            JsonResult jsonResult = new JsonResult(ResultCode.SUCCESS);
//            return jsonResult;
//        }
//        JsonResult jsonResult = new JsonResult(ResultCode.NOT_FOUND);
//        return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(ResultCode.NOT_FOUND, bookListService.deleteByUserIdAndName(id, name));
    }

    //判断是否收藏某书单
    @RequestMapping(value = "{id}/collectedlist", method = RequestMethod.GET)
    public JsonResult isListUser(@PathVariable Integer id,
                                 @RequestParam String name) {
//        if (bookListService.isCollectedList(id, name)) {
//            JsonResult jsonResult = new JsonResult(ResultCode.SUCCESS);
//            return jsonResult;
//        }
//        JsonResult jsonResult = new JsonResult(ResultCode.NOT_FOUND);
//        return jsonResult;
        UnifiedResult unifiedResult = new UnifiedResult();
        return unifiedResult.unifiedResult(ResultCode.NOT_FOUND, bookListService.isCollectedList(id, name));
    }

    //推荐书单

}
