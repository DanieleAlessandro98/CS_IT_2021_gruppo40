package controller;

import view.IMainView;
import view.ISellView;

public class MainController extends AbstractController {
	
	private IMainView view;
	
	private IController sellController;
	
	public MainController(IMainView view) {
		this.view = view;
		
		initControllers();
	}
	
	private void initControllers() {
		sellController = new SellController((ISellView) view.getSellView());
	}

	@Override
	public void bindView() {
		sellController.bindView();
	}
	
}
