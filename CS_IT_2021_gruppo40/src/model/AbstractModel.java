package model;

import model.contracts.IModel;

/**
 * Classe astratta del model
 * Si occupa di mettere a fattor comune (per ogni model concreto) il metodo isValidData
 * Inoltre ogni controller avrà una sua differente implementazione di quest'ultimo per verificare, per ogni modello, se i dati sono corretti
 * @author Alex
 *
 */
public abstract class AbstractModel implements IModel {

	/**
	 * Metodo astratto che si occuperà di verificare se i dati presenti per ogni oggetto del model è valido
	 */
	@Override
	abstract public boolean isValidData();

}
