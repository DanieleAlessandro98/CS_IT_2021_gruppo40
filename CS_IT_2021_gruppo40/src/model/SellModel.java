package model;

import java.util.Date;

public class SellModel implements ISellModel {

	private int numRadio;
	private Date date;
	private double price;
	private IUserModel user;
	private IRadioModel radio;
		
	public SellModel(int numRadio, Date date, double price, IUserModel user, IRadioModel radio) {
		this.numRadio = numRadio;
		this.date = date;
		this.price = price;
		this.user = user;
		this.radio = radio;
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
	public IUserModel getUser() {
		return user;
	}

	@Override
	public IRadioModel getRadio() {
		return radio;
	}

}
