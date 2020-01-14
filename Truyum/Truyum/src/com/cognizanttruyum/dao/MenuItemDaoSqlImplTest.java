package com.cognizanttruyum.dao;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
import com.cognizanttruyum.dao.MenuItemDaoSqlImpl;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###.00");
		List<MenuItem> userList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.format("%-10s%-20s%-25s%-15s%-10s%-10s%-10s\n", "ID", "NAME", "DOL", "Category", "Price", "Active",
				"FreeDelivery");

		for (MenuItem us : userList) {
			System.out.format("%-10s%-20s%-25s%-15s%-10s%-10s%-10s\n", us.getId(), us.getName(),
					sdf.format(us.getDateOfLaunch()), us.getCategory(), df.format(us.getPrice()), us.isActive(),
					us.isFreeDelivery());

		}

	}

	public static void testGetMenuItemListCustomer() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###.00");
		List<MenuItem> userList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		for (MenuItem us1 : userList) {
			if ((us1.isActive()) != false) {
				System.out.format("%-10s%-20s%-25s%-15s%-10s%-10s%-10s\n", us1.getId(), us1.getName(),
						sdf.format(us1.getDateOfLaunch()), us1.getCategory(), df.format(us1.getPrice()), us1.isActive(),
						us1.isFreeDelivery());
			}
		}

	}

	public static void testGetModifyMenuItem() {

		MenuItem menuItem = new MenuItem(1L, "Idly", 1235.23f, true, new DateUtil().convertToDate("14/03/2019"),
				"Dessert", true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);

	}

	public static void testGetMenuItem() {

		long menuItemId = 4;
		MenuItem menu_Item = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###.00");
		System.out.format("%-10s%-20s%-25s%-15s%-10s%-10s%-10s\n", "ID", "NAME", "DOL", "Category", "Price", "Active",
				"FreeDelivery");
		System.out.format("%-10s%-20s%-25s%-15s%-10s%-10s%-10s\n", menu_Item.getId(), menu_Item.getName(),
				sdf.format(menu_Item.getDateOfLaunch()), menu_Item.getCategory(), df.format(menu_Item.getPrice()),
				menu_Item.isActive(), menu_Item.isFreeDelivery());

	}

	public static void main(String[] args) throws IOException, ParseException {
		// testGetMenuItemListAdmin();
		// testGetMenuItemListCustomer();
		testGetModifyMenuItem();
		// testGetMenuItem();
	}

}
