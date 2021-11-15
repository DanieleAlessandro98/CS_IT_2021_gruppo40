package observer;

/**
 * Classe che si occupa di notificare a tutti gli osservatori interessati che il suo stato è cambiato
 * @author Alex
 *
 */
public interface ObservableSell {
	public void addObserver(ObserverSell observer);
	public void removeObserver(ObserverSell observer);
	public void notifyObservers();
}
