package view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import view.contracts.IView;

/**
 * Classe astratta della view
 * Si occupa di mettere a fattor comune (per ogni view concreta) i metodi per la gestione dei vari componenti grafici
 * Inoltre ogni view avrà una sua differente implementazione di questi ultimi
 * @author Alex
 *
 */
public abstract class AbstractView extends JPanel implements IView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7226115210622138460L;
	/**
	 * 
	 */
	
	public AbstractView() {}
	
	@Override
	public JComponent getView() {
		return this;
	}
	
	@Override
	abstract public void initProperty();

	@Override
	abstract public void initComponents();

	@Override
	abstract public void addComponents();
	
	@Override
	abstract public void setPositionComponents();

}
