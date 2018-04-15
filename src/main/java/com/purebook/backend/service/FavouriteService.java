package com.purebook.backend.service;

import com.purebook.backend.dao.FavouriteRepository;
import com.purebook.backend.entity.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Service
public class FavouriteService {

	@Autowired
    FavouriteRepository favouriteRepository;

	public boolean addFavourite(String userId, int bookId) {
		return favouriteRepository.save(
				new Favourite(userId, bookId, new Timestamp(System.currentTimeMillis()))) != null;
	}

	@Transactional
	public boolean removeFavourite(String userId, int bookId) {
		return favouriteRepository.deleteByUserIdAndBookId(userId, bookId) == 1;
	}

	public boolean isFavourite(String userId, int bookId) {
        return favouriteRepository.findByUserIdAndBookId(userId, bookId).size() != 0;
	}
}
