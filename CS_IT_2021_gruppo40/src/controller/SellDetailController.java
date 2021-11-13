package controller;

import model.ISellDetailModel;
import model.SellDetailModel;
import observer.Observable;
import view.ISellDetailView;

public class SellDetailController extends AbstractController implements ISellDetailController {
	
	private ISellDetailModel model;
	private ISellDetailView view;
	
	public SellDetailController(Observable observable, ISellDetailView view) {
		super(observable);
		
		this.model = new SellDetailModel();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}
	
}
