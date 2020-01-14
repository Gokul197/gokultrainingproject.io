package com.cognizantmovie.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.movie.model.MovieList;
import com.cognizant.movie.util.DateUtil;


public class MovieListDaoSqlImplTest {

	public static void testGetMovieListAdmin() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###.00");
		List<MovieList> userList = new MovieListDaoSqlImpl().getMovieListAdmin();
		System.out.format("%-10s%-20s%-25s%-15s%-10s%-10s%-10s\n", "ID", "NAME", "DOL", "Category", "Price", "Active",
				"FreeDelivery");

		for (MovieList us : userList) {
			System.out.format("%-10s%-20s%-25s%-15s%-10s%-10s%-10s\n", us.getId(), us.getTitle(),
					sdf.format(us.getDateOfLaunch()), us.getGenre(), df.format(us.getBoxOffice()), us.isActive(),
					us.isHasTeaser());
		}

	}
	public static void testgetMovieListCustomer() {

        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#.00");

        List<MovieList> userList = new MovieListDaoSqlImpl().getMovieListCustomer();
        System.out.format("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Title", "PRICE", "ACTIVE", "DATE-OF-LAUNCH",
                  "CATEGORY", "FREE-DELIVERY");
        for (MovieList us : userList) {
             System.out.format("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", us.getId(), us.getTitle(),
                       df.format(us.getBoxOffice()), us.isActive(), sdf.format(us.getDateOfLaunch()), us.getGenre(),
                       us.isHasTeaser());
        }
    }
	
	public static void testmodifyMovieList() {
        MovieList movieList = new MovieList(1L, "darbar", 278796587, true,
                  new DateUtil().convertToDate("15/02/2020"), "action", true);
        new MovieListDaoSqlImpl().modifyMovies(movieList);
    }
    
	public static void testgetmovieList() {
        System.out.println("\nEnter the id");
        long movieListId=3;
        MovieList movie_list = new MovieListDaoSqlImpl().getMovies(movieListId);
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df= new DecimalFormat("#.00");
        System.out.format("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", movie_list.getId(), movie_list.getTitle(),
                  df.format(movie_list.getBoxOffice()), movie_list.isActive(), sdf.format(movie_list.getDateOfLaunch()), movie_list.getGenre(),
                  movie_list.isHasTeaser());
    }

	


	public static void main(String[] args) {
		
		//testGetMovieListAdmin();
		//testgetMovieListCustomer();
		//testmodifyMovieList();
		testgetmovieList();

	}
}
