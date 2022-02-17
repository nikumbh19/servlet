package com.model.persistence.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Connection connection;
	public static Connection getConnection() {
		Properties properties = new Properties();
		InputStream inStream;
		String url,username,password;
		try {
			inStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(inStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		url = properties.getProperty("jdbc.url");
		username = properties.getProperty("jdbc.username");
		password = properties.getProperty("jdbc.password");
		
		 //creating connection object
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection succesfull");
		return connection;
	}
}
