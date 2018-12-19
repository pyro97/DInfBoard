package model.DAO.implement;

import model.PJO.Annuncio;
import model.PJO.Studente;

public class ManagerAnnuncio {

	boolean inserisciAnnuncio(Annuncio a) {
		return true;
	}
	boolean rimuoviAnnuncioPersistente(Annuncio a) {
		return true;
	}
	boolean annuncioNonVisibile(Annuncio a) {
		return true;
	}
	boolean modificaAnnuncio(Annuncio a) {
		return true;
	}
	boolean eliminaPartecipazione(Studente s,Annuncio a) {
		return true;
	}
}
