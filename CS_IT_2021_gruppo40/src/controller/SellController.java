package controller;

import model.ISellModel;
import model.SellModel;
import view.IRadioTableView;
import view.IRadioView;
import view.ISellDetailView;
import view.ISellView;
import view.IUserView;

public class SellController extends AbstractController implements ISellController {
	
	private ISellModel model;
	private ISellView view;
	
	private IController userController;
	private IController sellDetailController;
	private IController radioController;
	private IController radioTableController;
	
	public SellController(ISellView view) {
		this.model = new SellModel();
		this.view = view;
		
		initControllers();
	}
	
	private void initControllers() {
		userController = new UserController((IUserView) view.getUserView());
		sellDetailController = new SellDetailController((ISellDetailView) view.getSellDetailView());
		radioController = new RadioController((IRadioView) view.getRadioView());
		radioTableController = new RadioTableController((IRadioTableView) view.getRadioTableView());
	}

	@Override
	public void bindView() {
		view.setController(this);
		
		userController.bindView();
		sellDetailController.bindView();
		radioController.bindView();
		radioTableController.bindView();
	}

	@Override
	public void insertSellActionListener() {
		model.insertSell();
	}

}
