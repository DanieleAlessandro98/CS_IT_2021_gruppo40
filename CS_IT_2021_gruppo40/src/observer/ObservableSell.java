package observer;

public interface ObservableSell {
	public void addObserver(ObserverSell observer);
	public void removeObserver(ObserverSell observer);
	public void notifyObservers();
}
