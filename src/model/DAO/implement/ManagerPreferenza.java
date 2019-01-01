package model.DAO.implement;

import java.util.ArrayList;
import model.PJO.Preferenza;
import model.DAO.*;

public class ManagerPreferenza {

	public static ArrayList<Preferenza> getElencoPreferenze() {
		PreferenzaDao dao = new PreferenzaDao();
		ArrayList<Preferenza> elenco = dao.getAll();
		dao.close();
		return elenco;
	}
}
