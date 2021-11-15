package observer;

/**
 * Classe che si occupa di notificare a tutti gli osservatori interessati che il suo stato è cambiato
 * @author Alex
 *
 */
public interface ObservableSellDetail {
	public void addObserver(ObserverSellDetail observer);
	public void removeObserver(ObserverSellDetail observer);
	public void notifyObservers();
}
