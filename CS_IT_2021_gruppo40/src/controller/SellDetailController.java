package controller;

import model.ISellDetailModel;
import model.SellDetailModel;
import view.ISellDetailView;

public class SellDetailController extends AbstractController implements ISellDetailController {
	
	private ISellDetailModel model;
	private ISellDetailView view;
	
	public SellDetailController(ISellDetailView view) {
		this.model = new SellDetailModel();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}
	
}
