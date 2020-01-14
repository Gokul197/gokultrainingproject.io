package com.cognizanttruyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		super();
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			MenuItem itemOne = new MenuItem(1L, "Sandwich", 99.00f,true, new DateUtil().convertToDate("15/03/2020"),
					"starters", true);
			MenuItem itemTwo = new MenuItem(2L, "Burger", 129.00f, true, new DateUtil().convertToDate("25/03/2020"),
					"Main Course", true);
			MenuItem itemThree = new MenuItem(3L, "Pizza", 149.00f, true, new DateUtil().convertToDate("12/12/2020"),
					"dessert", true);
			MenuItem itemFour = new MenuItem(4L, "French fries", 199.00f, true,
					new DateUtil().convertToDate("20/03/2029"), "Main Course", true);
			MenuItem itemFive = new MenuItem(5L, "chocolate", 919.00f, true, new DateUtil().convertToDate("13/12/2020"),
					"Main Course", true);
			menuItemList.add(itemOne);
			menuItemList.add(itemTwo);
			menuItemList.add(itemThree);
			menuItemList.add(itemFour);
			menuItemList.add(itemFive);
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// create arrayList
		ArrayList<MenuItem> filteredMenuItem = new ArrayList<MenuItem>();

		for (MenuItem menuItem : menuItemList) { // to find launch date is today or before
			if (menuItem.getDateOfLaunch().after(new Date())) {
				if (menuItem.isActive()) {
					filteredMenuItem.add(menuItem);
				}
			}
		}
		return filteredMenuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItem.getId()) {
				menuItemList.set(i, menuItem);
			}
		}

	}

	@Override
	public MenuItem getMenuItem(Long menuItemId) {

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				return menuItem;
			}
		}
		return null;
	}
}
