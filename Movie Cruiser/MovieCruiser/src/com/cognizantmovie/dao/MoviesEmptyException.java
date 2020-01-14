package com.cognizantmovie.dao;

public class MoviesEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2369438368937977890L;

	public MoviesEmptyException() {
		super("Cart is empty");
	}

}
