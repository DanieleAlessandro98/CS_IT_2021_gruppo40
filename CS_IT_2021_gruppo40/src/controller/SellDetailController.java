package controller;

import model.ISellDetailModel;
import view.IView;

public class SellDetailController {
	private ISellDetailModel model;
	private IView view;
	
	public SellDetailController(ISellDetailModel model, IView view) {
		this.model = model;
		this.view = view;
	}
	
}
