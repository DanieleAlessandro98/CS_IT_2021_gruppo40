package model;

import java.util.ArrayList;
import java.util.List;

import database.services.RadioService;
import model.contracts.IRadioModel;
import observer.ObservableRadio;
import observer.ObserverRadio;

/**
 * Classe concreta del package Model
 * Si occupa anche di implementare la logica di business per quanto riguarda la radio selezionata
 * @author Alex
 *
 */
public class RadioModel extends AbstractModel implements IRadioModel, ObservableRadio {

	private int id;
	private Brand brand;
	private Type type;
	private int size;
	private String color;
	private String optional;
	private String antenna;
	
	private List<ObserverRadio> observers;
	
	public RadioModel() {
		observers = new ArrayList<>();
	}
	
	public RadioModel(int id, Brand brand, Type type, int size, String color, String optional, String antenna) {
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.color = color;
		this.optional = optional;
		this.antenna = antenna;
		
		// observers = new ArrayList<>();	// Commentato poichè questo costruttore viene utilizzato esclusivamente nel package database
											// Il quale non ha bisogno di istanziare gli observers
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public Brand getBrand() {
		return brand;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public String getOptional() {
		return optional;
	}

	@Override
	public String getAntenna() {
		return antenna;
	}

	@Override
	public void setData(int radioID) {
		IRadioModel tempRadio = RadioService.getData(radioID);
		
		this.id = tempRadio.getID();
		this.brand = tempRadio.getBrand();
		this.type = tempRadio.getType();
		this.size = tempRadio.getSize();
		this.color = tempRadio.getColor();
		this.optional = tempRadio.getOptional();
		this.antenna = tempRadio.getAntenna();
		
		notifyObservers();
	}

	@Override
	public void addObserver(ObserverRadio observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverRadio observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverRadio ob : observers) {
			ob.updateRadio(this);
		}
	}

	@Override
	public boolean isValidData() {
		if (brand == null)
			return false;
		
		if (type == null)
			return false;

		if (color == null || color == "")
			return false;

		if (optional == null || optional == "")
			return false;

		if (antenna == null || antenna == "")
			return false;

		return true;
	}

}
