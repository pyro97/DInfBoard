package model.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import model.PJO.Annuncio;
import model.PJO.Studente;

public class AnnuncioDao implements GenericDao<Annuncio> {

	private Connection connection;
	
	public AnnuncioDao() {
		
	}
	
	@Override
	public boolean add(Annuncio a) {
		return false;
	}

	@Override
	public ArrayList<Annuncio> getAll() {
		return null;
	}

	@Override
	public Annuncio get(int id) {
		return null;
	}
	
	public ArrayList<Studente> getPartecipanti(Annuncio a) {
		return null;
	}
	
	public ArrayList<Studente> getOrganizzatore(Annuncio a) {
		return null;
	}

	@Override
	public boolean close() {
		try {
			connection.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
