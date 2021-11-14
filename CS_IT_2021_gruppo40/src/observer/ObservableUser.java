package observer;

public interface ObservableUser {
	public void addObserver(ObserverUser observer);
	public void removeObserver(ObserverUser observer);
	public void notifyObservers();
}
