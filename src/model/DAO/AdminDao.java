package model.DAO;
import model.PJO.*;

public interface AdminDao {

	boolean inserisciAdmin(Admin a);
	boolean eliminaAdmin(Admin a);
	boolean sospendiUtente(Studente s);
	boolean eliminaAnnuncioAdmin(Annuncio a);
}
