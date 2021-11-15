package model;

import exception.SellException;

public interface ISellModel extends IModel {
	public IUserModel getUser();
	public IRadioModel getRadio();
	public ISellDetailModel getSellDetail();
	
	public void insertSell() throws SellException;
	
	public void setUser(Object user);
	public void setRadio(Object radio);
	public void setSellDetail(Object sellDetail);
}
