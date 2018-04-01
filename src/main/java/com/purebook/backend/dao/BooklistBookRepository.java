package com.purebook.backend.dao;

import com.purebook.backend.entity.Book;
import com.purebook.backend.entity.BooklistBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooklistBookRepository extends JpaRepository<BooklistBook, Integer> {
    List<BooklistBook> findById(int id);
    List<BooklistBook> findByBookId(int bookId);
    //List<BooklistBook> findByUserId(int userId);

    @Query("select b from Book b, BooklistBook lb, ListUser u, BookList l where b.id = lb.bookId and u.listId = lb.bookListId and l.id = u.listId and u.userId = ?1 and l.name = ?2")
    List<Book> searchByBooklistName(String userId, String name);
}
