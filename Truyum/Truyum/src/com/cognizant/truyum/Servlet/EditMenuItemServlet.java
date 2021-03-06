package com.cognizant.truyum.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
import com.cognizanttruyum.dao.MenuItemDao;
import com.cognizanttruyum.dao.MenuItemDaoSqlImpl;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet("/EditMenuItem")
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuItemServlet() {
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
		float price = Float.parseFloat(request.getParameter("price"));
		boolean active = request.getParameter("active").equals("Yes");
		Date dateOfLaunch;
		dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
		String category = request.getParameter("category");
		boolean freeDelivery = request.getParameter("freeDelivery") != null;

		MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(menuItem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-menu-item-status.jsp");
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
