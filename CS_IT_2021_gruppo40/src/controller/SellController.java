package controller;

import model.ISellModel;
import model.SellModel;
import view.ISellView;
import view.IView;

public class SellController {
	
	private ISellModel model;
	private ISellView view;
	
	private UserController userController;
	private SellDetailController sellDetailController;
	private RadioController radioController;
	private RadioTableController radioTableController;
	
	public SellController(ISellView view) {
		this.model = new SellModel();
		this.view = view;
	}
	
	public void initControllers() {
		userController = new UserController((IView) view.getUserView());
		sellDetailController = new SellDetailController((IView) view.getSellDetailView());
		radioController = new RadioController((IView) view.getRadioView());
		radioTableController = new RadioTableController((IView) view.getRadioTableView());
	}

}
