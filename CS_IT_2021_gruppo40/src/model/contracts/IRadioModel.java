package model.contracts;

import model.Brand;
import model.Type;

/**
 * Interfaccia del model che si occupa della radio selezionata
 * @author Alex
 *
 */
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
