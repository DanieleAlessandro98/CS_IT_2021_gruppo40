package model;

import java.util.Date;

public class SellModel implements ISellModel {

	private IUserModel user;
	private IRadioModel radio;
	private ISellDetailModel sellDetail;
	
	private static final int MAX_DAY_SELLS = 50;
	
	public SellModel() {}
	
	public SellModel(IUserModel user, IRadioModel radio, ISellDetailModel sellDetail) {
		this.user = user;
		this.radio = radio;
		this.sellDetail = sellDetail;
	}
	
	@Override
	public IUserModel getUser() {
		return user;
	}

	@Override
	public IRadioModel getRadio() {
		return radio;
	}

	@Override
	public ISellDetailModel getSellDetail() {
		return sellDetail;
	}

	@Override
	public void insertSell() {
		
		// Inizio simulazione dati
		IUserModel tempUser = new UserModel(1, "name", "surname", 0, 10);
		IRadioModel tempRadio = new RadioModel(1, Brand.BRAND1, Type.TYPE1, 1, "Black", "optional", "antenna");
		ISellDetailModel tempSellDetail = new SellDetailModel(100, new Date(), 20.10);
		// Fine simulazione dati
		
		tempUser.setDayCurrentSells(UserManagment.getDayCurrentSells(tempUser.getID()));

		this.user = tempUser;
		this.radio = tempRadio;
		this.sellDetail = tempSellDetail;
		
		if (user.getHalfYearMaxSells() <= UserManagment.getHalfYearCurrentSells(user.getID()))
			System.out.println("Error1 radio vendibili in un semestre....");				// Probabilmente gestito in seguito con exception
		else if (user.getDayCurrentSells() >= MAX_DAY_SELLS)
			System.out.println("Error2 radio vendibili in un giorno....");				// Probabilmente gestito in seguito con exception
		else
			SellManagment.insertSell(user, radio, sellDetail);
	}

}
