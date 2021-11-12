package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static boolean login(String username, String password) {
		String query = "SELECT username, password FROM Users WHERE username = ? AND password = ?;";
		
		boolean result = false;
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = true;
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
