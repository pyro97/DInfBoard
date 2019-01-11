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
		
		String sql_Preferenze = "Select * from Preferenze where Nome_Preferenza=?";
		String sql_Annunci = "Insert into Annunci values(?,?,?,?,?,?,?)";
		String sql_Organizzazione = "Insert into Organizzazione values(?,?)";
		
		try {
			
			PreparedStatement psPreferenza = connection.prepareStatement(sql_Preferenze);
			psPreferenza.setString(1, a.getPreferenza());
			ResultSet rs = psPreferenza.executeQuery();
			int ID_Preferenza = -1;
			while(rs.next()) {
				ID_Preferenza = rs.getInt("ID_Preferenza");
			}
			
			PreparedStatement ps1 = connection.prepareStatement(sql_Annunci);
			ps1.setInt(1, a.getID());
			ps1.setString(2, a.getTitolo());
			ps1.setString(3, a.getDescrizione());
			ps1.setString(4, a.getPathImmagine());
			ps1.setInt(5, a.getPartecipanti());
			ps1.setInt(6, ID_Preferenza);
			ps1.setBoolean(7, a.getIsVisible());
			
			ps1.executeQuery();
			
			PreparedStatement ps2 = connection.prepareStatement(sql_Organizzazione);
			ps2.setString(1, a.getUsernameOrganizzatore());
			ps2.setInt(2, a.getID());
			
			ps2.executeQuery();
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Annuncio> getAll() {
		
		ArrayList<Annuncio> elenco = new ArrayList<Annuncio>();
		String sql = "select * from (Organizzazione join Annunci on ID_Annuncio=ID) join Preferenze on ID_Preferenza=Preferenza";
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				
				String username = rs.getString("Username_Studente");
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
	public Annuncio get(Integer id) {
		
		String sql = "select * from (Organizzazione join Annunci on ID_Annuncio=ID) join Preferenze on ID_Preferenza=Preferenza where ID=?";
		Annuncio a = null;
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("Username_Studente");
				int ID = rs.getInt("ID");
				String titolo = rs.getString("Titolo");
				String descrizione = rs.getString("Descrizione");
				String path = rs.getString("Immagine");
				int partecipanti = rs.getInt("Partecipanti");
				String preferenza = rs.getString("Nome_Preferenza");
				boolean isVisible = rs.getBoolean("isVisible");
				a = new Annuncio(ID,titolo,descrizione,path,partecipanti,username,isVisible,preferenza);
			}
			return a;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean remove(Integer id) {
		int result=0;
		
		String sql = "delete from Annunci where ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
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

	
	public boolean update(Annuncio a) {
		String sql = "UPDATE Annunci SET ID=?, Titolo=? ,Descrizione=? ,Immagine=? ,Partecipanti=? ,isVisible=? WHERE ID=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, a.getID());
			ps.setString(2, a.getTitolo());
			ps.setString(3, a.getDescrizione());
			ps.setString(4, a.getPathImmagine());
			ps.setInt(5, a.getPartecipanti());
			ps.setBoolean(6, a.getIsVisible());
			ps.setInt(7, a.getID());

			
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Studente> getPartecipanti(Annuncio a) {
		
		ArrayList<Studente> elenco = new ArrayList<Studente>();
		String sql = "select * from (Partecipazione join Studenti on Username_Studente=Username) join Preferenze on Preferenza=ID_Preferenza where ID_Annuncio=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,a.getID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				String email = rs.getString("Email");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");
				boolean isAdmin = rs.getBoolean("isAdmin");
				boolean isSospeso = rs.getBoolean("isSospeso");
				int valutazione = rs.getInt("Valutazione");
				String preferenza = rs.getString("Nome_Preferenza");
				elenco.add(new Studente(nome,cognome,preferenza,email,username,password,isAdmin,isSospeso,valutazione));
			}
			return elenco;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Studente> getOrganizzatore(Annuncio a) {
		return null;
	}
	
	public boolean addPartecipante(Studente s,Annuncio a) {
		
		String sql = "insert into Partecipazione values(?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, s.getUsername());
			ps.setInt(2, a.getID());
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean removePartecipazione(Studente s,Annuncio a) {
		
		String sql = "delete from Partecipazione where Username_Studente=? and ID_Annuncio=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, s.getUsername());
			ps.setInt(2, a.getID());
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
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
