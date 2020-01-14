package com.cognizantmovie.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.movie.model.Favourites;
import com.cognizant.movie.model.MovieList;

public class FavouritesDaocollectionimpl implements FavouritesDao {

	private static HashMap<Integer, Favourites> userFavourites;

	public FavouritesDaocollectionimpl() {
		super();
		if (userFavourites == null) {

			userFavourites = new HashMap<>();
		}
	}

	public void addFavouritesMovies(Integer userId, long movieListId) {
		MovieListDao movieListDao = new MovieListDaoCollectionimpl();
		MovieList movielist = movieListDao.getMovies(movieListId);
		if (userFavourites.containsKey(userId)) {
			userFavourites.get(userId).getMovieList().add(movielist);
		} else {
			Favourites movies = new Favourites();
			ArrayList<MovieList> movieList = new ArrayList<>();
			movieList.add(movielist);
			movies.setMovieList(movieList);
			userFavourites.put(userId, movies);
		}
	}

	@Override
	public void removeFavouritesMovies(Integer userID, long movieListId) {

		List<MovieList> movieList = userFavourites.get(userID).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieListId) {
				movieList.remove(i);
				return;
			}
		}
	}

	@Override
	public Favourites getAllFavouritesMovies(Integer userId) throws MoviesEmptyException {

		Favourites movie = userFavourites.get(userId);

		int total = 0;
		if (movie == null || movie.getMovieList().isEmpty()) {
			throw new MoviesEmptyException();
		}
		List<MovieList> movieList = movie.getMovieList();
		for (MovieList favourites : movieList) {
			favourites.getBoxOffice();
			total++;
		}

		movie.setFavourites(total);
		return movie;
	}
}
