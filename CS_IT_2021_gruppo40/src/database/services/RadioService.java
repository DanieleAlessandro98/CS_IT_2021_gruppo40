package database.services;

/**
 * Classe che si occupa di interfacciarsi con la relativa classe DAO con lo scopo di acquisire o memorizzare informazioni relative alle radio
 */
import java.util.List;

import database.DAO.RadioDAO;
import exception.DatabaseException;
import model.contracts.IRadioModel;

public class RadioService {

	/**
	 * Metodo che si relaziona con la relativa classe DAO e gestisce eventuali errori
	 * @return Lista contenente i dati di tutte le radio
	 */
	public static List<IRadioModel> getRadiosData() {
		List<IRadioModel> result = null;
		
		try {
			result = RadioDAO.getRadiosData();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Metodo che si relaziona con la relativa classe DAO e gestisce eventuali errori
	 * @param radioID ID della radio selezionata
	 * @return Dati della radio
	 */
	public static IRadioModel getData(int radioID) {
		IRadioModel result = null;
		
		try {
			result = RadioDAO.getData(radioID);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
