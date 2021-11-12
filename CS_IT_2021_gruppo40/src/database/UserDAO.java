package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import utility.DateFormat;

public class UserDAO {

	public static int getDayCurrentSells(int userID) {
		String query = "SELECT COUNT(user_id) AS day_sells FROM Sells WHERE date = date(now()) AND user_id = ?;";
		
		int result = 0;
		
		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getInt("day_sells");
				break;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int getHalfYearCurrentSells(int userID) {
		String query = "SELECT COUNT(user_id) AS half_year_sells FROM Sells WHERE user_id = ? AND date BETWEEN ? AND ?;";
		
		int result = 0;
		
		Connection connection = DBConnection.getConnection();

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
			e.printStackTrace();
		}
		
		return result;
	}
	
}
