package test;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.IController;
import controller.MainController;
import observer.Observable;
import view.IMainView;
import view.MainView;

public class Runnable {
	
	private Observable observable;
	private IMainView mainView;
	private IController mainController;
	
	public Runnable() {
		observable = new Observable();
		mainView = new MainView();
		mainController = new MainController(observable, mainView);
	}
	
	public void start() {
		mainController.bindView();
		mainController.bindObserver();
	}
	
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
