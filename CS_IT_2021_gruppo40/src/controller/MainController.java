package controller;

import observer.Observable;
import view.ILoginView;
import view.IMainView;
import view.ISellView;

public class MainController extends AbstractController {
	
	private IMainView view;
	
	private IController sellController;
	private IController loginController;
	
	public MainController(Observable observable, IMainView view) {
		super(observable);
		
		this.view = view;
		
		initControllers();
	}
	
	private void initControllers() {
		sellController = new SellController(observable, (ISellView) view.getSellView());
		loginController = new LoginController(observable, (ILoginView) view.getLoginView());
	}

	@Override
	public void bindView() {
		sellController.bindView();
		loginController.bindView();
	}
	
}
