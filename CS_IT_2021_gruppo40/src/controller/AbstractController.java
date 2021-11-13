package controller;

import observer.Observable;

public abstract class AbstractController implements IController {

	protected Observable observable;
	
	public AbstractController(Observable observable) {
		this.observable = observable;
	}
	
	@Override
	abstract public void bindView();
	
	@Override
	abstract public void bindObserver();
}
