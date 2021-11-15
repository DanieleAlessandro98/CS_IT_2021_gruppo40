package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DatabaseException;
import exception.DatabaseExceptionMessage;

public class DBConnection {
	private static final String ip = "localhost:3306";
	private static final String database = "gruppo40";
	private static final String user = "root";
	private static final String password = "12345";

	private static final String jdbcURL = "jdbc:mysql://" + ip + "/" + database + "?user=" + user + "&password=" + password;
	
	public static Connection getConnection() throws DatabaseException {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(jdbcURL);
		} catch (SQLException e) {
			throw new DatabaseException(DatabaseExceptionMessage.DATABASE_CONNECTION_FAILED);
		}
		
		return connection;
	}
}
