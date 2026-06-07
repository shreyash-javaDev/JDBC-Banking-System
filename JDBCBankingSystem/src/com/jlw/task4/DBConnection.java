package com.jlw.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	 private static final String URL =
	            "jdbc:mysql://localhost:3306/banking_system";
	    private static final String USER = "root";
	    private static final String PASSWORD = "1010";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
}
}
