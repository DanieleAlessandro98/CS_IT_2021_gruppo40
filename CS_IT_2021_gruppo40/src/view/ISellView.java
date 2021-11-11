package view;

import javax.swing.JComponent;

import controller.ISellController;

public interface ISellView {
	public JComponent getUserView();
	public JComponent getSellDetailView();
	public JComponent getRadioView();
	public JComponent getRadioTableView();
	
	public void setController(ISellController controller);
	public ISellController getController();
}
