package com.purebook.backend.controller;

import java.util.List;
import java.util.Map;

import com.purebook.backend.entity.*;
import com.purebook.backend.service.*;
import com.purebook.backend.util.UnifiedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.result.JsonResult;
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

	
	//查询用户
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public JsonResult findbyID(@PathVariable String id){
        return UnifiedResult.unifiedResult(userService.findUserById(id), ResultCode.NOT_FOUND);
	}
	
	//用户的所有书评
	@RequestMapping(value="{id}/reviews",method=RequestMethod.GET)
	public JsonResult findBookReview(@PathVariable String id){
        return UnifiedResult.unifiedResult(bookReviewService.findByUserID(id), ResultCode.NOT_FOUND);
    }

	
	//写书评
	@RequestMapping(value="{id}/reviews",method=RequestMethod.POST)
    public JsonResult writeReview(@PathVariable String id, @RequestBody Map<String, Object> request) {
        return UnifiedResult.unifiedResult(ResultCode.EXCEPTION, bookReviewService.writeReview((int)request.get("bookId"), id, (String)request.get("review"), (String)request.get("title")));
    }

	//用户喜欢的书
	@RequestMapping(value="{id}/collection",method=RequestMethod.GET)
	public JsonResult getCollection(@PathVariable String id){
        return UnifiedResult.unifiedResult(bookService.findFavourite(id), ResultCode.NOT_FOUND);
	}
	
	//收藏书
	@RequestMapping(value="{id}/collection",method=RequestMethod.POST)
    public JsonResult getCollection(@PathVariable String id, @RequestBody Favourite favourite){
        return UnifiedResult.unifiedResult(ResultCode.EXCEPTION, favouriteService.addFavourite(id, favourite.getBookId()));
    }
	
	//取消收藏
	@RequestMapping(value="{id}/collection",method=RequestMethod.DELETE)
	public JsonResult removeCollection(@PathVariable String id, @RequestParam Integer bookId){
        return UnifiedResult.unifiedResult(ResultCode.NOT_FOUND, favouriteService.removeFavourite(id, bookId));
	}
	
	//是否收藏
	@RequestMapping(value="{id}/relation",method=RequestMethod.GET)
	public JsonResult isCollected(@PathVariable String id, @RequestParam Integer bookId){
        return UnifiedResult.unifiedResult(ResultCode.NOT_FOUND, favouriteService.isFavourite(id, bookId));
	}
	
	//用户评论过的书
	@RequestMapping(value="{id}/reviewedbooks",method=RequestMethod.GET)
	public JsonResult getReviewedBooks(@PathVariable String id){
        return UnifiedResult.unifiedResult(bookService.getReviewedBooks(id), ResultCode.NOT_FOUND);
    }

	//获取用户摘录
    @RequestMapping(value = "{id}/excerpt", method = RequestMethod.GET)
    public JsonResult getUserExcerpt(@PathVariable String id) {
        return UnifiedResult.unifiedResult(excerptService.findByUserId(id), ResultCode.NOT_FOUND);
    }

    //用户添加摘录
    @RequestMapping(value = "{id}/excerpt", method = RequestMethod.POST)
    public JsonResult addExcerpt(@PathVariable String id, @RequestBody Map<String, Object> request) {
        return UnifiedResult.unifiedResult(ResultCode.NOT_FOUND, excerptService.wirteExcerpt((int)request.get("bookId"), id, (String)request.get("content")));
    }

    //查看某个用户收藏的书单
    @RequestMapping(value = "{id}/booklist", method = RequestMethod.GET)
    public JsonResult getUserBookList(@PathVariable String id) {
        return UnifiedResult.unifiedResult(bookListService.findByUserId(id), ResultCode.NOT_FOUND);
    }

    //收藏书单
    @RequestMapping(value = "{id}/booklist", method = RequestMethod.POST)
    public JsonResult addListUser(@RequestBody Map<String, String> map) {
        return UnifiedResult.unifiedResult(ResultCode.NOT_FOUND, bookListService.addListUser(map.get("id"), map.get("name")));
    }

    //取消收藏书单
    @RequestMapping(value = "{id}/booklist", method = RequestMethod.DELETE)
    public JsonResult removeListUser(@PathVariable String id, @RequestParam String name) {
        return UnifiedResult.unifiedResult(ResultCode.NOT_FOUND, bookListService.deleteByUserIdAndName(id, name));
    }

    //判断是否收藏某书单
    @RequestMapping(value = "{id}/collectedlist", method = RequestMethod.GET)
    public JsonResult isListUser(@PathVariable String id, @RequestParam String name) {
	    return UnifiedResult.unifiedResult(ResultCode.NOT_FOUND, bookListService.isCollectedList(id, name));
    }

    //推荐书
    @RequestMapping(value = "{id}/recommand", method = RequestMethod.GET)
    public JsonResult recommandBook(@PathVariable String id) {
        List<Book> books = bookService.findFavourite(id);
        return UnifiedResult.unifiedResult(books, ResultCode.NOT_FOUND);
    }

    //推荐书单
    @RequestMapping(value = "{id}/recommandbooklist", method = RequestMethod.GET)
    public JsonResult recommmandBooklist(@PathVariable String id) {
	    List<BookList> bookLists = bookListService.recommandBooklist(id);
	    return UnifiedResult.unifiedResult(bookLists, ResultCode.NOT_FOUND);
    }

    //用户收藏书单的二级目录
    @RequestMapping(value = "{id}/booklist/book", method = RequestMethod.GET)
    public JsonResult bookUnderBooklist(@PathVariable String id, @RequestParam int booklistId) {
        return UnifiedResult.unifiedResult(bookListService.searchBookByBooklistId(id, booklistId), ResultCode.NOT_FOUND);
    }
}
