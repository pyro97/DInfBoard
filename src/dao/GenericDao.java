package dao;

import java.util.ArrayList;

import model.PJO.Annuncio;

public interface GenericDao<T> {

	 ArrayList<T> getAll();
	 T get(int id);
	boolean add(T a);
}
