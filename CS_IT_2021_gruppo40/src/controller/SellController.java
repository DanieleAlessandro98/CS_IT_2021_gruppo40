package controller;

import model.ISellModel;
import view.IView;

public class SellController {
	private ISellModel model;
	private IView view;
	
	public SellController(ISellModel model, IView view) {
		this.model = model;
		this.view = view;
	}
}
