package com.cognizanttruyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();

		if (userCarts == null) {
			userCarts = new HashMap<>();
		}
	}

	@Override
	public void addcartItem(long userId, long menuItemId) {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuitem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuItemList().add(menuitem);
		} else {
			Cart cart = new Cart();
			ArrayList<MenuItem> menuItemList = new ArrayList<>();
			menuItemList.add(menuitem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {

		// List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		Cart cart = userCarts.get(userId);
		double total = 0.0f;
		if (cart == null || cart.getMenuItemList().isEmpty()) {
			throw new CartEmptyException();
		}
		List<MenuItem> menuItemList = cart.getMenuItemList();
		for (MenuItem menuItem : menuItemList) {
			total += menuItem.getPrice();
		}

		cart.setTotal(total);
		return cart;
	}

	@Override
	public void removeCartItem(long userID, long menuItemId) {

		List<MenuItem> menuItemList = userCarts.get(userID).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItemList.remove(i);
				return;
			}
		}
	}
}
