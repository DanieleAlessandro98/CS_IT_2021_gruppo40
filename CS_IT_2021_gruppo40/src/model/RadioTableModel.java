package model;

import java.util.ArrayList;
import java.util.List;

import observer.ObservableSelectRadio;
import observer.ObserverSelectRadio;

public class RadioTableModel extends AbstractModel implements IRadioTableModel, ObservableSelectRadio {
	
	private int selectedRadioID;
	
	private List<ObserverSelectRadio> observers;
	
	public RadioTableModel() {
		selectedRadioID = -1;
		observers = new ArrayList<>();
	}

	@Override
	public int getSelectedRadioID() {
		return selectedRadioID;
	}
	
	@Override
	public List<IRadioModel> initRadioTable() {
		return RadioManagment.getRadiosData();
	}

	@Override
	public void selectRadio(int radioID) {
		this.selectedRadioID = radioID;
		notifyObservers();
	}

	@Override
	public void addObserver(ObserverSelectRadio observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverSelectRadio observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverSelectRadio ob : observers)
			ob.update(getSelectedRadioID());
	}

	@Override
	public boolean isValidData() {
		if (getSelectedRadioID() == -1)
			return false;
		
		return true;
	}
	
}
