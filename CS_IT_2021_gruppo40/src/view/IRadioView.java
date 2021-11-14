package view;

import controller.IRadioController;
import model.IRadioModel;

public interface IRadioView {
	public void setController(IRadioController controller);
	public IRadioController getController();
	
	public void updateRadio(IRadioModel radio);
}
