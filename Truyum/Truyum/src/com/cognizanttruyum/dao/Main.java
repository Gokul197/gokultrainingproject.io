package com.cognizanttruyum.dao;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		
		Connection connection=ConnectionHandler.getConnection();
	      
        System.out.println(connection);
	}

}
