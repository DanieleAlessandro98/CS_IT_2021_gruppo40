package controller;

import view.IMainView;
import view.ISellView;

public class MainController {
	
	private IMainView view;
	
	private SellController sellController;
	
	public MainController(IMainView view) {
		this.view = view;
	}
	
	public void initControllers() {
		sellController = new SellController((ISellView) view.getSellView());
		sellController.initControllers();
	}
	
}
