package controller;

/**
 * Classe concreta del package Controller
 * Si occupa di creare e gestire la connessione tra i dati delle radio (all'interno del db) presenti nel model, e la visualizzazione di questi nella view
 * @author Alex
 *
 */
import controller.contracts.IRadioTableController;
import factory.FactoryObservable;
import model.contracts.IRadioTableModel;
import view.contracts.IRadioTableView;

public class RadioTableController extends AbstractController implements IRadioTableController {
	
	private IRadioTableModel model;
	private IRadioTableView view;
	
	public RadioTableController(FactoryObservable observable, IRadioTableView view) {
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
