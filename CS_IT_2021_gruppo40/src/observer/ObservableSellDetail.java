package observer;

public interface ObservableSellDetail {
	public void addObserver(ObserverSellDetail observer);
	public void removeObserver(ObserverSellDetail observer);
	public void notifyObservers();
}
