package controller;

import java.util.ArrayList;
import java.util.List;

import factory.FactoryMain;
import factory.WindowsMain;
import observer.Observable;
import observer.ObserverLogin;
import utility.Window;
import view.IMainView;

public class MainController extends AbstractController implements ObserverLogin {
	
	private IMainView view;
	
	private List<IController> controllers;
	private FactoryMain factoryMain;
		
	public MainController(Observable observable, IMainView view) {
		super(observable);
		
		this.view = view;
		
		controllers = new ArrayList<>();
		factoryMain = new FactoryMain();
		
		initControllers();
	}
	
	private void initControllers() {
		for (WindowsMain window : WindowsMain.values())
			controllers.add(factoryMain.getController(observable, view, window));
	}

	@Override
	public void bindView() {
		for (IController controller : controllers)
			controller.bindView();
	}

	@Override
	public void bindObserver() {
		observable.addObserverLogin(this);
		
		for (IController controller : controllers)
			controller.bindObserver();
	}
	
	@Override
	public void update(int userID) {
		view.updateWindow(Window.SELL);
	}
	
}
