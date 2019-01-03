package model.DAO.implement;

import java.util.ArrayList;

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
	
	public static ArrayList<Annuncio> ottieniBacheca() {
		AnnuncioDao dao = new AnnuncioDao();
		ArrayList<Annuncio> bacheca = dao.getAll();
		dao.close();
		return bacheca;
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
		
		AnnuncioDao dao = new AnnuncioDao();
		boolean flag = dao.removePartecipazione(s, a);
		if(flag)
			return true;
		else
			return false;
	}
	public static boolean aggiungiPartecipazione(Studente s,Annuncio a) {
		
		AnnuncioDao dao = new AnnuncioDao();
		boolean flag = dao.addPartecipante(s, a);
		if(flag)
			return true;
		else
			return false;
	}
}
