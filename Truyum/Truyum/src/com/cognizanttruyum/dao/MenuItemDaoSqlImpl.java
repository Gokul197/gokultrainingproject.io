package com.cognizanttruyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public static final String ADD_USER = "select * from menu_item";
	public static final String MENU = " select * from menu_item where me_date_of_launch>=CURDATE() and me_active='Yes' ";
	public static final String UPDATE_USER = "update menu_item set me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_category=?,me_free_delivery=? where me_id=?";
	public static final String GET_MENU_ITEM = "select *from menu_item where me_id=? ";

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> userList = new ArrayList<>();

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;

		try {
			preparedstatement = connection.prepareStatement(ADD_USER);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				MenuItem user = new MenuItem();
				user.setId(resultSet.getLong("me_id"));
				user.setName(resultSet.getString("me_name"));
				user.setPrice(resultSet.getFloat("me_price"));
				user.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				user.setActive(resultSet.getString("me_active").equals("Yes"));
				user.setCategory(resultSet.getString("me_category"));
				user.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				userList.add(user);
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

			} catch (SQLException e) {

			}
		}

		return userList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> userList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;

		try {
			preparedstatement = connection.prepareStatement(MENU);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				MenuItem user = new MenuItem();
				user.setId(resultSet.getLong("me_id"));
				user.setName(resultSet.getString("me_name"));
				user.setPrice(resultSet.getFloat("me_price"));
				user.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				user.setActive(resultSet.getString("me_active").equals("Yes"));
				user.setCategory(resultSet.getString("me_category"));
				user.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				userList.add(user);
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

		return userList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {

			statement = connection.prepareStatement(UPDATE_USER);

			statement.setString(1, menuItem.getName());
			statement.setFloat(2, menuItem.getPrice());
			statement.setString(3, menuItem.isActive() ? "Yes" : "No");
			new DateUtil();
			statement.setDate(4, DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			statement.setString(5, menuItem.getCategory());
			statement.setString(6, menuItem.isFreeDelivery() ? "Yes" : "No");
			statement.setLong(7, menuItem.getId());

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
	public MenuItem getMenuItem(Long menuItemId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		MenuItem menu_Item = null;
		try {
			preparedstatement = connection.prepareStatement(GET_MENU_ITEM);

			preparedstatement.setLong(1, menuItemId);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {

				menu_Item = new MenuItem();
				menu_Item.setId(resultSet.getLong("me_id"));
				menu_Item.setName(resultSet.getString("me_name"));
				menu_Item.setPrice(resultSet.getFloat("me_price"));
				menu_Item.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menu_Item.setActive(resultSet.getString("me_active").equals("Yes"));
				menu_Item.setCategory(resultSet.getString("me_category"));
				menu_Item.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));

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

				connection.close();

			} catch (SQLException e) {
			}
		}
		return menu_Item;

	}

}
