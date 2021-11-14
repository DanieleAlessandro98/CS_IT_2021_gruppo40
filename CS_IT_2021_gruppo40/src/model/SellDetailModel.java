package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import observer.ObservableSellDetail;
import observer.ObserverSellDetail;

public class SellDetailModel implements ISellDetailModel, ObservableSellDetail {

	private int numRadio;
	private Date date;
	private double price;
	
	private List<ObserverSellDetail> observers;
	
	/*
	private IUserModel user;
	private IRadioModel radio;
	*/
	
	public SellDetailModel() {
		observers = new ArrayList<>();
	}
	
	public SellDetailModel(int numRadio, Date date, double price) {
		this.numRadio = numRadio;
		this.date = date;
		this.price = price;
		
		/*
		this.user = user;
		this.radio = radio;
		*/
		
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

	/*
	@Override
	public IUserModel getUser() {
		return user;
	}

	@Override
	public IRadioModel getRadio() {
		return radio;
	}
	*/
	
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

}
