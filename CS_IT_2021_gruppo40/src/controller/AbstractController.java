package controller;

import controller.contracts.IController;
import factory.FactoryObservable;

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
