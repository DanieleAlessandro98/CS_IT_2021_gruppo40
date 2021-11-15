package view.contracts;

import java.util.List;

import controller.contracts.IRadioTableController;
import model.contracts.IRadioModel;

public interface IRadioTableView {
	public void setController(IRadioTableController controller);
	public IRadioTableController getController();
	
	public void initRadioTable(List<IRadioModel> radios);
	public void setTableVisibility(boolean status);
}
