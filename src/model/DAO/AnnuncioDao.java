package model.DAO;
import model.PJO.*;

public interface AnnuncioDao {
	
	boolean inserisciAnnuncio(Annuncio a);
	boolean rimuoviAnnuncioPersistente(Annuncio a);
	boolean annuncioNonVisibile(Annuncio a);
	boolean modificaAnnuncio(Annuncio a);
	boolean eliminaPartecipazione(Studente s,Annuncio a);
}