package view.contracts;

import controller.contracts.IRadioController;
import model.contracts.IRadioModel;

public interface IRadioView {
	public void setController(IRadioController controller);
	public IRadioController getController();
	
	public void updateRadio(IRadioModel radio);
}
