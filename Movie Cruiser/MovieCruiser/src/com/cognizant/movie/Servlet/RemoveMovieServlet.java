package com.cognizant.movie.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizantmovie.dao.FavouritesDao;
import com.cognizantmovie.dao.FavouritesDaoSqlImpl;
import com.cognizantmovie.dao.MoviesEmptyException;

/**
 * Servlet implementation class RemoveMovieServlet
 */
@WebServlet("/RemoveMovie")
public class RemoveMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveMovieServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = 1;
		Long movieListId = Long.parseLong(request.getParameter("id"));
		FavouritesDao movieDao = new FavouritesDaoSqlImpl();
		movieDao.removeFavouritesMovies(userId, movieListId);

		try {
			request.setAttribute("cart", movieDao.getAllFavouritesMovies(userId));
			request.setAttribute("message", true);
			request.getRequestDispatcher("Favourites.jsp").forward(request, response);
			request.setAttribute("addMovieStatus", true);

		} catch (MoviesEmptyException e) {

			request.getRequestDispatcher("movies-empty.jsp").forward(request, response);
		}
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
