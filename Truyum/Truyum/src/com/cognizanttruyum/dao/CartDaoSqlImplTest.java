package com.cognizanttruyum.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void addcarttoMenuItem() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Cart Id to Add");
		long menuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().addcartItem(userId, menuItemId);

	}

	public static void removeMenuItem() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Cart Id to Add");
		long menuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().removeCartItem(userId, menuItemId);

	}

	public static void getItem() throws CartEmptyException {
		long userId = 2;
		Cart cart = new CartDaoSqlImpl().getAllCartItems(userId);
		List<MenuItem> menuItemList = cart.getMenuItemList();
		double total = cart.getTotal();
		DecimalFormat df = new DecimalFormat("#.00");

		System.out.format("%-10s%-20s%-15s\n", "NAME", "FREEDELIVERY", "PRICE");
		String freeDelivery;
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.isFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-15s\n", menuItem.getName(), freeDelivery, df.format(menuItem.getPrice()));

		}
		System.out.println("Total=" + total);
	}

	public static void main(String[] args) throws IOException, CartEmptyException {
		// addcarttoMenuItem();
		// removeMenuItem();
		getItem();

	}

}
