package com.purebook.backend.dao;

import com.purebook.backend.entity.ListUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListUserRepository extends JpaRepository<ListUser, Integer> {
    //List<ListUser> findByUserId(int userId);
    int deleteByUserIdAndListId(String userId, int listId);

    //@Query("select l from ListUser l, BookList b where l.userId = ?1 and l.listId = b.id and b.name = ?2")
    ListUser getByUserIdAndListId(String userId, int listId);
}
