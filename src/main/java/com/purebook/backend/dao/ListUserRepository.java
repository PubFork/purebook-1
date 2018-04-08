package com.purebook.backend.dao;

import com.purebook.backend.entity.ListUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListUserRepository extends JpaRepository<ListUser, Integer> {
    int deleteByUserIdAndListId(String userId, int listId);

    ListUser getByUserIdAndListId(String userId, int listId);
}
