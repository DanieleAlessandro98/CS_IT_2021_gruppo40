package observer;

/**
 * Classe che si occupa di notificare a tutti gli osservatori interessati che il suo stato è cambiato
 * @author Alex
 *
 */
public interface ObservableLogin {
	public void addObserver(ObserverLogin observer);
	public void removeObserver(ObserverLogin observer);
	public void notifyObservers();
}
