package observer;

/**
 * Classe che si occupa di notificare a tutti gli osservatori interessati che il suo stato è cambiato
 * @author Alex
 *
 */
public interface ObservableUser {
	public void addObserver(ObserverUser observer);
	public void removeObserver(ObserverUser observer);
	public void notifyObservers();
}
