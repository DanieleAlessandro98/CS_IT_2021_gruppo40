package controller.contracts;

import java.util.Date;

/**
 * Interfaccia del controller che si occupa dei dettagli della vendita
 * @author Alex
 *
 */
public interface ISellDetailController {
	public void setNumRadioActionListener(int numRadio);
	public void setDateActionListener(Date date);
	public void setPriceActionListener(double price);
}
