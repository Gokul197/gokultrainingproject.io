package com.cognizant.movie.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.model.MovieList;
import com.cognizant.movie.util.DateUtil;
import com.cognizantmovie.dao.MovieListDao;
import com.cognizantmovie.dao.MovieListDaoSqlImpl;

/**
 * Servlet implementation class EditMovieListServlet
 */
@WebServlet("/EditMovieList")
public class EditMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieListServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		long price = Long.parseLong(request.getParameter("price"));
		boolean active = request.getParameter("active").equals("Yes");
		Date dateOfLaunch;
		dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
		String category = request.getParameter("genre");
		boolean freeDelivery = request.getParameter("hasTeaser") != null;
		MovieList movieList = new MovieList(id, name, price, active, dateOfLaunch, category, freeDelivery);
		MovieListDao movieListDao = new MovieListDaoSqlImpl();
		movieListDao.modifyMovies(movieList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-movie-status.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
