package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.DatabaseException;
import exception.DatabaseExceptionMessage;
import model.IRadioModel;
import model.ISellDetailModel;
import model.IUserModel;
import utility.DateFormat;

public class SellDAO {
	
	public static void insertSell(IUserModel user, IRadioModel radio, ISellDetailModel sellDetail) throws DatabaseException {
		String query = "INSERT INTO Sells (num_radio, date, price, user_id, radio_id) VALUES (?, ?, ?, ?, ?);";
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, sellDetail.getNumRadio());
			statement.setDate(2, DateFormat.convertToSQLFormat(sellDetail.getDate()));
			statement.setDouble(3, sellDetail.getPrice());
			statement.setInt(4, user.getID());
			statement.setInt(5, radio.getID());
						
			statement.execute();
			
		} catch (SQLException e) {
			throw new DatabaseException(DatabaseExceptionMessage.DATABASE_QUERY_FAILED);
		}
	}
	
}
