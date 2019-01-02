package model.PJO;

public class Annuncio {

	private int ID;
	private String titolo;
	private String descrizione;
	private String PathImmagine;
	private int partecipanti;
	private String usernameOrganizzatore;
	private boolean isVisible;
	private String preferenza;
	
	public Annuncio(int ID,String titolo,String descrizione,String PathImmagine,int partecipanti,
			String usernameOrganizzatore,boolean isVisible,String preferenza) {
		setID(ID);
		setTitolo(titolo);
		setDescrizione(descrizione);
		setPathImmagine(PathImmagine);
		setPartecipanti(partecipanti);
		setUsernameOrganizzatore(usernameOrganizzatore);
		setIsVisible(isVisible);
		setPreferenza(preferenza);
	}
	
	public Annuncio(String titolo,String descrizione,String PathImmagine,int partecipanti,
			String usernameOrganizzatore,boolean isVisible,String preferenza) {
		this.ID = 0;
		setTitolo(titolo);
		setDescrizione(descrizione);
		setPathImmagine(PathImmagine);
		setPartecipanti(partecipanti);
		setUsernameOrganizzatore(usernameOrganizzatore);
		setIsVisible(isVisible);
		setPreferenza(preferenza);
	}
	
	public String getPreferenza() {
		return preferenza;
	}

	public void setPreferenza(String preferenza) {
		this.preferenza = preferenza;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
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

	public String getUsernameOrganizzatore() {
		return usernameOrganizzatore;
	}

	public void setUsernameOrganizzatore(String usernameOrganizzatore) {
		this.usernameOrganizzatore = usernameOrganizzatore;
	}
	
	
}
