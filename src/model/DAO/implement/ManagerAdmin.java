package model.DAO.implement;

import model.DAO.AdminDao;
import model.DAO.AnnuncioDao;
import model.DAO.StudenteDao;
import model.PJO.Admin;
import model.PJO.Annuncio;
import model.PJO.PasswordUtils;
import model.PJO.Studente;

public class ManagerAdmin {

	boolean inserisciAdmin(Studente a) {
		
			AdminDao dao = new AdminDao();
			if(dao.add(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
	}
	boolean eliminaAdmin(Studente a) {
		
		
			AdminDao dao = new AdminDao();
			if(dao.remove(a.getUsername())) {
				dao.close();
				return true;
			}
			else 
				return false;
		
		
	}
	boolean sospendiUtente(Studente a) {
	
			AdminDao dao = new AdminDao();
			a.setIsSospeso(true);
			if(dao.update(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
	}
	boolean eliminaAnnuncioAdmin(Annuncio a) {
		AnnuncioDao dao = new AnnuncioDao();
		if(dao.remove(a.getID())) {
			dao.close();
			return true;
		}
		else 
			return false;
	}
}
