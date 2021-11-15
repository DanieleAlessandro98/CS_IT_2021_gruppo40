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

public class FactorySell {

	public FactorySell() {}
	
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
