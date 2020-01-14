package com.cognizant.truyum.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizanttruyum.dao.CartDao;
import com.cognizanttruyum.dao.CartDaoSqlImpl;
import com.cognizanttruyum.dao.CartEmptyException;

/**
 * Servlet implementation class RemoveCartServelt
 */
@WebServlet("/RemoveCart")
public class RemoveCartServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveCartServelt() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long userId = 1l;
		Long menuItemId = Long.parseLong(request.getParameter("id"));

		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(userId, menuItemId);

		try {
			request.setAttribute("cart", cartDao.getAllCartItems(userId));
			request.setAttribute("message", true);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			request.setAttribute("addCartStatus", true);

		} catch (CartEmptyException e) {

			request.getRequestDispatcher("cart-empty.jsp").forward(request, response);
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
