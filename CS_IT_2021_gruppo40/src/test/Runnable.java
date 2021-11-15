package test;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.MainController;
import controller.contracts.IController;
import factory.FactoryObservable;
import view.MainView;
import view.contracts.IMainView;

/**
 * Classe che si occupa di istanziare e mettere i moto ciò che sono i componenti di avvio del software
 * @author Alex
 *
 */
public class Runnable {
	
	private FactoryObservable observable;
	private IMainView mainView;
	private IController mainController;
	
	public Runnable() {
		observable = new FactoryObservable();
		mainView = new MainView();
		mainController = new MainController(observable, mainView);
	}
	
	/**
	 * Avvia il processo (che verrà fatto a catena) per l'associazione della view e degli observer
	 */
	public void start() {
		mainController.bindView();
		mainController.bindObserver();
	}
	
	/**
	 * Avvia il processo di visualizzazione di Swing
	 */
	public void startSwing() {
		JFrame frame = new JFrame("Vendita Radio");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainView.getView());
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(400, 650));
		frame.pack();
		frame.setVisible(true);
	}
	
}
