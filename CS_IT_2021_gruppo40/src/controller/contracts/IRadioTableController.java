package controller.contracts;

/**
 * Interfaccia del controller che si occupa della lista delle radio presenti e della scelta su una di esse
 * @author Alex
 *
 */
public interface IRadioTableController {
	public void initRadioTable();
	public void showRadioTableActionListener();
	public void selectRadioMouseListener(int radioID);
}
