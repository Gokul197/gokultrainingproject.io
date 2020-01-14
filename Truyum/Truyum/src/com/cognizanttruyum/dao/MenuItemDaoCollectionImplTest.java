package com.cognizanttruyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {

		System.out.println("item list for admin");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {

			System.out.println(menuItem);
		}
	}

	public static void testGetMenuItemListCustomer() {// 4.3

		System.out.println("item list for customer");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);

		}
	}

	//public static void testModifyMenuItem() {// 5.4

		//MenuItem item = new MenuItem(5L, "chocolate brownie", 91.00f, true, new DateUtil().convertToDate("10/12/2019"),
				//"Main Course", false);
		//MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		//menuItemDao.modifyMenuItem(item);
		//System.out.println("**Modified List**");
		//testGetMenuItemListAdmin();

	//	MenuItem modified_item = menuItemDao.getMenuItem(item.getId());
		//System.out.println("Modified item details\n" + modified_item);

	//}

	public static void main(String[] arg) {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		//testModifyMenuItem();

	}
}
