package view;

import java.awt.CardLayout;

import javax.swing.JComponent;

import utility.Window;
import view.contracts.IMainView;
import view.contracts.IView;

/**
 * Classe concreta del package view
 * Si occupa di istanziare quelli che sono le viste principali del software (in questo caso solamente la parte di login, e la parte di vendita)
 * Inoltre una volta fatto ciò, svolge le operazioni principali per il binding dei vari componenti grafici (che verrà fatto a cascata)
 * Si occupa anche di aggiornare lo stato della finestra corrente (passando ad esempio dalla finestra di login, a quella di vendita)
 * @author Alex
 *
 */
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
	
	/**
	 * Metodo che si occupa di inizializzare le proprietà del componente grafico
	 */
	@Override
	public void initProperty() {
		this.setLayout(cardLayout);
	}

	/**
	 * Metodo che si occupa di istanziare gli elementi grafici
	 */
	@Override
	public void initComponents() {
		sellView = new SellView();
		loginView = new LoginView();
	}

	/**
	 * Metodo astratto che si occupa di aggiungere gli elementi grafici al componente padre
	 */
	@Override
	public void addComponents() {
		this.add(sellView.getView(), Window.SELL.toString());
		this.add(loginView.getView(), Window.LOGIN.toString());
	}

	/**
	 * Metodo astratto che si occupa di posizionare gli elementi grafici all'interno del componente padre
	 */
	@Override
	public void setPositionComponents() {
		cardLayout.show(this, Window.LOGIN.toString());	// Finestra all'apertura del software	
	}

	/**
	 * Metodo che restituisce la view della vendita
	 */
	@Override
	public JComponent getSellView() {
		return sellView.getView();
	}

	/**
	 * Metodo che restituisce la view del login
	 */
	@Override
	public JComponent getLoginView() {
		return loginView.getView();
	}

	/**
	 * Metodo che aggiorna la finestra a seguito del login
	 */
	@Override
	public void updateWindow(Window newWindow) {
		cardLayout.show(this, newWindow.toString());
	}

}
