package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.contracts.ISellDetailModel;
import observer.ObservableSellDetail;
import observer.ObserverSellDetail;

public class SellDetailModel extends AbstractModel implements ISellDetailModel, ObservableSellDetail {

	private int numRadio;
	private Date date;
	private double price;
	
	private List<ObserverSellDetail> observers;
	
	public SellDetailModel() {
		observers = new ArrayList<>();
	}

	@Override
	public int getNumRadio() {
		return numRadio;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public double getPrice() {
		return price;
	}
	
	@Override
	public void setNumRadio(int numRadio) {
		this.numRadio = numRadio;
		notifyObservers();
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
		notifyObservers();
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
		notifyObservers();
	}

	@Override
	public void addObserver(ObserverSellDetail observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverSellDetail observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverSellDetail ob : observers) {
			ob.updateSellDetail(this);
		}
	}

	@Override
	public boolean isValidData() {		
		if (numRadio <= 0)
			return false;
				
		if (date == null)
			return false;
		
		if (price < 0)
			return false;
		
		return true;
	}

}
