package view.contracts;

import controller.contracts.ISellDetailController;

public interface ISellDetailView {
	public void setController(ISellDetailController controller);
	public ISellDetailController getController();
}
