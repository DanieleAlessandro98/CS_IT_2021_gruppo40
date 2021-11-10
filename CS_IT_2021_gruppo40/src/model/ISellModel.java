package model;

import java.util.Date;

public interface ISellModel {
	public int getNumRadio();
	public Date getDate();
	public double getPrice();
	public IUserModel getUser();
	public IRadioModel getRadio();
}
