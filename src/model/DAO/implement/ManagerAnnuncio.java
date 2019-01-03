package model.DAO.implement;

import java.util.ArrayList;

import model.DAO.AdminDao;
import model.DAO.AnnuncioDao;
import model.DAO.StudenteDao;
import model.PJO.Annuncio;
import model.PJO.Studente;

public class ManagerAnnuncio {

	boolean inserisciAnnuncio(Annuncio a) {
	
			AnnuncioDao dao = new AnnuncioDao();
			a.setIsVisible(true);
			if(dao.add(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
	}
	boolean rimuoviAnnuncioPersistente(Annuncio a) {
		
			AnnuncioDao dao = new AnnuncioDao();
			if(dao.remove(a.getID())) {
				dao.close();
				return true;
			}
			else 
				return false;
		
	}
	boolean annuncioNonVisibile(Annuncio a) {
		
			AnnuncioDao dao = new AnnuncioDao();
			a.setIsVisible(false);
			if(dao.update(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
	}
	boolean modificaAnnuncio(Annuncio a) {
		
			AnnuncioDao dao = new AnnuncioDao();
			if(dao.update(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
		
	}
	boolean eliminaPartecipazione(Studente s,Annuncio a) {
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
