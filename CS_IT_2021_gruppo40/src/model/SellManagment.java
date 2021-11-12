package model;

import database.SellDAO;

public class SellManagment {
	
	public static void insertSell(IUserModel user, IRadioModel radio, ISellDetailModel sellDetail) {
		SellDAO.insertSell(user, radio, sellDetail);
	}
	
}
