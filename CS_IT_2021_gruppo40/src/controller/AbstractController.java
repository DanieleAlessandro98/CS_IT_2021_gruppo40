package controller;

import controller.contracts.IController;
import factory.FactoryObservable;

/**
 * Classe astratta del controller
 * Si occupa di mettere a fattor comune (per ogni controller concreto) l'oggetto FactoryObservable
 * Inoltre ogni controller avrà una sua differente implementazione dei metodi di collegamento della view e degli observer
 * @author Alex
 *
 */
public abstract class AbstractController implements IController {

	protected FactoryObservable observable;
	
	public AbstractController(FactoryObservable observable) {
		this.observable = observable;
	}
	
	@Override
	abstract public void bindView();
	
	@Override
	abstract public void bindObserver();
}
