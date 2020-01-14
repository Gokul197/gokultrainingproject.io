/*package com.cognizanttruyum.dao;

import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {

		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addcartItem(1, 2l);
		cartDao.addcartItem(1, 5l);// user ID1

		cartDao.addcartItem(2, 2l);// user ID2
		cartDao.addcartItem(2, 3l);
		
	     Cart menuItemListCustomer = cartDao.getAllCartItems(2);
		System.out.println("user Added cart list for checkout");

		for (MenuItem menuItem : menuItemListCustomer.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void testGetAllCartItem() {

	}

	public static void testRemoveCartItem() {

		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("After removing the item");

		try {
			cartDao.removeCartItem(1, 2L);
			// cartDao.removeCartItem(1,5L);

			// cartDao.removeCartItem(2,2l);
			// cartDao.removeCartItem(2, 3l);

			Cart menuItemListCustomer = cartDao.getAllCartItems(1);

			for (MenuItem menuItem : menuItemListCustomer.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws CartEmptyException {

		testAddCartItem();
		testRemoveCartItem();
	}
}*/
