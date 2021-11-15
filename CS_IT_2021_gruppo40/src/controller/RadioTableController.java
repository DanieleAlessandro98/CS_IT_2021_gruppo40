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
	 * Metodo che si occupa di gestire l'inizializzazione dei dati delle radio presenti nel database e visualizzarne i dati
	 */
	@Override
	public void initRadioTable() {
		view.initRadioTable(model.initRadioTable());
	}

	/**
	 * Metodo che si occupa di gestire la visualizzazione della tabella contenete la lista delle radio presenti
	 */
	@Override
	public void showRadioTableActionListener() {
		view.setTableVisibility(true);
	}

	/**
	 * Metodo che gestisce l'action lister della selezione della radio (il click del mouse sulla radio scelta) a seguito dell'interazione con l'utente
	 * 
	 * @param radioID ID della radio ottenuta a seguito della selezione della radio che si è venduta
	 */
	@Override
	public void selectRadioMouseListener(int radioID) {
		model.selectRadio(radioID);
		view.setTableVisibility(false);
	}
	
}
