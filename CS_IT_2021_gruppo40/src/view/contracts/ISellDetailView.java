package view.contracts;

import controller.contracts.ISellDetailController;

/**
 * Interfaccia della view che si occupa dei dettagli della vendita
 * @author Alex
 *
 */
public interface ISellDetailView {
	public void setController(ISellDetailController controller);
	public ISellDetailController getController();
}
