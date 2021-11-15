package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DatabaseException;
import exception.DatabaseExceptionMessage;

/**
 * Classe che si occupa di ottenere la connessione con la base di dati
 */
public class DBConnection {
	private static final String IP = "localhost:3306";
	private static final String DATABASE = "gruppo40";
	private static final String USER = "root";
	private static final String PASSWORD = "12345";

	private static final String jdbcURL = "jdbc:mysql://" + IP + "/" + DATABASE + "?user=" + USER + "&password=" + PASSWORD;
	
	/**
	 * Metodo che si occupa di ottenere la connessione con il database
	 * @return Connessione con il database
	 * @throws DatabaseException
	 */
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
