package model.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.PJO.Admin;
import model.PJO.Annuncio;
import model.PJO.Studente;

public class StudenteDao implements GenericDao<Studente> {

	private Connection connection;
	
	public StudenteDao() {
		
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			
			DataSource ds = (DataSource) ctx.lookup("jdbc/dinfboard");
			connection = ds.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Admin> getAllAdmin() {
		return null;
	}
	
	@Override
	public ArrayList<Studente> getAll() {
		return null;
	}

	@Override
	public Studente get(int id) {
		return null;
	}

	@Override
	public boolean add(Studente s) {
		return false;
	}
	
	public ArrayList<Annuncio> getPartecipati(Studente s) {
		return null;
	}
	
	public ArrayList<Annuncio> getOrganizzati(Studente s) {
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
