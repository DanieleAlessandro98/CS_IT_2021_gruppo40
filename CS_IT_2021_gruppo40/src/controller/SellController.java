package controller;

import model.ISellModel;
import view.SellView;

public class SellController {
	private ISellModel model;
	private SellView view;
	
	public SellController(ISellModel model, SellView view) {
		this.model = model;
		this.view = view;
	}
	
}
