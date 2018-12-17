package model.DAO.implement;

import model.DAO.AdminDao;
import model.PJO.Admin;
import model.PJO.Annuncio;
import model.PJO.Studente;

public class AdminDaoImplement implements AdminDao {

	public AdminDaoImplement() {
		
	}
	
	public boolean inserisciAdmin(Admin a) {
		
		return true;
	}
	
	public boolean eliminaAdmin(Admin a) {
		
		return true;
	}
	
	public boolean eliminaAnnuncioAdmin(Annuncio a) {
		
		return true;
	}
	
	public boolean sospendiUtente(Studente s) {
		
		return true;
	}
}
