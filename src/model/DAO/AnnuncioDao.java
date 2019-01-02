package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.PJO.Annuncio;
import model.PJO.Studente;

public class AnnuncioDao implements GenericDao<Annuncio,Integer> {

	private Connection connection;
	
	public AnnuncioDao() {
		
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
	
	@Override
	public boolean add(Annuncio a) {
		String sql_Preferenza = "select * from Preferenze where Nome_Preferenza=?";
		String sql = "Insert into Annunci(Titolo,Descrizione,Immagine,Partecipanti,Preferenza) values(?,?,?,?,?)";
		try {
			PreparedStatement psPreferenza = connection.prepareStatement(sql_Preferenza);
			psPreferenza.setString(1, a.getPreferenza());
			ResultSet rs = psPreferenza.executeQuery();
			int id = 0;
			while(rs.next())
				id = rs.getInt("ID_Preferenza");
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, a.getTitolo());
			ps.setString(2, a.getDescrizione());
			ps.setString(3, a.getPathImmagine());
			ps.setInt(4, a.getPartecipanti());
			ps.setInt(5, id);
			ps.executeQuery();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Annuncio> getAll() {
		return null;
	}

	@Override
	public Annuncio get(Integer id) {
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
