package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.DatabaseException;
import exception.DatabaseExceptionMessage;
import utility.Hash;

public class LoginDAO {

	public static int login(String username, String password) throws DatabaseException {
		String query = "SELECT id FROM Users WHERE username = ? AND password = ?;";
		
		int result = -1;
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, Hash.getMD5String(password));
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getInt("id");
				break;
			}
			
		} catch (SQLException e) {
			throw new DatabaseException(DatabaseExceptionMessage.DATABASE_QUERY_FAILED);
		}
		
		return result;
	}
	
}
