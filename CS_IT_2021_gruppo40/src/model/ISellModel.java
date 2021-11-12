package model;

public interface ISellModel {
	public IUserModel getUser();
	public IRadioModel getRadio();
	public ISellDetailModel getSellDetail();
	
	public void insertSell();
}
