package model.DAO.implement;

import model.PJO.Studente;

public class StudenteDaoImplement {

	/**
	 * Questa classe non � altro che un Database Access Object con il quale gestiamo i dati persistenti nel database
	 * relativi agli studenti.
	 */
	public StudenteDaoImplement() {
		/**
		 * Il costruttore effettua la connessione al database. La classe StudenteDao ci permetterà di effettuare
		 * tutte le operazioni sui dati persistenti relative alle istanze di Studenti.
		 */
	}
	
	public boolean registrazione(Studente s) {
		/**
		 * Il metodo provveder� alla registrazione di un nuovo studente sulla piattaforma.
		 * @pre Studente!=null;
		 * @pre Studente.getID!=null Studente.getNome!=null Studente.getCognome!=null Studente.getEmail!=null Studente.getUsername!=null
		 * @post Aggiunta in database una nuova tupla relativa allo studente s;
		 */
		return true;
	}
	
	public boolean login(Studente s) {
		
		return true;
	}
	
	public boolean modificaProfilo(Studente s) {
		
		return true;
	}
	
	public boolean eliminaProfilo(Studente s) {
		
		return true;
	}
	
	public boolean valutazione(Studente s,int valutazione,int numeroAnnunciOrganizzati) {
		
		return true;
	}
	
}
