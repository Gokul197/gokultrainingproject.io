package com.cognizant.movie.model;

import java.util.List;

public class Favourites {
	
	private List<MovieList> movieList;
	private int favourites;

	public Favourites() {
		super();
	}

	public Favourites(List<MovieList> movieList, int favourites) {
		super();
		this.movieList = movieList;
		this.favourites = favourites;
	}

	public List<MovieList> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MovieList> movieList) {
		this.movieList = movieList;
	}

	public int getFavourites() {
		return favourites;
	}

	public void setFavourites(int favourites) {
		this.favourites = favourites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + favourites;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favourites other = (Favourites) obj;
		if (favourites != other.favourites)
			return false;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favourites [movieList=" + movieList + ", favourites=" + favourites + "]";
	}

}
