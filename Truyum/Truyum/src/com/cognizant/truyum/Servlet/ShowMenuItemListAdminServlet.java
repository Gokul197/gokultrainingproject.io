package com.cognizant.truyum.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.model.MenuItem;
import com.cognizanttruyum.dao.MenuItemDao;
import com.cognizanttruyum.dao.MenuItemDaoSqlImpl;

/**
 * Servlet implementation class menuitemListServlet
 */
@WebServlet("/menuitemListServlet")
public class ShowMenuItemListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMenuItemListAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		request.setAttribute("menuItem", menuItemList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("menu-item-list-admin.jsp");
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
