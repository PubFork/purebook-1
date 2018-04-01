package com.purebook.backend;

import com.purebook.backend.dao.*;
import com.purebook.backend.entity.*;
import com.purebook.backend.util.RandomList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookReviewRepository bookReviewRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    FavouriteRepository favouriteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookListRepository bookListRepository;

    @Autowired
    ListUserRepository listUserRepository;

    @Autowired
    ExcerptRepository excerptRepository;

	@Test
	public void testBook() throws Exception {

	}

	@Test
    public void testBookReview() throws Exception {
//        bookReviewRepository.save(new BookReview(11, 111, "A", new Timestamp(System.currentTimeMillis())));
//        bookReviewRepository.save(new BookReview(22, 222, "B", new Timestamp(System.currentTimeMillis())));
//
//        List<BookReview> bookReview1 = bookReviewRepository.findByBookId(11);
//        assertThat(bookReview1).isNotNull();
//
//        List<BookReview> bookReview2 = bookReviewRepository.findByUserId(222);
//        assertThat(bookReview2).isNotNull();
    }

    @Test
    public void testUser() throws Exception {
//	    userRepository.save(new User("Amy", new Timestamp(System.currentTimeMillis())));
//	    userRepository.save(new User("Bob", new Timestamp(System.currentTimeMillis())));
//
//	    User user = userRepository.findByUserId(14);
//	    assertThat(user).isNull();
    }

    //BookListService
    @Test
    @Transactional
    public void testBookListService() throws Exception {
//        bookListRepository.save(new BookList("aaa"));
//        bookListRepository.save(new BookList("bbb"));
//        bookListRepository.save(new BookList("cbb"));
//
//        listUserRepository.save(new ListUser(1, bookListRepository.findByName("aaa").getId()));
//        listUserRepository.save(new ListUser(2, bookListRepository.findByName("bbb").getId()));
//        listUserRepository.save(new ListUser(3, bookListRepository.findByName("cbb").getId()));
//
//        List<BookList> bookLists = bookListRepository.searchByUserId(2);
//        Assert.assertEquals(1, bookLists.size());
//
//        listUserRepository.deleteByUserIdAndListId(1 , 1);
//        Assert.assertEquals(2, listUserRepository.findAll().size());
//
//        assertThat(listUserRepository.getByUserIdAndListId(3, 3)).isNull();
//
//        Assert.assertEquals(2, bookListRepository.findByNameContaining("bb").size());
    }

    //ExcerptService
    @Test
    @Transactional
    public void testExcerptService() throws Exception {
//        excerptRepository.save(new Excerpt(1, 1, "qwe", new Timestamp(System.currentTimeMillis())));
//        excerptRepository.save(new Excerpt(2, 2, "zxc", new Timestamp(System.currentTimeMillis())));
//        excerptRepository.save(new Excerpt(2, 3, "zxc", new Timestamp(System.currentTimeMillis())));
//
//        Assert.assertEquals(1, excerptRepository.findByBookId(1).size());
//        Assert.assertEquals(3, excerptRepository.findByUserId(2).size());
//        assertThat(excerptRepository.findByUserId(10)).isNull();
    }

    //FavouriteService
    @Test
    @Transactional
    public void testFavouriteService() throws Exception {
//	    favouriteRepository.save(new Favourite(1, 1, new Timestamp(System.currentTimeMillis())));
//        favouriteRepository.save(new Favourite(1, 3, new Timestamp(System.currentTimeMillis())));
//
//        Assert.assertEquals(1, favouriteRepository.findByUserIdAndBookId(1, 1).size());
//        Assert.assertEquals(0, favouriteRepository.findByUserIdAndBookId(13, 14).size());
//        //favouriteRepository.deleteByUserIdAndBookId(1, 3);
//        Assert.assertEquals(0, favouriteRepository.deleteByUserIdAndBookId(1, 1));
//        Assert.assertEquals(1, favouriteRepository.findAll().size());
    }

    //BookService
    @Test
    @Transactional
    public void testBookService() throws Exception {

    }

    //TagService
    @Test
    public void testTag() throws Exception {
	    bookRepository.save(new Book("bookone"));
	    bookRepository.save(new Book("booktwo"));

        tagRepository.save(new Tag("aaa", 11));
        tagRepository.save(new Tag("bbb", 12));
        tagRepository.save(new Tag("cbb", 13));
        tagRepository.save(new Tag("ddd", 14));
        tagRepository.save(new Tag("eee", 15));
        tagRepository.save(new Tag("qqq", 16));
        tagRepository.save(new Tag("www", 17));
        tagRepository.save(new Tag("rrr", 18));
        tagRepository.save(new Tag("ttt", 19));
        tagRepository.save(new Tag("yyy", 20));
        tagRepository.save(new Tag("uuu", 2));
        //tagRepository.save(new Tag("iii", 3));

        Tag temp = new Tag("iii", 3);
        temp.setBookId(2);
        tagRepository.save(temp);

//        List<Tag> newList = tagRepository.getTag();
//        for (Tag i : newList) {
//            System.out.print(i.getField());
//        }

        List<Book> bookList = tagRepository.findBook("iii");
        for (Book i : bookList) {
            System.out.print(i.getName());
        }
    }

    @Test
    public void testRand() throws Exception {
//        bookListRepository.save(new BookList("aaa", 1));
//        bookListRepository.save(new BookList("bbb", 1));
//        bookListRepository.save(new BookList("cbb", 1));
//        bookListRepository.save(new BookList("ddd", 1));
//        bookListRepository.save(new BookList("eee", 1));
//        bookListRepository.save(new BookList("qqq", 1));
//        bookListRepository.save(new BookList("www", 1));
//        bookListRepository.save(new BookList("rrr", 1));
//        bookListRepository.save(new BookList("ttt", 1));
//        bookListRepository.save(new BookList("yyy", 1));
//        bookListRepository.save(new BookList("uuu", 2));
//        bookListRepository.save(new BookList("iii", 2));
//
//        List<BookList> bookLists = bookListRepository.findByUserId(1);
//        RandomList randomList = new RandomList();
//        List<BookList> newList = randomList.getRandomList(bookLists, 5);
//        for (BookList i : newList) {
//            System.out.print(i.getName());
//        }
    }
}
