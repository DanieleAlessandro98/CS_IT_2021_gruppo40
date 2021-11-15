package factory;

import model.LoginModel;
import model.RadioModel;
import model.RadioTableModel;
import model.SellDetailModel;
import model.SellModel;
import model.UserModel;
import observer.ObservableLogin;
import observer.ObservableRadio;
import observer.ObservableSelectRadio;
import observer.ObservableSell;
import observer.ObservableSellDetail;
import observer.ObservableUser;
import observer.ObserverLogin;
import observer.ObserverRadio;
import observer.ObserverSelectRadio;
import observer.ObserverSell;
import observer.ObserverSellDetail;
import observer.ObserverUser;

/**
 * Classe che applica la definizione del pattern Factory per le classi Observable
 * @author Alex
 *
 */
public class FactoryObservable {

	private ObservableLogin observableLogin;
	private ObservableSelectRadio observableSelectRadio;
	private ObservableUser observableUser;
	private ObservableRadio observableRadio;
	private ObservableSellDetail observableSellDetail;
	private ObservableSell observableSell;
	
	public FactoryObservable() {
		observableLogin = new LoginModel();
		observableSelectRadio = new RadioTableModel();
		observableUser = new UserModel();
		observableRadio = new RadioModel();
		observableSellDetail = new SellDetailModel();
		observableSell = new SellModel();
	}
	
	/**
	 * Aggiunge un'observer (osservatore) alla lista che osserva l'obseravble (l'osservato)
	 * @param observer Nuovo osservatore da aggiungere
	 */
	public void addObserverLogin(ObserverLogin observer) {
		observableLogin.addObserver(observer);
	}
	
	/**
	 * Aggiunge un'observer (osservatore) alla lista che osserva l'obseravble (l'osservato)
	 * @param observer Nuovo osservatore da aggiungere
	 */
	public void addObserverSelectRadio(ObserverSelectRadio observer) {
		observableSelectRadio.addObserver(observer);
	}
	
	/**
	 * Aggiunge un'observer (osservatore) alla lista che osserva l'obseravble (l'osservato)
	 * @param observer Nuovo osservatore da aggiungere
	 */
	public void addObserverUser(ObserverUser observer) {
		observableUser.addObserver(observer);
	}
	
	/**
	 * Aggiunge un'observer (osservatore) alla lista che osserva l'obseravble (l'osservato)
	 * @param observer Nuovo osservatore da aggiungere
	 */
	public void addObserverRadio(ObserverRadio observer) {
		observableRadio.addObserver(observer);
	}
	
	/**
	 * Aggiunge un'observer (osservatore) alla lista che osserva l'obseravble (l'osservato)
	 * @param observer Nuovo osservatore da aggiungere
	 */
	public void addObserverSellDetail(ObserverSellDetail observer) {
		observableSellDetail.addObserver(observer);
	}
	
	/**
	 * Aggiunge un'observer (osservatore) alla lista che osserva l'obseravble (l'osservato)
	 * @param observer Nuovo osservatore da aggiungere
	 */
	public void addObserverSell(ObserverSell observer) {
		observableSell.addObserver(observer);
	}
	
	/**
	 * Metodo che ritorna l'istanza dell'osservato (utile per evitare duplicazioni di quest'ultimo nel controller) 
	 * @return Istanza dell'observable
	 */
	public ObservableLogin getObservableLogin() {
		return observableLogin;
	}
	
	/**
	 * Metodo che ritorna l'istanza dell'osservato (utile per evitare duplicazioni di quest'ultimo nel controller) 
	 * @return Istanza dell'observable
	 */
	public ObservableSelectRadio getObservableSelectRadio() {
		return observableSelectRadio;
	}
	
	/**
	 * Metodo che ritorna l'istanza dell'osservato (utile per evitare duplicazioni di quest'ultimo nel controller) 
	 * @return Istanza dell'observable
	 */
	public ObservableUser getObservableUser() {
		return observableUser;
	}
	
	/**
	 * Metodo che ritorna l'istanza dell'osservato (utile per evitare duplicazioni di quest'ultimo nel controller) 
	 * @return Istanza dell'observable
	 */
	public ObservableRadio getObservableRadio() {
		return observableRadio;
	}
	
	/**
	 * Metodo che ritorna l'istanza dell'osservato (utile per evitare duplicazioni di quest'ultimo nel controller) 
	 * @return Istanza dell'observable
	 */
	public ObservableSellDetail getObservableSellDetail() {
		return observableSellDetail;
	}
	
	/**
	 * Metodo che ritorna l'istanza dell'osservato (utile per evitare duplicazioni di quest'ultimo nel controller) 
	 * @return Istanza dell'observable
	 */
	public ObservableSell getObservableSell() {
		return observableSell;
	}
	
}
