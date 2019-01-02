package model.DAO.implement;

import model.DAO.AnnuncioDao;
import model.PJO.Annuncio;
import model.PJO.Studente;

public class ManagerAnnuncio {

	public static boolean inserisciAnnuncio(Annuncio a) {
		AnnuncioDao dao = new AnnuncioDao();
		boolean flag = dao.add(a);
		dao.close();
		if(flag)
			return true;
		else
			return false;
	}
	public static boolean rimuoviAnnuncioPersistente(Annuncio a) {
		return true;
	}
	public static boolean annuncioNonVisibile(Annuncio a) {
		return true;
	}
	public static boolean modificaAnnuncio(Annuncio a) {
		return true;
	}
	public static boolean eliminaPartecipazione(Studente s,Annuncio a) {
		return true;
	}
}
