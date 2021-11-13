package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static int login(String username, String password) {
		String query = "SELECT id FROM Users WHERE username = ? AND password = ?;";
		
		int result = -1;
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getInt("id");
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
