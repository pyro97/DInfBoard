package model.DAO.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.DAO.StudenteDao;
import model.PJO.Studente;

public class StudenteDaoImplement implements StudenteDao {

	/**
	 * Questa classe non � altro che un Database Access Object con il quale gestiamo i dati persistenti nel database
	 * relativi agli studenti.
	 */
	
	private Connection connection;
	
	public StudenteDaoImplement() {
	
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
	
	public boolean registrazione(Studente s) {
		/**
		 * Il metodo provveder� alla registrazione di un nuovo studente sulla piattaforma.
		 * @pre Studente!=null;
		 * @pre Studente.getID!=null Studente.getNome!=null Studente.getCognome!=null Studente.getEmail!=null Studente.getUsername!=null
		 * @post Aggiunta in database una nuova tupla relativa allo studente s;
		 */
		
		String sql = "insert into Studenti(ID,Nome,Cognome,Email,Username,Password) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, s.getID());
			ps.setString(2, s.getNome());
			ps.setString(3, s.getCognome());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getUsername());
			ps.setString(6, s.getPassword());
			ps.executeQuery();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
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
