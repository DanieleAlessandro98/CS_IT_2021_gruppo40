package model.contracts;

import java.util.Date;

/**
 * Interfaccia del model che si occupa dei dettagli della vendita
 * @author Alex
 *
 */
public interface ISellDetailModel extends IModel {
	public int getNumRadio();
	public Date getDate();
	public double getPrice();
	
	public void setNumRadio(int numRadio);
	public void setDate(Date date);
	public void setPrice(double price);
}
