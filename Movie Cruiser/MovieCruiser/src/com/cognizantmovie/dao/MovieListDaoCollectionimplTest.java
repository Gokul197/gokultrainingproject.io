package com.cognizantmovie.dao;

import java.util.List;

import com.cognizant.movie.model.MovieList;
import com.cognizant.movie.util.DateUtil;

public class MovieListDaoCollectionimplTest {

	public static void testGetMovieListAdmin() {
		//System.out.println("Movies list for admin");
		MovieListDao moviesDao = new MovieListDaoCollectionimpl();
		List<MovieList> movieList = moviesDao.getMovieListAdmin();
		for (MovieList movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testGetMovieListCustomer() {

		//System.out.println("Movies list for customer");
		MovieListDao moviesDao = new MovieListDaoCollectionimpl();

		List<MovieList> movieList = moviesDao.getMovieListCustomer();

		for (MovieList movies : movieList) {
			System.out.println(movies);

		}

	}

	public static void testModifyMovies() {

		MovieList movies = new MovieList(5L, "Avengers 5", 919956876, true, new DateUtil().convertToDate("10/12/2019"),
				"Action", false);
		MovieListDao moviesDao = new MovieListDaoCollectionimpl();
		moviesDao.modifyMovies(movies);
		System.out.println("**Modified Movies List**");
		testGetMovieListAdmin();

		MovieList modified_item = moviesDao.getMovies(movies.getId());
		System.out.println("Modified Movies details\n" + modified_item);

	}

	public static void main(String[] args) {

		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovies();

	}

}
