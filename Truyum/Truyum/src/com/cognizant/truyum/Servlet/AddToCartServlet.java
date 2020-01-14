package com.cognizant.truyum.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.model.MenuItem;
import com.cognizanttruyum.dao.CartDao;
import com.cognizanttruyum.dao.CartDaoSqlImpl;
import com.cognizanttruyum.dao.MenuItemDao;
import com.cognizanttruyum.dao.MenuItemDaoSqlImpl;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long userId = 1l;
		Long menuItemId = Long.parseLong(request.getParameter("menuItemId"));

		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addcartItem(userId, menuItemId);

		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemListCustomer = menuItemDao.getMenuItemListCustomer();

		request.setAttribute("menuItem", menuItemListCustomer);
		request.setAttribute("addCartStatus", true);

		request.getRequestDispatcher("menu-item-list-customer.jsp").forward(request, response);

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
