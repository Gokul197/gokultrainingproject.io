package com.cognizantmovie.dao;

import java.util.List;

import com.cognizant.movie.model.MovieList;

public interface MovieListDao {
	
	public List<MovieList> getMovieListAdmin();

	public List<MovieList> getMovieListCustomer();

	public void modifyMovies(MovieList movieList);

	public MovieList getMovies(Long MovieListId);

}
