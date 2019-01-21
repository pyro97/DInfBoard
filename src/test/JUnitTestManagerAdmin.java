package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import model.DAO.implement.ManagerAdmin;
import model.DAO.implement.ManagerAnnuncio;
import model.DAO.implement.ManagerStudente;
import model.PJO.Annuncio;
import model.PJO.Studente;

class JUnitTestManagerAdmin {
	
	
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
	  public void testGetAdmin() {
	    System.out.println("Test getStudente");
	    Studente s=new Studente("nome6","cognome6","preferenza6","email6","username6","password6",false,false,0);
	    ManagerStudente.registrazione(s);
	    ManagerAdmin.inserisciAdmin(s);
	    assertEquals(s,ManagerAdmin.getAdmin("username6"));
	  }
	  @Test
	  public void testInserisciAdmin() {
	    System.out.println("Test Inserisci Admin");
	    Studente s=new Studente("nome7","cognome7","preferenza7","email7","username7","password7",false,false,0);
	    ManagerStudente.registrazione(s);
	    assertTrue(ManagerAdmin.inserisciAdmin(s));
	  }
	  @Test
	  public void testEliminaAdmin() {
	    System.out.println("Test Elimina Admin");
	    Studente s=new Studente("nome8","cognome8","preferenza8","email8","username8","password8",false,false,0);
	    ManagerStudente.registrazione(s);
	    ManagerAdmin.inserisciAdmin(s);

	    assertTrue(ManagerAdmin.eliminaAdmin(s));
	  }
	  @Test
	  public void testSospendiUtente() {
	    System.out.println("Test Sospendi Utente");
	    Studente s=new Studente("nome9","cognome9","preferenza9","email9","username9","password9",false,false,0);
	    ManagerStudente.registrazione(s);

	    assertTrue(ManagerAdmin.sospendiUtente("username9"));
	  }
	  
	  @Test
	  public void testEliminaAnnuncioAdmin() {
	    System.out.println("Test Elimina Annuncio Admin");
	    Studente s=new Studente("nome10","cognome10","preferenza10","email10","username10","password10",false,false,0);
	    ManagerStudente.registrazione(s);

	    Annuncio a=new Annuncio(123,"titolo"," descrizione"," PathImmagine",2,"username10", true, "preferenza");
	    ManagerAnnuncio.inserisciAnnuncio(a);
	    assertTrue(ManagerAdmin.eliminaAnnuncioAdmin(123));
	  }


}
