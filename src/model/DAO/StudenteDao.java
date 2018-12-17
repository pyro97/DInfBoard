package model.DAO;
import model.PJO.Studente;

public interface StudenteDao {
	
	boolean registrazione(Studente s);
	boolean login(Studente s);
	boolean modificaProfilo(Studente s);
	boolean eliminaProfilo(Studente s);
	boolean valutazione(Studente s,int valutazione,int numeroAnnunciOrganizzati);
}
