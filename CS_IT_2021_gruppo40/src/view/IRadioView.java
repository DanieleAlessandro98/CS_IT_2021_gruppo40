package view;

import controller.IRadioController;

public interface IRadioView {
	public void setController(IRadioController controller);
	public IRadioController getController();
}
