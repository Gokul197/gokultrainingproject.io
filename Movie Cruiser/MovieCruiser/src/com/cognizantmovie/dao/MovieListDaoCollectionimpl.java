package com.cognizantmovie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.MovieList;
import com.cognizant.movie.util.DateUtil;

public class MovieListDaoCollectionimpl implements MovieListDao {

	private static List<MovieList> movieList;

	public MovieListDaoCollectionimpl() {
		super();
		if (movieList == null) {
			movieList = new ArrayList<MovieList>();
			MovieList itemOne = new MovieList(1L, "Avatar", 234456788, true, new DateUtil().convertToDate("15/03/2018"),
					"Adventure", true);
			MovieList itemTwo = new MovieList(2L, "Avengers", 129345667, true,
					new DateUtil().convertToDate("25/03/2017"), "Romance", true);
			MovieList itemThree = new MovieList(3L, "Titanic", 345672345, true,
					new DateUtil().convertToDate("12/12/2020"), "Science Fiction", true);
			MovieList itemFour = new MovieList(4L, "Jurassic world", 678998767, true,
					new DateUtil().convertToDate("20/03/2029"), "Science fiction", true);
			MovieList itemFive = new MovieList(5L, "Avengers:End Game", 919876543, true,
					new DateUtil().convertToDate("15/12/2020"), "Superhero", false);
			movieList.add(itemOne);
			movieList.add(itemTwo);
			movieList.add(itemThree);
			movieList.add(itemFour);
			movieList.add(itemFive);

		}

	}

	@Override
	public List<MovieList> getMovieListAdmin() {

		return movieList;
	}

	@Override
	public List<MovieList> getMovieListCustomer() {

		ArrayList<MovieList> filteredMenuItem = new ArrayList<MovieList>();

		for (MovieList movies : movieList) { // to find launch date is today or before
			if (movies.getDateOfLaunch().after(new Date())) {
				if (movies.isActive()) {
					filteredMenuItem.add(movies);
				}
			}
		}
		return filteredMenuItem;
	}

	@Override
	public void modifyMovies(MovieList movies) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movies.getId()) {
				movieList.set(i, movies);
			}
		}
	}

	@Override
	public MovieList getMovies(Long MovieListId) {

		for (MovieList movieList : movieList) {
			if (movieList.getId() == MovieListId) {
				return movieList;
			}
		}
		return null;
	}

}
