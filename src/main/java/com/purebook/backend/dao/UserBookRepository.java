package com.purebook.backend.dao;

import com.purebook.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookRepository extends JpaRepository<User, Integer>{

    //TODO
    //addCollection

    //TODO
    //removeCollection
    int deleteByUser_IDAndBook_Id(int userId, int bookId);

    //TODO
    //isCollected

}
