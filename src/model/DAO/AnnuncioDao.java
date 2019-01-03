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
	public boolean add(Annuncio s) {
		String sql = "Insert into Annunci(ID,Titolo,Descrizione,Immagine,Partecipanti,ID_Organizzatore,isVisible)"
				+ "values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, s.getID());
			ps.setString(2,s.getTitolo());
			ps.setString(3, s.getDescrizione());
			ps.setString(4, s.getPathImmagine());
			ps.setInt(5, s.getPartecipanti());
			ps.setInt(6,s.getIDOrganizzatore());
			ps.setBoolean(7, s.getIsVisible());
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
		
	}

	@Override
	public ArrayList<Annuncio> getAll() {
		int id = 0;
		String titolo = "";
		String descrizione= "";
		String immagine= "";
		int partecipanti= 0;
		int id_organizzatore = 0;
		boolean isVisible = false;
		
		ArrayList<Annuncio> annunci=new ArrayList<>();
		boolean valore=false;
		String sql = "Select * from Annunci ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
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
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return annunci;
	}

	@Override
	public Annuncio get(Integer id1) {
		int id = 0;
		String titolo = "";
		String descrizione= "";
		String immagine= "";
		int partecipanti= 0;
		int id_organizzatore = 0;
		boolean isVisible = false;
		
		boolean valore=false;
		String sql = "Select * from Annunci where ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("ID");
				titolo = rs.getString("Titolo");
				descrizione = rs.getString("Descrizione");
				immagine = rs.getString("Immagine");
				partecipanti = rs.getInt("Partecipanti");
				id_organizzatore = rs.getInt("ID_Organizzatore");
				isVisible = rs.getBoolean("isVisible");
				
				
			}
			return new Annuncio(id,titolo,descrizione,immagine,partecipanti,id_organizzatore,isVisible);

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Studente> getPartecipanti(Annuncio a) {
		//??????
		return null;
	}
	
	public ArrayList<Studente> getOrganizzatore(Annuncio a) {
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
		
		String sql = "Select * from Studenti where Username = ?"; //???????
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, a.getIDOrganizzatore());
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
	public boolean close() {
		try {
			connection.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean remove(Integer id) {
		int result=0;
		
		String sql = "delete * from Annunci where ID = ?";
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
	
	@Override
	public boolean update(Annuncio s) {
		String sql = "UPDATE Annunci SET ID=?, Titolo=? ,Descrizione=? ,Immagine=? ,Partecipanti=? "
				+ ",ID_Organizzatore=?, isVisible=? WHERE ID=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, s.getID());
			ps.setString(2,s.getTitolo());
			ps.setString(3, s.getDescrizione());
			ps.setString(4, s.getPathImmagine());
			ps.setInt(5, s.getPartecipanti());
			ps.setInt(6,s.getIDOrganizzatore());
			ps.setBoolean(7, s.getIsVisible());
			ps.setInt(8, s.getID());

			
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
