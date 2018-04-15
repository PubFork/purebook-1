package com.purebook.backend.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import com.purebook.backend.entity.*;
import com.purebook.backend.service.*;
import com.purebook.backend.util.UnifiedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.purebook.backend.result.JsonResult;
import com.purebook.backend.result.ResultCode;

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
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public JsonResult findByID(@PathVariable String id) {
        return UnifiedResult.result(userService.findUserById(id), ResultCode.NOT_FOUND);
    }

    //书评
    //用户的所有书评
    @RequestMapping(value = "{id}/reviews", method = RequestMethod.GET)
    public JsonResult findBookReview(@PathVariable String id) {
        return UnifiedResult.result(bookReviewService.findByUserID(id), ResultCode.NOT_FOUND);
    }

    //写书评
    @RequestMapping(value = "{id}/reviews", method = RequestMethod.POST)
    public JsonResult writeReview(@PathVariable String id, @RequestBody Map<String, Object> request) {
        return UnifiedResult.result(ResultCode.EXCEPTION, bookReviewService.writeReview((int) request.get("bookId"),
                id, (String) request.get("review"), (String) request.get("title")));
    }

    //用户评论过的书
    @RequestMapping(value = "{id}/reviews/books", method = RequestMethod.GET)
    public JsonResult getReviewedBooks(@PathVariable String id) {
        return UnifiedResult.result(bookService.getReviewedBooks(id), ResultCode.NOT_FOUND);
    }

    //书收藏
    //用户喜欢的书
    @RequestMapping(value = "{id}/books", method = RequestMethod.GET)
    public JsonResult getCollection(@PathVariable String id) {
        return UnifiedResult.result(bookService.findFavourite(id), ResultCode.NOT_FOUND);
    }

    //收藏书
    @RequestMapping(value = "{id}/books", method = RequestMethod.POST)
    public JsonResult getCollection(@PathVariable String id, @RequestBody Favourite favourite) {
        return UnifiedResult.result(ResultCode.EXCEPTION, favouriteService.addFavourite(id, favourite.getBookId()));
    }

    //取消收藏
    @RequestMapping(value = "{id}/books", method = RequestMethod.DELETE)
    public JsonResult removeCollection(@PathVariable String id, @RequestParam Integer bookId) {
        return UnifiedResult.result(ResultCode.NOT_FOUND, favouriteService.removeFavourite(id, bookId));
    }

    //是否收藏
    @RequestMapping(value = "{id}/books/relations", method = RequestMethod.GET)
    public JsonResult isCollected(@PathVariable String id, @RequestParam Integer bookId) {
        return UnifiedResult.result(ResultCode.NOT_FOUND, favouriteService.isFavourite(id, bookId));
    }

    //书单收藏
    //查看某个用户收藏的书单
    @RequestMapping(value = "{id}/booklists", method = RequestMethod.GET)
    public JsonResult getUserBookList(@PathVariable String id) {
        return UnifiedResult.result(bookListService.findByUserId(id), ResultCode.NOT_FOUND);
    }

    //用户收藏书单的二级目录
    @RequestMapping(value = "{id}/booklists/books", method = RequestMethod.GET)
    public JsonResult bookUnderBooklist(@PathVariable String id, @RequestParam int booklistId) {
        return UnifiedResult.result(bookListService.searchBookByBooklistId(id, booklistId), ResultCode.NOT_FOUND);
    }

    //收藏书单
    @RequestMapping(value = "{id}/booklists", method = RequestMethod.POST)
    public JsonResult addListUser(@PathVariable String id,
                                  @RequestParam String name) throws UnsupportedEncodingException {
        return UnifiedResult.result(ResultCode.NOT_FOUND,
                bookListService.addListUser(id, URLDecoder.decode(name, "UTF-8")));
    }

    //取消收藏书单
    @RequestMapping(value = "{id}/booklists", method = RequestMethod.DELETE)
    public JsonResult removeListUser(@PathVariable String id, @RequestParam String name) {
        return UnifiedResult.result(ResultCode.NOT_FOUND, bookListService.deleteByUserIdAndName(id, name));
    }

    //判断是否收藏某书单
    @RequestMapping(value = "{id}/booklists/relations", method = RequestMethod.GET)
    public JsonResult isListUser(@PathVariable String id, @RequestParam String name) {
        return UnifiedResult.result(ResultCode.NOT_FOUND, bookListService.isCollectedList(id, name));
    }

    //摘录
    //获取用户摘录
    @RequestMapping(value = "{id}/excerpts", method = RequestMethod.GET)
    public JsonResult getUserExcerpt(@PathVariable String id) {
        return UnifiedResult.result(excerptService.findByUserId(id), ResultCode.NOT_FOUND);
    }

    //用户添加摘录
    @RequestMapping(value = "{id}/excerpts", method = RequestMethod.POST)
    public JsonResult addExcerpt(@PathVariable String id, @RequestBody Map<String, Object> request) {
        return UnifiedResult.result(ResultCode.NOT_FOUND,
                excerptService.wirteExcerpt((int) request.get("bookId"), id, (String) request.get("content")));
    }

    //推荐
    //推荐书
    @RequestMapping(value = "{id}/recommandations/books", method = RequestMethod.GET)
    public JsonResult recommandBook(@PathVariable String id) {
        List<Book> books = bookService.findFavourite(id);
        return UnifiedResult.result(books, ResultCode.NOT_FOUND);
    }

    //推荐书单
    @RequestMapping(value = "{id}/recommandations/booklists", method = RequestMethod.GET)
    public JsonResult recommmandBooklist(@PathVariable String id) {
        List<BookList> bookLists = bookListService.recommandBooklist(id);
        return UnifiedResult.result(bookLists, ResultCode.NOT_FOUND);
    }
}
