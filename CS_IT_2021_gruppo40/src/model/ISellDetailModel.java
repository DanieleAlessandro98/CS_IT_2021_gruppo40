package model;

import java.util.Date;

public interface ISellDetailModel {
	public int getNumRadio();
	public Date getDate();
	public double getPrice();
	
	/*
	public IUserModel getUser();
	public IRadioModel getRadio();
	*/
	
	public void setNumRadio(int numRadio);
	public void setDate(Date date);
	public void setPrice(double price);
}
