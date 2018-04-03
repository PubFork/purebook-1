package com.purebook.backend.dao;

import com.purebook.backend.entity.Favourite;
import com.purebook.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer>{
    //Favourite save(Favourite favourite);
    @Transactional
    int deleteByUserIdAndBookId(String userId, int bookId);
    List<Favourite> findByUserIdAndBookId(String userId, int bookId);

}
