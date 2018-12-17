package model.DAO;
import model.PJO.*;

public interface ListaAnnunciDao {
	
	ListaAnnunci getBacheca();
	ListaAnnunci getAllAnnunci();
	Annuncio getAnnuncio(ListaAnnunci l);
	ListaAnnunci getAllAnnunciStudente(Studente s);
}
