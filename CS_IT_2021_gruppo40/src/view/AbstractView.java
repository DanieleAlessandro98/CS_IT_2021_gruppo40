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
	
	/**
	 * Ritorna il componente grafico (uguale per tutte le view)
	 */
	@Override
	public JComponent getView() {
		return this;
	}
	
	/**
	 * Metodo astratto che si occuperà di inizializzare le proprietà del componente grafico
	 */
	@Override
	abstract public void initProperty();

	/**
	 * Metodo astratto che si occuperà di istanziare gli elementi grafici
	 */
	@Override
	abstract public void initComponents();

	/**
	 * Metodo astratto che si occuperà di aggiungere gli elementi grafici al componente padre
	 */
	@Override
	abstract public void addComponents();
	
	/**
	 * Metodo astratto che si occuperà di posizionare gli elementi grafici all'interno del componente padre
	 */
	@Override
	abstract public void setPositionComponents();

}
