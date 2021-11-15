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

	/**
	 * Metodo che effettua il binding tra il controller corrente e la propria vista di interesse
	 */
	@Override
	public void bindView() {
		view.setController(this);
	}

	/**
	 * Metodo che effettua il binding tra il controller corrente e gli observer di interesse
	 */
	@Override
	public void bindObserver() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo che gestisce l'action lister dell'inserimento del dato "numero di radio vendute" a seguito dell'interazione con l'utente
	 * 
	 * @param numRadio Numero delle radio vendute
	 */
	@Override
	public void setNumRadioActionListener(int numRadio) {
		model.setNumRadio(numRadio);
	}

	/**
	 * Metodo che gestisce l'action lister dell'inserimento del dato "data di vendita" a seguito dell'interazione con l'utente
	 * 
	 * @param date Data della vendita
	 */
	@Override
	public void setDateActionListener(Date date) {
		model.setDate(date);
	}

	/**
	 * Metodo che gestisce l'action lister dell'inserimento del dato "prezzo di vendita" a seguito dell'interazione con l'utente
	 * 
	 * @param price Prezzo della vendita
	 */
	@Override
	public void setPriceActionListener(double price) {
		model.setPrice(price);
	}
	
}
