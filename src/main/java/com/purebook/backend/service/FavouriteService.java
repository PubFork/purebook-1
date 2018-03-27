package com.purebook.backend.service;

import com.purebook.backend.dao.FavouriteRepository;
import com.purebook.backend.entity.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FavouriteService {

	@Autowired
    FavouriteRepository favouriteRepository;

	public void addFavourite(int userId, int bookId) {
		favouriteRepository.save(new Favourite(userId, bookId, new Timestamp(System.currentTimeMillis())));
	}

	public int removeFavourite(int userId, int bookId){
		return favouriteRepository.deleteByUserIdAndBookId(userId, bookId);
	}


	public boolean isFavourite(int userId, int bookId){
		List<Favourite> favourites = favouriteRepository.findByUserIdAndBookId(userId, bookId);
        return favourites != null;
	}
}
