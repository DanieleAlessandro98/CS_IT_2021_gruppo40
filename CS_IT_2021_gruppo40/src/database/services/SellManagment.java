package database.services;

import database.DAO.SellDAO;
import exception.DatabaseException;
import model.contracts.IRadioModel;
import model.contracts.ISellDetailModel;
import model.contracts.IUserModel;

public class SellManagment {
	
	public static void insertSell(IUserModel user, IRadioModel radio, ISellDetailModel sellDetail) {
		try {
			SellDAO.insertSell(user, radio, sellDetail);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	
}
