package controller;

/**
 * Classe concreta del package Controller
 * Si occupa di creare e gestire la connessione tra i dati della vendita presenti nel model, e la visualizzazione di questi nella view
 * @author Alex
 *
 */
import java.util.Date;

import controller.contracts.ISellDetailController;
import factory.FactoryObservable;
import model.contracts.ISellDetailModel;
import view.contracts.ISellDetailView;

public class SellDetailController extends AbstractController implements ISellDetailController {
	
	private ISellDetailModel model;
	private ISellDetailView view;
	
	public SellDetailController(FactoryObservable observable, ISellDetailView view) {
		super(observable);
		
		this.model = (ISellDetailModel) observable.getObservableSellDetail();
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
	public void setNumRadioActionListener(int numRadio) {
		model.setNumRadio(numRadio);
	}

	@Override
	public void setDateActionListener(Date date) {
		model.setDate(date);
	}

	@Override
	public void setPriceActionListener(double price) {
		model.setPrice(price);
	}
	
}
