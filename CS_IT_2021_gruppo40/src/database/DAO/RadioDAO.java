package database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import exception.DatabaseException;
import exception.DatabaseExceptionMessage;
import model.Brand;
import model.RadioModel;
import model.Type;
import model.contracts.IRadioModel;

public class RadioDAO {

	public static List<IRadioModel> getRadiosData() throws DatabaseException {
		String query = "SELECT \r\n" + 
				"    r.id,\r\n" + 
				"    r.size,\r\n" + 
				"    r.color,\r\n" + 
				"    r.optional,\r\n" + 
				"    r.antenna,\r\n" + 
				"    b.name AS brand_name,\r\n" + 
				"    t.name AS type_name\r\n" + 
				"FROM\r\n" + 
				"    Radios r\r\n" + 
				"        JOIN\r\n" + 
				"    Brands b ON r.brand = b.id\r\n" + 
				"        JOIN\r\n" + 
				"    Types t ON r.type = t.id;";
		
		List<IRadioModel> result = new ArrayList<>();
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(new RadioModel(
						resultSet.getInt("id"),
						Brand.valueOf(resultSet.getString("brand_name")),
						Type.valueOf(resultSet.getString("type_name")),
						resultSet.getInt("size"),
						resultSet.getString("color"),
						resultSet.getString("optional"),
						resultSet.getString("antenna")));
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
	
	public static IRadioModel getData(int radioID) throws DatabaseException {
		String query = "SELECT \r\n" + 
				"    r.id,\r\n" + 
				"    r.size,\r\n" + 
				"    r.color,\r\n" + 
				"    r.optional,\r\n" + 
				"    r.antenna,\r\n" + 
				"    b.name AS brand_name,\r\n" + 
				"    t.name AS type_name\r\n" + 
				"FROM\r\n" + 
				"    Radios r\r\n" + 
				"        JOIN\r\n" + 
				"    Brands b ON r.brand = b.id\r\n" + 
				"        JOIN\r\n" + 
				"    Types t ON r.type = t.id\r\n" + 
				"WHERE\r\n" + 
				"    r.id = ?;";
		
		IRadioModel result = null;
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, radioID);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = new RadioModel(
						resultSet.getInt("id"),
						Brand.valueOf(resultSet.getString("brand_name")),
						Type.valueOf(resultSet.getString("type_name")),
						resultSet.getInt("size"),
						resultSet.getString("color"),
						resultSet.getString("optional"),
						resultSet.getString("antenna"));
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
