package model.contracts;

import exception.SellException;

/**
 * Interfaccia del model che si occupa della parte di vendita
 * @author Alex
 *
 */
public interface ISellModel extends IModel {
	public IUserModel getUser();
	public IRadioModel getRadio();
	public ISellDetailModel getSellDetail();
	
	public void insertSell() throws SellException;
	
	public void setUser(Object user);
	public void setRadio(Object radio);
	public void setSellDetail(Object sellDetail);
}
