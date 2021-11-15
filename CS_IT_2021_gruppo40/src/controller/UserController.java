package controller;

/**
 * Classe concreta del package Controller
 * Si occupa di creare e gestire la connessione tra i dati dell'utente presenti nel model, e la visualizzazione di questi nella view
 * @author Alex
 *
 */
import controller.contracts.IUserController;
import factory.FactoryObservable;
import model.contracts.IUserModel;
import observer.ObserverLogin;
import observer.ObserverSell;
import view.contracts.IUserView;

public class UserController extends AbstractController implements IUserController, ObserverLogin, ObserverSell {
	
	private IUserModel model;
	private IUserView view;
	
	public UserController(FactoryObservable observable, IUserView view) {
		super(observable);
		
		this.model = (IUserModel) observable.getObservableUser();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}

	@Override
	public void bindObserver() {
		observable.addObserverLogin(this);
		observable.addObserverSell(this);
	}

	@Override
	public void updateLogin(int userID) {
		model.setData(userID);
		view.updateUser(model);
	}

	@Override
	public void updateSell() {
		model.setDayCurrentSells();
		view.updateUser(model);
	}

}
