package factory;

import controller.LoginController;
import controller.SellController;
import controller.contracts.IController;
import view.contracts.ILoginView;
import view.contracts.IMainView;
import view.contracts.ISellView;

public class FactoryMain {

	public FactoryMain() {}
	
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
