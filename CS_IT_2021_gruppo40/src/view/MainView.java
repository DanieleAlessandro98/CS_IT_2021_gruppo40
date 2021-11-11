package view;

import java.awt.CardLayout;

import javax.swing.JComponent;

import utility.Window;

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
	}

	@Override
	public void addComponents() {
		this.add(sellView.getView(), Window.SELL.toString());
	}

	@Override
	public void setPositionComponents() {
		cardLayout.show(this, Window.SELL.toString());	// Finestra all'apertura del software	
	}

	@Override
	public JComponent getSellView() {
		return sellView.getView();
	}

}
