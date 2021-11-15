package model;

import exception.SellException;
import exception.SellExceptionMessage;

public class SellModel extends AbstractModel implements ISellModel {

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
	public void insertSell() throws SellException {
		boolean exception = false;
		String exceptionMessage = null;
		
		if (!isValidData()) {
			exception = true;
			exceptionMessage = SellExceptionMessage.SELL_INVALID_DATA;
		}
		else if (!user.isValidData()) {
			exception = true;
			exceptionMessage = SellExceptionMessage.SELL_INVALID_USER_DATA;
		}
		else if (!radio.isValidData()) {
			exception = true;
			exceptionMessage = SellExceptionMessage.SELL_INVALID_RADIO_DATA;
		}
		else if (!sellDetail.isValidData()) {
			exception = true;
			exceptionMessage = SellExceptionMessage.SELL_INVALID_SELL_DETAIL_DATA;
		}
		else if (user.getHalfYearMaxSells() <= UserManagment.getHalfYearCurrentSells(user.getID())) {
			exception = true;
			exceptionMessage = SellExceptionMessage.SELL_HALF_YEAR_MAX_SELLS;
		}
		else if (user.getDayCurrentSells() >= MAX_DAY_SELLS) {
			exception = true;
			exceptionMessage = SellExceptionMessage.SELL_DAY_MAX_SELLS;
		}
		
		if (exception)
			throw new SellException(exceptionMessage);
		
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

	@Override
	public boolean isValidData() {
		if (user == null)
			return false;
		
		if (radio == null)
			return false;

		if (sellDetail == null)
			return false;

		return true;
	}

}
