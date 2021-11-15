package factory;

import controller.LoginController;
import controller.SellController;
import controller.contracts.IController;
import view.contracts.ILoginView;
import view.contracts.IMainView;
import view.contracts.ISellView;

/**
 * Classe che applica la definizione del pattern Factory per i controller del main
 * @author Alex
 *
 */
public class FactoryMain {

	public FactoryMain() {}
	
	/**
	 * Metodo che restituisce il corrispettivo controller inizializzato
	 * @param observable Istanza di FactoryObservable di AbstractController
	 * @param view Istanza di IMainView inizializzata allo startting point
	 * @param window Finestra del controller che si vuole inizializzare
	 * @return Controller inizializzato
	 */
	public IController getController(FactoryObservable observable, IMainView view, WindowsMain window) {
		IController result = null;
		
		switch (window) {
		case LOGIN:
			result = new LoginController(observable, (ILoginView) view.getLoginView());
			break;
			
		case SELL:
			result = new SellController(observable, (ISellView) view.getSellView());
			break;
		}
		
		return result;
		
	}
	
}
