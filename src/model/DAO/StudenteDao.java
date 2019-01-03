package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.PJO.Admin;
import model.PJO.Annuncio;
import model.PJO.Studente;

public class StudenteDao implements GenericDao<Studente,String> {

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
	
	@Override
	public ArrayList<Studente> getAll() {
		String username = "";
		String password = "";
		String email= "";
		String nome= "";
		String cognome= "";
		boolean isAdmin = false;
		boolean isSospeso = false;
		int preferenza = 0;
		int valutazione = 0;
		ArrayList<Studente> studenti=new ArrayList<>();
		boolean valore=false;
		String sql = "Select * from Studenti where isAdmin = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(7,valore);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				username = rs.getString("Username");
				password = rs.getString("Password");
				email = rs.getString("Email");
				nome = rs.getString("Nome");
				cognome = rs.getString("Cognome");
				isAdmin = rs.getBoolean("isAdmin");
				isSospeso = rs.getBoolean("isSospeso");
				valutazione = rs.getInt("Valutazione");
				preferenza = rs.getInt("Preferenza");
				
				studenti.add(new Studente(nome,cognome,preferenza,email,username,password,isAdmin,isSospeso,valutazione));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return studenti;
	}

	@Override
	public Studente get(String id) {
		
		String username = "";
		String password = "";
		String email= "";
		String nome= "";
		String cognome= "";
		boolean isAdmin = false;
		boolean isSospeso = false;
		int preferenza = 0;
		int valutazione = 0;
		
		String sql = "Select * from Studenti where Username = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				username = rs.getString("Username");
				password = rs.getString("Password");
				email = rs.getString("Email");
				nome = rs.getString("Nome");
				cognome = rs.getString("Cognome");
				isAdmin = rs.getBoolean("isAdmin");
				isSospeso = rs.getBoolean("isSospeso");
				valutazione = rs.getInt("Valutazione");
				preferenza = rs.getInt("Preferenza");
				
			}
			return new Studente(nome,cognome,preferenza,email,username,password,isAdmin,isSospeso,valutazione);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean add(Studente s) {
		String sql = "Insert into Studenti(Username,Password,Valutazione,Nome,Cognome,Email,isAdmin,isSospeso,Preferenza)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, s.getUsername());
			ps.setString(2, s.getPassword());
			ps.setInt(3, s.getValutazione());
			ps.setString(4, s.getNome());
			ps.setString(5, s.getCognome());
			ps.setString(6,s.getEmail());
			ps.setBoolean(7, s.isIsAdmin());
			ps.setBoolean(8, s.isIsSospeso());
			ps.setInt(9, s.getPreferenza());
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean remove(String id) {
		int result=0;
		
		String sql = "delete * from Studenti where Username = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			if(result!=0)
				return true;
			else return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(Studente s) {
		String sql = "UPDATE Studenti SET nome=?, cognome=?, preferenza=?,"
				+ " email=?, username=?, password=?, isAdmin=?, isSospeso=?, valutazione=? WHERE Username=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, s.getNome());
			ps.setString(2, s.getCognome());
			ps.setInt(3, s.getPreferenza());

			ps.setString(4,s.getEmail());
			ps.setString(5, s.getUsername());
			ps.setString(6, s.getPassword());
			
			ps.setBoolean(7, s.isIsAdmin());
			ps.setBoolean(8, s.isIsSospeso());
			ps.setInt(9, s.getValutazione());

			ps.setString(10, s.getUsername());
			
			
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public ArrayList<Annuncio> getPartecipati(Studente s) {
		//????????
		return null;
	}
	
	public ArrayList<Annuncio> getOrganizzati(Studente s) {
		int id = 0;
		String titolo = "";
		String descrizione= "";
		String immagine= "";
		int partecipanti= 0;
		int id_organizzatore = 0;
		boolean isVisible = false;
		ArrayList<Annuncio> annunci=new ArrayList<>();
		
		String sql = "Select * from Annunci where ID_Organizzatore = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, s.getUsername());    //?????????
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("ID");
				titolo = rs.getString("Titolo");
				descrizione = rs.getString("Descrizione");
				immagine = rs.getString("Immagine");
				partecipanti = rs.getInt("Partecipanti");
				id_organizzatore = rs.getInt("ID_Organizzatore");
				isVisible = rs.getBoolean("isVisible");
				
				annunci.add(new Annuncio(id,titolo,descrizione,immagine,partecipanti,id_organizzatore,isVisible));

			}
			return annunci;

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
		
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
