package factory;

import controller.RadioController;
import controller.RadioTableController;
import controller.SellDetailController;
import controller.UserController;
import controller.contracts.IController;
import view.contracts.IRadioTableView;
import view.contracts.IRadioView;
import view.contracts.ISellDetailView;
import view.contracts.ISellView;
import view.contracts.IUserView;

/**
 * Classe che applica la definizione del pattern Factory per i controller del sell
 * @author Alex
 *
 */
public class FactorySell {

	public FactorySell() {}
	
	/**
	 * Metodo che restituisce il corrispettivo controller inizializzato
	 * @param observable Istanza di FactoryObservable di AbstractController
	 * @param view Istanza di ISellView inizializzata all'avvio del software
	 * @param window Finestra del controller che si vuole inizializzare
	 * @return Controller inizializzato
	 */
	public IController getController(FactoryObservable observable, ISellView view, WindowsSell window) {
		IController result = null;
		
		switch (window) {
		case USER:
			result = new UserController(observable, (IUserView) view.getUserView());
			break;
			
		case SELL_DETAIL:
			result = new SellDetailController(observable, (ISellDetailView) view.getSellDetailView());
			break;
			
		case RADIO:
			result = new RadioController(observable, (IRadioView) view.getRadioView());
			break;
			
		case RADIO_TABLE:
			result = new RadioTableController(observable, (IRadioTableView) view.getRadioTableView());
			break;
		}
		
		return result;
	}
	
}
