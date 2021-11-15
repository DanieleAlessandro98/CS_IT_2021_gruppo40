package model;

import java.util.ArrayList;
import java.util.List;

import database.services.SellService;
import database.services.UserService;
import exception.SellException;
import exception.SellExceptionMessage;
import model.contracts.IRadioModel;
import model.contracts.ISellDetailModel;
import model.contracts.ISellModel;
import model.contracts.IUserModel;
import observer.ObservableSell;
import observer.ObserverSell;

public class SellModel extends AbstractModel implements ISellModel, ObservableSell {

	private IUserModel user;
	private IRadioModel radio;
	private ISellDetailModel sellDetail;
	
	private List<ObserverSell> observers;
	
	private static final int MAX_DAY_SELLS = 50;
	
	public SellModel() {
		observers = new ArrayList<>();
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
		else if (user.getHalfYearMaxSells() <= UserService.getHalfYearCurrentSells(user.getID())) {
			exception = true;
			exceptionMessage = SellExceptionMessage.SELL_HALF_YEAR_MAX_SELLS;
		}
		else if (user.getDayCurrentSells() >= MAX_DAY_SELLS) {
			exception = true;
			exceptionMessage = SellExceptionMessage.SELL_DAY_MAX_SELLS;
		}
		
		if (exception)
			throw new SellException(exceptionMessage);
		
		SellService.insertSell(user, radio, sellDetail);
		notifyObservers();
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

	@Override
	public void addObserver(ObserverSell observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverSell observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverSell ob : observers) {
			ob.updateSell();
		}
	}

}
