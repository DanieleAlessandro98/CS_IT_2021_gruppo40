package model.contracts;

import java.util.Date;

public interface ISellDetailModel extends IModel {
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
