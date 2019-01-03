package model.DAO.implement;

import java.util.ArrayList;

import model.DAO.AdminDao;
import model.DAO.AnnuncioDao;
import model.DAO.StudenteDao;
import model.PJO.Annuncio;
import model.PJO.Studente;

public class ManagerAnnuncio {

	public static boolean inserisciAnnuncio(Annuncio a) {
	
			AnnuncioDao dao = new AnnuncioDao();
			a.setIsVisible(true);
			if(dao.add(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
	}
	public static boolean rimuoviAnnuncioPersistente(int id) {
		
			AnnuncioDao dao = new AnnuncioDao();
			if(dao.remove(id) ){
				dao.close();
				return true;
			}
			else 
				return false;
		
	}
	public static boolean annuncioNonVisibile(int id) {
		
			AnnuncioDao dao = new AnnuncioDao();
			Annuncio a= dao.get(id);
			if(a==null) {
				return false;
			}else {
				a.setIsVisible(false);
				if(dao.update(a)) {
					dao.close();
					return true;
				}
				else 
					return false;
			}
			
		
	}
	public static boolean modificaAnnuncio(Annuncio a) {
		
			AnnuncioDao dao = new AnnuncioDao();
			if(dao.update(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
		
	}
	public static boolean eliminaPartecipazione(Studente s,Annuncio a) {
		AnnuncioDao dao = new AnnuncioDao();
		StudenteDao sdao = new StudenteDao();
		
		ArrayList<Annuncio> ann=new ArrayList<>();
		for(Annuncio annuncio :ann) {
		/*	if(annuncio.getID()==s.getIDAnnuncio) ?????
				dao.remove(annuncio.getID());*/
		}
	
		return true;
	}
}
