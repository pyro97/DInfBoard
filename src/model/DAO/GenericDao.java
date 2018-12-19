package model.DAO;

import java.util.ArrayList;


public interface GenericDao<T> {

	 ArrayList<T> getAll();
	 T get(int id);
	boolean add(T a);
	boolean close();
}
