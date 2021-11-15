package view.contracts;

import controller.contracts.IRadioController;
import model.contracts.IRadioModel;

/**
 * Interfaccia della view che si occupa della radio selezionata
 * @author Alex
 *
 */
public interface IRadioView {
	public void setController(IRadioController controller);
	public IRadioController getController();
	
	public void updateRadio(IRadioModel radio);
}
