package controller;

import model.ISellDetailModel;
import model.SellDetailModel;
import view.IView;

public class SellDetailController {
	
	private ISellDetailModel model;
	private IView view;
	
	public SellDetailController(IView view) {
		this.model = new SellDetailModel();
		this.view = view;
	}
	
}
