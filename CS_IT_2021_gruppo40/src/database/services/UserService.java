package database.services;

/**
 * Classe che si occupa di interfacciarsi con la relativa classe DAO con lo scopo di acquisire o memorizzare informazioni relative all'utente
 */
import database.DAO.UserDAO;
import exception.DatabaseException;
import model.contracts.IUserModel;

public class UserService {

	/**
	 * Metodo che si relaziona con la relativa classe DAO e gestisce eventuali errori
	 * @param userID ID dell'utente
	 * @return Numero di vendite giornaliere
	 */
	public static int getDayCurrentSells(int userID) {
		int result = -1;
		
		try {
			result = UserDAO.getDayCurrentSells(userID);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Metodo che si relaziona con la relativa classe DAO e gestisce eventuali errori
	 * @param userID ID dell'utente
	 * @return Numero di vendite del semestre
	 */
	public static int getHalfYearCurrentSells(int userID) {
		int result = -1;

		try {
			result = UserDAO.getHalfYearCurrentSells(userID);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Metodo che si relaziona con la relativa classe DAO e gestisce eventuali errori
	 * @param userID ID dell'utente selezionato
	 * @return Dati dell'utente
	 */
	public static IUserModel getData(int userID) {
		IUserModel result = null;
		
		try {
			result = UserDAO.getData(userID);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
