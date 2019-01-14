package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.DAO.implement.ManagerStudente;
import model.PJO.Studente;

import org.junit.Assert.*;
import org.junit.*;

class JUnitTestManagerStudente {
	
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
	  public void testRegistrazione() {
	    System.out.println("Test Registrazione");
	    Studente s=new Studente("nome","cognome","preferenza","email","username","password",false,false,0);
	    assertTrue(ManagerStudente.registrazione(s));
	  }
	
	  @Test
	  public void testLogin() {
	    System.out.println("Test Login");
	    Studente s=new Studente("nome1","cognome1","preferenza1","email1","username1","password1",false,false,0);
	    ManagerStudente.registrazione(s);
	    assertEquals(s,ManagerStudente.login("username1","password1"));
	  }
	  
	  @Test
	  public void testGetStudente() {
	    System.out.println("Test getStudente");
	    Studente s=new Studente("nome2","cognome2","preferenza2","email2","username2","password2",false,false,0);
	    ManagerStudente.registrazione(s);
	    assertEquals(s,ManagerStudente.getStudente("username2"));
	  }
	  @Test
	  public void testModificaProfilo() {
	    System.out.println("Test Modifica Profilo");
	    Studente s=new Studente("nome3","cognome3","preferenza3","email3","username3","password3",false,false,0);
	    ManagerStudente.registrazione(s);
	    assertTrue(ManagerStudente.modificaProfilo(s));
	  }
	  @Test
	  public void testEliminaProfilo() {
	    System.out.println("Test Elimina Profilo");
	    Studente s=new Studente("nome4","cognome4","preferenza4","email4","username4","password4",false,false,0);
	    ManagerStudente.registrazione(s);
	    assertTrue(ManagerStudente.eliminaProfilo(s));
	  }
	  @Test
	  public void testValutazione() {
	    System.out.println("Test Valutazione");
	    Studente s=new Studente("nome5","cognome5","preferenza5","email5","username5","password5",false,false,0);
	    assertTrue(ManagerStudente.valutazione(s, 4, 1));
	  }
	 
	 

}
