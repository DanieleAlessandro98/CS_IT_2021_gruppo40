package observer;

/**
 * Classe che si occupa di notificare a tutti gli osservatori interessati che il suo stato è cambiato
 * @author Alex
 *
 */
public interface ObservableRadio {
	public void addObserver(ObserverRadio observer);
	public void removeObserver(ObserverRadio observer);
	public void notifyObservers();
}
