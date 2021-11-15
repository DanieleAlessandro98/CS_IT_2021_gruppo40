package factory;

import controller.IController;
import controller.LoginController;
import controller.SellController;
import observer.Observable;
import view.ILoginView;
import view.IMainView;
import view.ISellView;

public class FactoryMain {

	public FactoryMain() {}
	
	public IController getController(Observable observable, IMainView view, WindowsMain window) {
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
