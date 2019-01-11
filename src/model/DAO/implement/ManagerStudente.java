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
			String passwordCriptata = PasswordUtils.generateSecurePassword(s.getPassword());
			s.setPassword(passwordCriptata);
			StudenteDao dao = new StudenteDao();
			if(dao.add(s)) {
				dao.close();
				return true;
			}
			else 
				return false;
		}
	}
	
	public static Studente login(String username,String password) {
		
		StudenteDao dao = new StudenteDao();
		
		Studente s = dao.get(username);
		dao.close();
		if(s==null)
			return null;
		else {
			boolean check = PasswordUtils.verifyUserPassword(password, s.getPassword());
			if(check)
				return s;
			else
				return null;
		}
	}
	
	public static Studente getStudente(String username) {
		StudenteDao dao = new StudenteDao();
		Studente s = dao.get(username);
		return s;

	}
	
	public static boolean modificaProfilo(Studente s) {
		StudenteDao dao = new StudenteDao();
		if(dao.update(s))	return true;
		else	return false;
		
	}
	public static boolean eliminaProfilo(Studente s) {
		StudenteDao dao = new StudenteDao();
		if(dao.remove(s.getUsername()))	return true;
		else	return false;
	}
	public static boolean valutazione(Studente s,int valutazione,int numeroAnnunciOrganizzati) {
		s.setValutazione(valutazione);
		StudenteDao dao = new StudenteDao();
		if(dao.update(s))	return true;
		else	return false;
	}

}
