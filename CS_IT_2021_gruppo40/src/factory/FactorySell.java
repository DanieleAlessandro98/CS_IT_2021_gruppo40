package factory;

import controller.IController;
import controller.RadioController;
import controller.RadioTableController;
import controller.SellDetailController;
import controller.UserController;
import observer.Observable;
import view.IRadioTableView;
import view.IRadioView;
import view.ISellDetailView;
import view.ISellView;
import view.IUserView;

public class FactorySell {

	public FactorySell() {}
	
	public IController getController(Observable observable, ISellView view, WindowsSell window) {
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
