package model.DAO.implement;

import model.DAO.AnnuncioDao;
import model.PJO.Annuncio;
import model.PJO.Studente;

public class AnnuncioDaoImplement implements AnnuncioDao {
	
	public AnnuncioDaoImplement() {
		
	}

	public boolean inserisciAnnuncio(Annuncio a) {
		
		return true;
	}
	
	public boolean rimuoviAnnuncioPersistente(Annuncio a) {
		
		return true;
	}
	
	public boolean annuncioNonVisibile(Annuncio a) {
		
		return true;
	}
	
	public boolean modificaAnnuncio(Annuncio a) {
		
		return true;
	}
	
	public boolean eliminaPartecipazione(Studente s,Annuncio a) {
		
		return true;
	}
}
