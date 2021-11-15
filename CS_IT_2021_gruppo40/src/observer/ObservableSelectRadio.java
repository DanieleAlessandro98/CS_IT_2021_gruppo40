package observer;

/**
 * Classe che si occupa di notificare a tutti gli osservatori interessati che il suo stato è cambiato
 * @author Alex
 *
 */
public interface ObservableSelectRadio {
	public void addObserver(ObserverSelectRadio observer);
	public void removeObserver(ObserverSelectRadio observer);
	public void notifyObservers();
}
