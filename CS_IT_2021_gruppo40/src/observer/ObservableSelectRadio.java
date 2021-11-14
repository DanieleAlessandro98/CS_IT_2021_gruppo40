package observer;

public interface ObservableSelectRadio {
	public void addObserver(ObserverSelectRadio observer);
	public void removeObserver(ObserverSelectRadio observer);
	public void notifyObservers();
}
