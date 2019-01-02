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
		String sql = "Select * from Annunci";
		String sql_Preferenza = "Select * from Preferenze where ID_Preferenza=?";
		String sql_Organizzatore = "Select * from Organizzazione where ID_Annuncio=?";
		
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				
				//Ottengo l'id della categoria di preferenza in cui l'annuncio è stato inserito
				
				PreparedStatement ps = connection.prepareStatement(sql_Preferenza);
				ps.setInt(1, rs.getInt("Preferenza"));
				ResultSet rs_Preferenza = ps.executeQuery();
				String preferenza = "";
				while(rs_Preferenza.next()) 
					preferenza = rs_Preferenza.getString("Nome_Preferenza");
				
				//Ottento i dati dell'annuncio
				
				int id = rs.getInt("ID");
				String titolo = rs.getString("Titolo");
				String descrizione = rs.getString("Descrizione");
				String path = rs.getString("Immagine");
				int partecipanti = rs.getInt("Partecipanti");
				boolean isVisible = rs.getBoolean("isVisible");
				
				//Ottengo l'username dell'organizzatore dell'annuncio
				
				PreparedStatement psOrganizzazione = connection.prepareStatement(sql_Organizzatore);
				psOrganizzazione.setInt(1, id);
				ResultSet rsOrganizzazione = psOrganizzazione.executeQuery();	
				String username = "";
				while(rsOrganizzazione.next()) 
					username = rsOrganizzazione.getString("Username_Studente");				
				
				Annuncio a = new Annuncio(id,titolo,descrizione,path,partecipanti,username,isVisible,preferenza);
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
