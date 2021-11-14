package controller;

import model.IRadioTableModel;
import observer.Observable;
import view.IRadioTableView;

public class RadioTableController extends AbstractController implements IRadioTableController {
	
	private IRadioTableModel model;
	private IRadioTableView view;
	
	public RadioTableController(Observable observable, IRadioTableView view) {
		super(observable);
		
		this.model = (IRadioTableModel) observable.getObservableSelectRadio();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}

	@Override
	public void bindObserver() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void initRadioTable() {
		view.initRadioTable(model.initRadioTable());
	}

	@Override
	public void showRadioTableActionListener() {
		view.setTableVisibility(true);
	}

	@Override
	public void selectRadioMouseListener(int radioID) {
		model.selectRadio(radioID);
		view.setTableVisibility(false);
	}
	
}
