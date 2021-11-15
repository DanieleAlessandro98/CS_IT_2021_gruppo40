package database.services;

/**
 * Classe che si occupa di interfacciarsi con la relativa classe DAO con lo scopo di acquisire o memorizzare informazioni relative alla vendita
 */
import database.DAO.SellDAO;
import exception.DatabaseException;
import model.contracts.IRadioModel;
import model.contracts.ISellDetailModel;
import model.contracts.IUserModel;

public class SellService {
	
	public static void insertSell(IUserModel user, IRadioModel radio, ISellDetailModel sellDetail) {
		try {
			SellDAO.insertSell(user, radio, sellDetail);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	
}
