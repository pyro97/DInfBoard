package model.DAO;

import java.sql.Connection;

import java.util.ArrayList;
import model.PJO.Preferenza;


public class PreferezaDao implements GenericDao<Preferenza,Integer> {

	private Connection connection;
	
	@Override
	public ArrayList<Preferenza> getAll() {
		return null;
	}

	@Override
	public Preferenza get(Integer id) {
		return null;
	}

	@Override
	public boolean add(Preferenza p) {
		return false;
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
