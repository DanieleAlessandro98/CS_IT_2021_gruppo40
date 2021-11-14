package observer;

public interface ObservableRadio {
	public void addObserver(ObserverRadio observer);
	public void removeObserver(ObserverRadio observer);
	public void notifyObservers();
}
