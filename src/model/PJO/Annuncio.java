package model.PJO;

public class Annuncio {

	private int ID;
	private String titolo;
	private String descrizione;
	private String PathImmagine;
	private int partecipanti;
	private int IDOrganizzatore;
	private boolean isVisible;
	
	public Annuncio(int ID,String titolo,String descrizione,String PathImmagine,int partecipanti,
			int ID_Organizzatore,boolean isVisible) {
		setID(ID);
		setTitolo(titolo);
		setDescrizione(descrizione);
		setPathImmagine(PathImmagine);
		setPartecipanti(partecipanti);
		setIDOrganizzatore(ID_Organizzatore);
		setIsVisible(isVisible);
	}
	
	public void setIsVisible(boolean isVisible) {
		this.isVisible=isVisible;
	}

	public boolean getIsVisible() {
		return isVisible;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getPathImmagine() {
		return PathImmagine;
	}

	public void setPathImmagine(String pathimmagine) {
		PathImmagine = pathimmagine;
	}

	public int getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(int partecipanti) {
		this.partecipanti = partecipanti;
	}

	public int getIDOrganizzatore() {
		return IDOrganizzatore;
	}

	public void setIDOrganizzatore(int iD_Organizzatore) {
		IDOrganizzatore = iD_Organizzatore;
	}
	
	
}
