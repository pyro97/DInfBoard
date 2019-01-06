package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.PJO.Preferenza;


public class PreferenzaDao implements GenericDao<Preferenza,Integer> {

	private Connection connection;
	
	public PreferenzaDao() {
		
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
	public ArrayList<Preferenza> getAll() {
		
		ArrayList<Preferenza> elenco = new ArrayList<Preferenza>();
		String sql = "Select * from Preferenze";
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("ID_Preferenza");
				String nome = rs.getString("Nome_Preferenza");
				Preferenza p = new Preferenza(id,nome);
				elenco.add(p);
			}
			return elenco;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Preferenza get(Integer id) {
		String nome = "";
		
		String sql = "Select * from Preferenze where ID_Preferenza = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("ID");
				nome = rs.getString("Nome");	
			}
			return new Preferenza(id,nome);

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(Preferenza p) {
		String sql = "Insert into Preferenze(ID_Preferenza,Nome_Preferenza)"
				+ "values(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, p.getID());
			ps.setString(2,p.getNome());
	
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean remove(Integer id) {
		int result=0;
		
		String sql = "delete from Preferenze where ID_Preferenza = ?";
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
	public boolean update(Preferenza a) {
		String sql = "UPDATE Preferenze SET ID_Preferenza=?, Nome_Preferenza=? WHERE ID_Preferenza=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, a.getID());
			ps.setString(2,a.getNome());
			ps.setInt(3, a.getID());
		
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
