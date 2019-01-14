package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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

class JUnitTestManagerAnnuncio {


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
	  public void testInserisciAnnuncio() {
	    System.out.println("Test inserisci annuncio");
	    Studente s=new Studente("nome11","cognome11","preferenza11","email11","username11","password11",false,false,0);
	    ManagerStudente.registrazione(s);

	    Annuncio a=new Annuncio(124,"titolo1"," descrizione1"," PathImmagine1",2,"username11", true, "preferenza1");
	    assertTrue(ManagerAnnuncio.inserisciAnnuncio(a));
	  }
	  @Test
	  public void testOttieniBacheca() {
	    System.out.println("Test ottieni bachceca");
	    Studente s=new Studente("nome12","cognome12","preferenza12","email12","username12","password12",false,false,0);
	    ManagerStudente.registrazione(s);

	    Annuncio a=new Annuncio(125,"titolo2"," descrizione2"," PathImmagine2",2,"username12", true, "preferenza2");
	    ManagerAnnuncio.inserisciAnnuncio(a);
	    ArrayList<Annuncio> array=new ArrayList<>();
	    array.add(a);
	    assertEquals(array,ManagerAnnuncio.ottieniBacheca());
	  }
	  @Test
	  public void testRimuoviAnnuncio() {
	    System.out.println("Test rimuovi annuncio");
	    Studente s=new Studente("nome13","cognome13","preferenza13","email13","username13","password13",false,false,0);
	    ManagerStudente.registrazione(s);

	    Annuncio a=new Annuncio(126,"titolo3"," descrizione3"," PathImmagine3",2,"username13", true, "preferenza3");
	    ManagerAnnuncio.inserisciAnnuncio(a);

	    assertTrue(ManagerAnnuncio.rimuoviAnnuncioPersistente(a));
	  }
	  @Test
	  public void testAnnuncioNonVisibile() {
	    System.out.println("Test annuncio non visibile");
	    Studente s=new Studente("nome14","cognome14","preferenza14","email14","username14","password14",false,false,0);
	    ManagerStudente.registrazione(s);

	    Annuncio a=new Annuncio(127,"titolo4"," descrizione4"," PathImmagine4",2,"username14", true, "preferenza4");
	    ManagerAnnuncio.inserisciAnnuncio(a);
	    assertTrue(ManagerAnnuncio.annuncioNonVisibile(a));
	  }
	  
	  @Test
	  public void testModificAnnuncio() {
	    System.out.println("Test modifica Annuncio ");
	    Studente s=new Studente("nome15","cognome15","preferenza15","email15","username15","password15",false,false,0);
	    ManagerStudente.registrazione(s);

	    Annuncio a=new Annuncio(128,"titolo5"," descrizione5"," PathImmagine5",2,"username15", true, "preferenza5");
	    ManagerAnnuncio.inserisciAnnuncio(a);
	    a.setDescrizione("descrizioneee5");
	    assertTrue(ManagerAnnuncio.modificaAnnuncio(a));
	  }
	  
	  @Test
	  public void testAggiungiPartecipazione() {
	    System.out.println("Test aggiungi partecipazione");
	    Studente s=new Studente("nome16","cognome16","preferenza16","email16","username16","password16",false,false,0);
	    ManagerStudente.registrazione(s);

	    Annuncio a=new Annuncio(129,"titolo6"," descrizione6"," PathImmagine6",2,"username16", true, "preferenza6");
	    ManagerAnnuncio.inserisciAnnuncio(a);
	    Studente s1=new Studente("nome17","cognome17","preferenza17","email17","username17","password17",false,false,0);
	    ManagerStudente.registrazione(s1);
	    

	    assertTrue(ManagerAnnuncio.aggiungiPartecipazione(s1, a));
	  }
	  
	  @Test
	  public void testEliminaPartecipazione() {
	    System.out.println("Test elimina partecipazione");
	    Studente s=new Studente("nome18","cognome18","preferenza18","email18","username18","password18",false,false,0);
	    ManagerStudente.registrazione(s);

	    Annuncio a=new Annuncio(130,"titolo7"," descrizione7"," PathImmagine7",2,"username18", true, "preferenza7");
	    ManagerAnnuncio.inserisciAnnuncio(a);
	    Studente s1=new Studente("nome19","cognome19","preferenza19","email19","username19","password19",false,false,0);
	    ManagerStudente.registrazione(s1);
	    
	    ManagerAnnuncio.aggiungiPartecipazione(s1, a);
	    

	    assertTrue(ManagerAnnuncio.eliminaPartecipazione(s1, a));
	  }

}
