package controller;

import view.ILoginView;
import view.IMainView;
import view.ISellView;

public class MainController extends AbstractController {
	
	private IMainView view;
	
	private IController sellController;
	private IController loginController;
	
	public MainController(IMainView view) {
		this.view = view;
		
		initControllers();
	}
	
	private void initControllers() {
		sellController = new SellController((ISellView) view.getSellView());
		loginController = new LoginController((ILoginView) view.getLoginView());
	}

	@Override
	public void bindView() {
		sellController.bindView();
		loginController.bindView();
	}
	
}
