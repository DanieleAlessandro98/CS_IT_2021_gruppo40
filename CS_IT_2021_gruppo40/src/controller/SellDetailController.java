package controller;

import java.util.Date;

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

	@Override
	public void bindObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNumRadioActionListener(int numRadio) {
		model.setNumRadio(numRadio);
	}

	@Override
	public void setDateActionListener(Date date) {
		model.setDate(date);
	}

	@Override
	public void setPriceActionListener(double price) {
		model.setPrice(price);
	}
	
}
