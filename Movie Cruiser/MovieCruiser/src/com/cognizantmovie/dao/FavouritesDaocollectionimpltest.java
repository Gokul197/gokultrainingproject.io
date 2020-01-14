package com.cognizantmovie.dao;

import com.cognizant.movie.model.Favourites;
import com.cognizant.movie.model.MovieList;

public class FavouritesDaocollectionimpltest {

	public static void testAddFavouritesMovies() throws MoviesEmptyException {

		FavouritesDao favourites = new FavouritesDaocollectionimpl();
		favourites.addFavouritesMovies(1, 2l);
		favourites.addFavouritesMovies(1, 5l);
		favourites.addFavouritesMovies(1, 3l);

		favourites.addFavouritesMovies(2, 2l);
		favourites.addFavouritesMovies(2, 3l);

		Favourites movieListCustomer = favourites.getAllFavouritesMovies(1);
		System.out.println("User Added Movies in the Favourites are");

		int count = 0;
		int total = 0;
		for (MovieList movies1 : movieListCustomer.getMovieList()) {
			System.out.println(movies1);
			total += movies1.getBoxOffice();
			count++;
		}
		System.out.println("Number of favourites=" + count);
		System.out.println("Overall Gross=" + total);
	}

	public static void testRemoveFavouritesMovies() {

		FavouritesDao moviesDao = new FavouritesDaocollectionimpl();
		System.out.println("After removing the movie from the favourites");

		try {

			moviesDao.removeFavouritesMovies(1, 2L);
			moviesDao.removeFavouritesMovies(1, 5l);
			Favourites movieListCustomer = moviesDao.getAllFavouritesMovies(1);
			int total = 0;
			int count = 0;
			for (MovieList movies : movieListCustomer.getMovieList()) {
				System.out.println(movies);
				total += movies.getBoxOffice();
				count++;
			}
			System.out.println("Number of favourites=" + count);
			System.out.println("Overall Gross=" + total);

		} catch (MoviesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testgetAllFavouritesMovies() {

		Favourites ff = new Favourites();

		System.out.println("Overall Gross=" + ff.getFavourites());

	}

	public static void main(String[] args) throws MoviesEmptyException {

		testAddFavouritesMovies();
		testRemoveFavouritesMovies();
		testgetAllFavouritesMovies();

	}
}
