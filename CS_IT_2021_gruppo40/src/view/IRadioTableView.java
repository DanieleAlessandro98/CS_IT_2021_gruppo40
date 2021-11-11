package view;

import controller.IRadioTableController;

public interface IRadioTableView {
	public void setController(IRadioTableController controller);
	public IRadioTableController getController();
}
