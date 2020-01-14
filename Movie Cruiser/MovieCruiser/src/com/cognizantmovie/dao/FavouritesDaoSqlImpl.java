package com.cognizantmovie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.movie.model.Favourites;
import com.cognizant.movie.model.MovieList;

public class FavouritesDaoSqlImpl implements FavouritesDao {

	public static final String ADD_MOVIESTO_FAVORITE = "insert into favorite(fv_us_id,fv_mo_id) values(?,?)";

	public static final String GET_MOVIES = "select movies.mo_id,movies.mo_title,movies.mo_gross,movies.mo_active,movies.mo_genre,movies.mo_date_of_launch,movies.mo_has_teaser from favorite\r\n"
			+ "inner join movies on movies.mo_id=favorite.fv_mo_id\r\n"
			+ "inner join user on user.us_id=favorite.fv_us_id\r\n" + "where user.us_id=?";

	public static final String GET_FAVORITES = "select count(movies.mo_id) as mo_favorites from favorite\r\n"
			+ "inner join movies on movies.mo_id=favorite.fv_mo_id\r\n"
			+ "inner join user on user.us_id=favorite.fv_us_id\r\n" + "where user.us_id=?";
	public static final String DELETE_MOVIES = "delete from favorite where fv_us_id=? AND fv_mo_id=? limit 1 ";

	@Override
	public void addFavouritesMovies(Integer userId, long movieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {

			statement = connection.prepareStatement(ADD_MOVIESTO_FAVORITE);
			statement.setLong(1, userId);
			statement.setLong(2, movieListId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected" + noOfRows);

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}
		}
	}

	@Override
	public Favourites getAllFavouritesMovies(Integer userId) throws MoviesEmptyException {
		ArrayList<MovieList> movies = new ArrayList<MovieList>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MovieList movie = null;
		Favourites favorites = new Favourites();

		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES);
			preparedStatement.setLong(1, userId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				movie = new MovieList();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setTitle(resultSet.getString("mo_title"));
				movie.setBoxOffice(resultSet.getLong("mo_gross"));
				movie.setActive(resultSet.getString("mo_active").equals("Yes"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				movies.add(movie);
			}
			if (movies.size() == 0) {
				throw new MoviesEmptyException();
			}
			favorites.setMovieList(movies);
			preparedStatementTotal = connection.prepareStatement(GET_FAVORITES);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			int fav = 0;
			while (resultSetTotal.next()) {
				fav = resultSetTotal.getInt("mo_favorites");
			}

			favorites.setFavourites(fav);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (preparedStatementTotal != null) {
					preparedStatementTotal.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}

		return favorites;

	}

	@Override
	public void removeFavouritesMovies(Integer userId, long movieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {

			statement = connection.prepareStatement(DELETE_MOVIES);
			statement.setLong(1, userId);
			statement.setLong(2, movieListId);

			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected" + noOfRows);

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}
		}

	}

}
