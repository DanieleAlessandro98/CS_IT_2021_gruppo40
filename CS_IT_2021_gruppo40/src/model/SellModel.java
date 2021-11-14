package model;

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
		if (user.getHalfYearMaxSells() <= UserManagment.getHalfYearCurrentSells(user.getID()))
			System.out.println("Error1 radio vendibili in un semestre....");				// Probabilmente gestito in seguito con exception
		else if (user.getDayCurrentSells() >= MAX_DAY_SELLS)
			System.out.println("Error2 radio vendibili in un giorno....");				// Probabilmente gestito in seguito con exception
		else
			SellManagment.insertSell(user, radio, sellDetail);
	}

	@Override
	public void setUser(Object user) {
		this.user = (IUserModel) user;
	}

	@Override
	public void setRadio(Object radio) {
		this.radio = (IRadioModel) radio;
	}

	@Override
	public void setSellDetail(Object sellDetail) {
		this.sellDetail = (ISellDetailModel) sellDetail;
	}

}
