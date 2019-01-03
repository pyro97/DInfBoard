package model.DAO;

import java.sql.Connection;
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
		return null;
	}

	@Override
	public boolean add(Preferenza p) {
		return false;
	}
	
	@Override
	public boolean remove(Preferenza a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Preferenza a) {
		// TODO Auto-generated method stub
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
