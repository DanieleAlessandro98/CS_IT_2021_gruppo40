package observer;

public interface ObservableLogin {
	public void addObserver(ObserverLogin observer);
	public void removeObserver(ObserverLogin observer);
	public void notifyObservers();
}
