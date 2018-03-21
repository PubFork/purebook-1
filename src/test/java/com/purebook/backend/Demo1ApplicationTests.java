package com.purebook.backend;

import com.purebook.backend.dao.*;
import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

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
	public void test() throws Exception {
//	    bookRepository.save(new Book("Journey to the west"));
//	    userBookRepository.save(new User("Bob"));
	}

}
