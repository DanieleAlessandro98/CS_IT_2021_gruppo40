package controller;

import model.IRadioTableModel;
import model.RadioTableModel;
import view.IRadioTableView;

public class RadioTableController extends AbstractController implements IRadioTableController {
	
	private IRadioTableModel model;
	private IRadioTableView view;
	
	public RadioTableController(IRadioTableView view) {
		this.model = new RadioTableModel();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}

	@Override
	public void selectRadioActionListener() {
		System.out.println("qq2");
	}
	
}
