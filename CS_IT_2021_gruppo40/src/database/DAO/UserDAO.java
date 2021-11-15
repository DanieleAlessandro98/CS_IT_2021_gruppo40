package database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import database.DBConnection;
import exception.DatabaseException;
import exception.DatabaseExceptionMessage;
import model.UserModel;
import model.contracts.IUserModel;
import utility.DateFormat;

public class UserDAO {

	public static int getDayCurrentSells(int userID) throws DatabaseException {
		String query = "SELECT \r\n" + 
				"    COUNT(user_id) AS day_sells\r\n" + 
				"FROM\r\n" + 
				"    Sells\r\n" + 
				"WHERE\r\n" + 
				"    DATE(date) = DATE(NOW()) AND user_id = ?;";
		
		int result = 0;
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getInt("day_sells");
				break;
			}
			
			
		} catch (SQLException e) {
			throw new DatabaseException(DatabaseExceptionMessage.DATABASE_QUERY_FAILED);
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public static int getHalfYearCurrentSells(int userID) throws DatabaseException {
		String query = "SELECT \r\n" + 
				"    COUNT(user_id) AS half_year_sells\r\n" + 
				"FROM\r\n" + 
				"    Sells\r\n" + 
				"WHERE\r\n" + 
				"    user_id = ?\r\n" + 
				"        AND date BETWEEN ? AND ?;";
		
		int result = 0;
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ArrayList<Date> halfYearRange = DateFormat.getHalfYearRange();
			statement.setInt(1, userID);
			statement.setDate(2, DateFormat.convertToSQLFormat(halfYearRange.get(0)));
			statement.setDate(3, DateFormat.convertToSQLFormat(halfYearRange.get(1)));
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getInt("half_year_sells");
				break;
			}
			
			
		} catch (SQLException e) {
			throw new DatabaseException(DatabaseExceptionMessage.DATABASE_QUERY_FAILED);
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public static IUserModel getData(int userID) throws DatabaseException {
		String query = "SELECT \r\n" + 
				"    ud.user_id,\r\n" + 
				"    ud.name,\r\n" + 
				"    ud.surname,\r\n" + 
				"    ud.half_year_max_sells,\r\n" + 
				"    COUNT(s.user_id) AS day_sells\r\n" + 
				"FROM\r\n" + 
				"    Users_Data ud\r\n" + 
				"        LEFT JOIN\r\n" + 
				"    Sells s ON ud.user_id = s.user_id\r\n" + 
				"        AND DATE(s.date) = DATE(NOW())\r\n" + 
				"WHERE\r\n" + 
				"    ud.user_id = ?;";
		
		IUserModel result = null;
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = new UserModel(
						resultSet.getInt("user_id"),
						resultSet.getString("name"),
						resultSet.getString("surname"),
						resultSet.getInt("day_sells"),
						resultSet.getInt("half_year_max_sells"));
				break;
			}
			
			
		} catch (SQLException e) {
			throw new DatabaseException(DatabaseExceptionMessage.DATABASE_QUERY_FAILED);
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
