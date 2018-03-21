package com.purebook.backend.dao;

import com.purebook.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //User save(User user); 直接调用save

    User findById(int id);
}
