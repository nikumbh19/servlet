package com.model.persistence.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.model.persistence.factory.ConnectionFactory;

public class UserDaoImpl implements UserDao{

	private Connection connection;
	
	public UserDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public void addUser(User user) {
		try {
			PreparedStatement insertData = connection
					.prepareStatement("insert into users(" + "username,password,profile) values (?,?,?)");
			insertData.setString(1, user.getUsername());
			insertData.setString(2, user.getPassword());
			insertData.setString(3, user.getProfile());
			insertData.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Optional<User> getUser(String username, String password){
		User user = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from users where username=? and password=?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				user = new User(result.getString(1), result.getString(2), result.getString(3));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(user);
	}

}
