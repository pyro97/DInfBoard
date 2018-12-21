package model.DAO.implement;

import model.PJO.PasswordUtils;
import model.PJO.Studente;
import model.DAO.StudenteDao;

public class ManagerStudente {

	/*
	* Qui si usano i metodi della classe StudenteDao per fare il login, la registrazione etc..
	*/
	
	public static boolean registrazione(Studente s) {
		if(s.getUsername()==null || s.getNome()==null || s.getEmail()==null || s.getCognome()==null || 
				s.getPassword()==null) {
			return false;
		}
		else {
			StudenteDao dao = new StudenteDao();
			dao.add(s);
			dao.close();
			return true;
		}
	}
	
	public static boolean login(Studente s) {
		return true;
	}
	public static boolean modificaProfilo(Studente s) {
		return true;
	}
	public static boolean eliminaProfilo(Studente s) {
		return true;
	}
	public static boolean valutazione(Studente s,int valutazione,int numeroAnnunciOrganizzati) {
		return true;
	}

}
