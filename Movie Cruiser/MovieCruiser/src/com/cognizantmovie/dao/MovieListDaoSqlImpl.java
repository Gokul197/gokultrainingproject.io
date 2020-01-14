package com.cognizantmovie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.movie.model.MovieList;
import com.cognizant.movie.util.DateUtil;

public class MovieListDaoSqlImpl implements MovieListDao {

	public static final String ADD_USER = "select * from movie_cruiser.movies";
	public static final String GET_MOVIE = "select *from movies where mo_id=? ";
	public static final String MOVIE = "select * from movies where mo_date_of_launch>=CURDATE() and mo_active='Yes'";
	public static final String UPDATE_USER = "update movies set mo_title=?,mo_gross=?,mo_active=?,mo_date_of_launch=?,mo_genre=?,mo_has_teaser=? where mo_id=?";

	@Override
	public List<MovieList> getMovieListAdmin() {
		ArrayList<MovieList> movies = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		try {
			preparedstatement = connection.prepareStatement(ADD_USER);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				MovieList movie = new MovieList();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setTitle(resultSet.getString("mo_title"));
				movie.setBoxOffice(resultSet.getLong("mo_gross"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setActive(resultSet.getString("mo_active").equals("Yes"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				movies.add(movie);
			}

		} catch (SQLException e) {

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}

		}
		return movies;
	}

	@Override
	public List<MovieList> getMovieListCustomer() {
		ArrayList<MovieList> movies = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;

		try {
			preparedstatement = connection.prepareStatement(MOVIE);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				MovieList movie = new MovieList();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setTitle(resultSet.getString("mo_title"));
				movie.setBoxOffice(resultSet.getLong("mo_gross"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setActive(resultSet.getString("mo_active").equals("Yes"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				movies.add(movie);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}
		}

		return movies;
	}

	@Override
	public void modifyMovies(MovieList movieList) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {

			statement = connection.prepareStatement(UPDATE_USER);

			statement.setString(1, movieList.getTitle());
			statement.setFloat(2, movieList.getBoxOffice());
			statement.setString(3, movieList.isActive() ? "Yes" : "No");
			new DateUtil();
			statement.setDate(4, DateUtil.convertToSqlDate(movieList.getDateOfLaunch()));
			statement.setString(5, movieList.getGenre());
			statement.setString(6, movieList.isHasTeaser() ? "Yes" : "No");
			statement.setLong(7, movieList.getId());

			statement.executeUpdate();

		} catch (Exception e) {
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
	public MovieList getMovies(Long MovieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		MovieList movie_List = null;
		try {
			preparedstatement = connection.prepareStatement(GET_MOVIE);

			preparedstatement.setLong(1, MovieListId);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {

				movie_List = new MovieList();
				movie_List.setId(resultSet.getLong("mo_id"));
				movie_List.setTitle(resultSet.getString("mo_title"));
				movie_List.setBoxOffice(resultSet.getLong("mo_gross"));
				movie_List.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie_List.setActive(resultSet.getString("mo_active").equals("Yes"));
				movie_List.setGenre(resultSet.getString("mo_genre"));
				movie_List.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedstatement != null) {
					preparedstatement.close();
				}

				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
			}
		}
		return movie_List;

	}

}
