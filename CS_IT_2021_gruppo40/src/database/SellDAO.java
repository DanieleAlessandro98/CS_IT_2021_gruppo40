package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.IRadioModel;
import model.ISellDetailModel;
import model.IUserModel;
import utility.DateFormat;

public class SellDAO {
	
	public static void insertSell(IUserModel user, IRadioModel radio, ISellDetailModel sellDetail) {
		String query = "INSERT INTO Sells (num_radio, date, price, user_id, radio_id) VALUES (?, ?, ?, ?, ?);";
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, sellDetail.getNumRadio());
			statement.setDate(2, DateFormat.convertToSQLFormat(sellDetail.getDate()));
			statement.setDouble(3, sellDetail.getPrice());
			statement.setInt(4, user.getID());
			statement.setInt(5, radio.getID());
						
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
