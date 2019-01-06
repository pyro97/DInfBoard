package model.DAO.implement;

import model.DAO.AdminDao;

import model.DAO.AnnuncioDao;
import model.DAO.StudenteDao;
import model.PJO.Annuncio;
import model.PJO.PasswordUtils;
import model.PJO.Studente;

public class ManagerAdmin {

	public static boolean inserisciAdmin(Studente a) {
		
			AdminDao dao = new AdminDao();
			a.setIsAdmin(true);
			if(dao.update(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
	}
	public static boolean eliminaAdmin(String a) {
		
		
			AdminDao dao = new AdminDao();
			if(dao.remove(a)) {
				dao.close();
				return true;
			}
			else 
				return false;
		
		
	}
	public static boolean sospendiUtente(String a) {
	
			AdminDao dao = new AdminDao();
			StudenteDao sdao=new StudenteDao();
			Studente s=sdao.get(a);
			if(s!=null) {
				s.setIsSospeso(true);
				if(sdao.update(s)) {
					sdao.close();
					return true;
				}
				else 
					return false;
			}else return false;
		
		
	}
	public static boolean eliminaAnnuncioAdmin(int id) {
		AnnuncioDao dao = new AnnuncioDao();
		if(dao.remove(id)) {
			dao.close();
			return true;
		}
		else 
			return false;
	}
	
	public static Studente getAdmin(String username) {
	
			AdminDao dao = new AdminDao();
			Studente s = dao.get(username);
			return s;

		
	}
}
