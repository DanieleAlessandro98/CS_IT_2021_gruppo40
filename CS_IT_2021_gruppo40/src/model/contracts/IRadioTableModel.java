package model.contracts;

import java.util.List;

/**
 * Interfaccia del model che si occupa della lista delle radio presenti e della scelta su una di esse
 * @author Alex
 *
 */
public interface IRadioTableModel extends IModel {
	public int getSelectedRadioID();
	
	public List<IRadioModel> initRadioTable();
	public void selectRadio(int radioID);
}
