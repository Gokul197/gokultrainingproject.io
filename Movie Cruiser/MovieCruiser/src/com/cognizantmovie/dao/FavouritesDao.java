package com.cognizantmovie.dao;

import com.cognizant.movie.model.Favourites;

public interface FavouritesDao {

	public Favourites getAllFavouritesMovies(Integer userId) throws MoviesEmptyException;

	public void removeFavouritesMovies(Integer userId, long movieListId);

	public void addFavouritesMovies(Integer userId, long movieListId);

}
