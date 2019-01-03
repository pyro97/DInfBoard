package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.PJO.Annuncio;
import model.PJO.Preferenza;


public class PreferezaDao implements GenericDao<Preferenza,Integer> {

	private Connection connection;
	
	@Override
	public ArrayList<Preferenza> getAll() {
		int id = 0;
		String nome = "";
		
		ArrayList<Preferenza> preferenze=new ArrayList<>();

		String sql = "Select * from Preferenze ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("ID");
				nome=rs.getString("Nome");
				preferenze.add(new Preferenza(id,nome));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return preferenze;
	}
	
	

	@Override
	public Preferenza get(Integer id1) {
		
		int id = 0;
		String nome = "";
		
		String sql = "Select * from Annunci where ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id1);
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
		String sql = "Insert into Preferenze(ID,Nome)"
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
		
		String sql = "delete * from Preferenze where ID = ?";
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
	public boolean update(Preferenza s) {
		
		String sql = "UPDATE Preferenze SET ID=?, Nome=? WHERE ID=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, s.getID());
			ps.setString(2,s.getNome());
			ps.setInt(3, s.getID());
		
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	

	
}
