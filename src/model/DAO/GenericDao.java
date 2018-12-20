package model.DAO;

import java.util.ArrayList;


public interface GenericDao<T,S> {

	 ArrayList<T> getAll();
	 T get(S id);
	boolean add(T a);
	boolean close();
}
