package view;

import java.util.List;

import controller.IRadioTableController;
import model.IRadioModel;

public interface IRadioTableView {
	public void setController(IRadioTableController controller);
	public IRadioTableController getController();
	
	public void initRadioTable(List<IRadioModel> radios);
	public void setTableVisibility(boolean status);
}
