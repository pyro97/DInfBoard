package model.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
		String preferenza = "";
		int valutazione = 0;
		ArrayList<Studente> studenti=new ArrayList<Studente>();
		String sql = "select * from Studenti join Preferenze on Preferenza=ID_Preferenza";
		try {
			
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				username = rs.getString("Username");
				password = rs.getString("Password");
				email = rs.getString("Email");
				nome = rs.getString("Nome");
				cognome = rs.getString("Cognome");
				isAdmin = rs.getBoolean("isAdmin");
				isSospeso = rs.getBoolean("isSospeso");
				valutazione = rs.getInt("Valutazione");
				preferenza = rs.getString("Nome_Preferenza");
				
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
		String preferenza = "";
		int valutazione = 0;
		
		String sql = "select * from Studenti join Preferenze on Preferenza=ID_Preferenza where Username=?";
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
				preferenza = rs.getString("Nome_Preferenza");
				
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
		
		String getPreferenza = "select * from Preferenze where Nome_Preferenza=?";
		String sql = "Insert into Studenti(Username,Password,Valutazione,Nome,Cognome,Email,isAdmin,isSospeso,Preferenza)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			
			int preferenza = 0;
			PreparedStatement psPref = connection.prepareStatement(getPreferenza);
			psPref.setString(1, s.getPreferenza());
			ResultSet rsPref = psPref.executeQuery();
			while(rsPref.next()) {
				preferenza = rsPref.getInt("ID_Preferenza");
			}
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, s.getUsername());
			ps.setString(2, s.getPassword());
			ps.setInt(3, s.getValutazione());
			ps.setString(4, s.getNome());
			ps.setString(5, s.getCognome());
			ps.setString(6,s.getEmail());
			ps.setBoolean(7, s.isIsAdmin());
			ps.setBoolean(8, s.isIsSospeso());
			ps.setInt(9,preferenza);
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean remove(String username) {
		int result=0;
		
		String sql = "delete from Studenti where Username = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
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
		
		String getPreferenza = "select * from Preferenze where Nome_Preferenza=?";
		String sql = "UPDATE Studenti SET nome=?, cognome=?, preferenza=?,"
				+ " email=?, username=?, password=?, isAdmin=?, isSospeso=?, valutazione=? WHERE Username=?";
		try {
			
			int preferenza = 0;
			PreparedStatement psPref = connection.prepareStatement(getPreferenza);
			psPref.setString(1, s.getPreferenza());
			ResultSet rsPref = psPref.executeQuery();
			while(rsPref.next()) {
				preferenza = rsPref.getInt("ID_Preferenza");
			}
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, s.getNome());
			ps.setString(2, s.getCognome());
			ps.setInt(3, preferenza);

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
		
		ArrayList<Annuncio> elenco = new ArrayList<Annuncio>();
		String sql = "select * from (Studenti join Partecipazione on Username_Studente=Username) "
				+ "join Annunci on ID_Annuncio=ID where Username=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,s.getUsername());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String username = rs.getString(s.getUsername());
				int ID = rs.getInt("ID");
				String titolo = rs.getString("Titolo");
				String descrizione = rs.getString("Descrizione");
				String path = rs.getString("Immagine");
				int partecipanti = rs.getInt("Partecipanti");
				String preferenza = rs.getString("Nome_Preferenza");
				boolean isVisible = rs.getBoolean("isVisible");
				Annuncio a = new Annuncio(ID,titolo,descrizione,path,partecipanti,username,isVisible,preferenza);
				elenco.add(a);
			}
			return elenco;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Annuncio> getOrganizzati(Studente s) {
		
		ArrayList<Annuncio> elenco = new ArrayList<Annuncio>();
		String sql = "select * from (Studenti join Organizzazione on Username_Studente=Username) "
				+ "join Annunci on ID_Annuncio=ID where Username=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,s.getUsername());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String username = rs.getString(s.getUsername());
				int ID = rs.getInt("ID");
				String titolo = rs.getString("Titolo");
				String descrizione = rs.getString("Descrizione");
				String path = rs.getString("Immagine");
				int partecipanti = rs.getInt("Partecipanti");
				String preferenza = rs.getString("Nome_Preferenza");
				boolean isVisible = rs.getBoolean("isVisible");
				Annuncio a = new Annuncio(ID,titolo,descrizione,path,partecipanti,username,isVisible,preferenza);
				elenco.add(a);
			}
			return elenco;
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
