package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import model.DAO.PreferenzaDao;
import model.DAO.implement.ManagerPreferenza;
import model.DAO.implement.ManagerStudente;
import model.PJO.Preferenza;
import model.PJO.Studente;

class JUnitTestManagerPreferenza {
	@BeforeClass
	  public static void initClass() {
	    System.out.println("initClass()");
	  }
	  @AfterClass
	  public static void endClass() {
	    System.out.println("endClass()");
	  }
	  @Before
	  public void initMethod() {
	    System.out.println("initMethod()");
	  }
	  @After
	  public void endMethod() {
	    System.out.println("end Method");
	  }
	  @Test
	  public void testGetAllPreferenze() {
	    System.out.println("Test getAllPreferenze");
	    Preferenza p=new Preferenza(2121,"programmazione");
	    PreferenzaDao dao=new PreferenzaDao();
	    dao.add(p);
	    ArrayList<Preferenza> pref=new ArrayList<>();
	    pref.add(p);
	    
	    assertEquals(pref,ManagerPreferenza.getElencoPreferenze());
	  }

}
