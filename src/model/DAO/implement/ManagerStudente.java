package model.DAO.implement;

import model.PJO.PasswordUtils;
import model.PJO.Studente;
import model.DAO.StudenteDao;

public class ManagerStudente {

	/*
	* Qui si usano i metodi della classe StudenteDao per fare il login, la registrazione etc..
	*/
	
	public static boolean registrazione(Studente s) {
		System.out.println(s.getEmail() + " "+ s.getUsername() + " " + s.getPreferenza() + " " + 
					s.getValutazione() + " ");
		if(s.getUsername()==null || s.getNome()==null || s.getEmail()==null || s.getCognome()==null || 
				s.getPassword()==null) {
			return false;
		}
		else {
			StudenteDao dao = new StudenteDao();
			if(dao.add(s)) {
				dao.close();
				return true;
			}
			else 
				return false;
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
