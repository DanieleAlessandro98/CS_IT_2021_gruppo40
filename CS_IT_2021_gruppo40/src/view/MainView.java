package view;

import java.awt.CardLayout;

import javax.swing.JComponent;

import utility.Window;
import view.contracts.IMainView;
import view.contracts.IView;

public class MainView extends AbstractView implements IMainView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1797675056818333881L;
	/**
	 * 
	 */
	
	private CardLayout cardLayout = new CardLayout();
	private IView sellView;
	private IView loginView;
	
	public MainView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
	}
	
	@Override
	public void initProperty() {
		this.setLayout(cardLayout);
	}

	@Override
	public void initComponents() {
		sellView = new SellView();
		loginView = new LoginView();
	}

	@Override
	public void addComponents() {
		this.add(sellView.getView(), Window.SELL.toString());
		this.add(loginView.getView(), Window.LOGIN.toString());
	}

	@Override
	public void setPositionComponents() {
		cardLayout.show(this, Window.LOGIN.toString());	// Finestra all'apertura del software	
	}

	@Override
	public JComponent getSellView() {
		return sellView.getView();
	}

	@Override
	public JComponent getLoginView() {
		return loginView.getView();
	}

	@Override
	public void updateWindow(Window newWindow) {
		cardLayout.show(this, newWindow.toString());
	}

}
