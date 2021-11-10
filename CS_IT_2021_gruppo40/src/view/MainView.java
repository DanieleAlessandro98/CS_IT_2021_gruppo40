package view;

import java.awt.CardLayout;

import utility.Window;

public class MainView extends AbstractView {

	private CardLayout cardLayout = new CardLayout();
	private IView sellView;
	private IView userView;
	private IView radioView;
	
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
		userView = new UserView();
		radioView = new RadioView();
	}

	@Override
	public void addComponents() {
		this.add(sellView.getView(), Window.SELL.toString());
		this.add(userView.getView(), Window.USER.toString());
		this.add(radioView.getView(), Window.RADIO.toString());
	}

	@Override
	public void setPositionComponents() {
		cardLayout.show(this, Window.SELL.toString());	// Finestra all'apertura del software		
	}

}
