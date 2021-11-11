package test;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.MainController;
import view.IMainView;
import view.MainView;

public class Main {

	public static void main(String[] args) {
		IMainView mainView = new MainView();
		MainController mainController = new MainController(mainView);
		
		mainController.initControllers();
		
		JFrame test = new JFrame("Vendita Radio");
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.add(mainView.getView());
		test.setLocationRelativeTo(null);
		test.setPreferredSize(new Dimension(400, 650));
		test.pack();
		test.setVisible(true);
	}

}
