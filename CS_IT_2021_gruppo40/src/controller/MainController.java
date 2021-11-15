package controller;

import java.util.ArrayList;
import java.util.List;

import controller.contracts.IController;
import factory.FactoryMain;
import factory.FactoryObservable;
import factory.WindowsMain;
import observer.ObserverLogin;
import utility.Window;
import view.contracts.IMainView;

/**
 * Classe concreta del package Controller
 * Si occupa di istanziare quelli che sono i controller principali del software (in questo caso solamente la parte di login, e la parte di vendita)
 * Inoltre una volta fatto ciò, svolge le operazioni principali per il binding dei vari controller (che verrà fatto a cascata)
 * Si occupa anche di aggiornare lo stato della finestra corrente (passando ad esempio dalla finestra di login, a quella di vendita)
 * @author Alex
 *
 */
public class MainController extends AbstractController implements ObserverLogin {
	
	private IMainView view;
	
	private List<IController> controllers;
	private FactoryMain factoryMain;
		
	public MainController(FactoryObservable observable, IMainView view) {
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
	public void updateLogin(int userID) {
		view.updateWindow(Window.SELL);
	}
	
}
