package com.cognizantmovie.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;

import com.cognizant.movie.model.Favourites;
import com.cognizant.movie.model.MovieList;

public class FavouritesDaoSqlImplTest {

	public static void addcarttoMenuItem() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int userId = 1;
		System.out.println("Enter the Cart Id to Add");
		int movieId = Integer.parseInt(bf.readLine());
		new FavouritesDaoSqlImpl().addFavouritesMovies(userId, movieId);
	}

	public static void removeMenuItem() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int userId = 1;
		System.out.println("Enter the Cart Id to Delete");
		long movieId = Long.parseLong(bf.readLine());
		new FavouritesDaoSqlImpl().removeFavouritesMovies(userId, movieId);
	}

	public static void getItem() throws MoviesEmptyException {
		int userId = 1;
		Favourites cart = new FavouritesDaoSqlImpl().getAllFavouritesMovies(userId);
		List<MovieList> movieList = cart.getMovieList();
		int total = cart.getFavourites();
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.format("%-10s%-20s%-15s\n", "NAME", "FREEDELIVERY", "PRICE");
		String freeDelivery;
		for (MovieList menuItem : movieList) {
			if (menuItem.isHasTeaser() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-15s\n", menuItem.getTitle(), freeDelivery,
					df.format(menuItem.getBoxOffice()));

		}
		System.out.println("Number of Favorites" + total);
	}

	public static void main(String[] args) throws NumberFormatException, IOException, MoviesEmptyException {

		addcarttoMenuItem();
		removeMenuItem();
		getItem();

	}

}
