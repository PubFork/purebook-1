package com.purebook.backend;

import com.purebook.backend.dao.*;
import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.BookReview;
import com.purebook.backend.entity.User;
import com.sun.tools.classfile.Exceptions_attribute;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

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
    UserBookRepository userBookRepository;

    @Autowired
    UserRepository userRepository;

	@Test
	public void testBook() throws Exception {

	}

	@Test
    public void testBookReview() throws Exception {
        bookReviewRepository.save(new BookReview(11, 111, "A", new Timestamp(System.currentTimeMillis())));
        bookReviewRepository.save(new BookReview(22, 222, "B", new Timestamp(System.currentTimeMillis())));

        List<BookReview> bookReview1 = bookReviewRepository.findByBookId(11);
        assertThat(bookReview1).isNotNull();

        List<BookReview> bookReview2 = bookReviewRepository.findByUserId(222);
        assertThat(bookReview2).isNotNull();
    }

    //Pass
    @Test
    public void testTag() throws Exception {

    }

//    @Test
//    public void testUserBook() throws Exception {
//
//    }

    //Pass
    @Test
    public void testUser() throws Exception {
	    userRepository.save(new User("Amy" ,"amypassword", new Timestamp(System.currentTimeMillis())));
	    userRepository.save(new User("Bob", "bobpassword", new Timestamp(System.currentTimeMillis())));

//	    User user = userRepository.findByName("Bob");
//	    assertThat(user.getCreateTime()).isNotNull();
    }

}
