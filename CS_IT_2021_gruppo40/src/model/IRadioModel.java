package model;

public interface IRadioModel extends IModel {
	public int getID();
	public Brand getBrand();
	public Type getType();
	public int getSize();
	public String getColor();
	public String getOptional();
	public String getAntenna();
	
	public void setData(int radioID);
}
