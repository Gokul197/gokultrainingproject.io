package com.cognizant.movie.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.model.Favourites;
import com.cognizantmovie.dao.FavouritesDao;
import com.cognizantmovie.dao.FavouritesDaoSqlImpl;
import com.cognizantmovie.dao.MoviesEmptyException;

/**
 * Servlet implementation class ShowFavoritesServlet
 */
@WebServlet("/ShowFavorites")
public class ShowFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFavoritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		FavouritesDao movieDao = new FavouritesDaoSqlImpl();
		int userId = 1;
		try {
			Favourites cart = movieDao.getAllFavouritesMovies(userId);
			request.setAttribute("cart", cart);
			System.out.println("Successs.........");
			request.getRequestDispatcher("Favourites.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
