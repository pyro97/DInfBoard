package model.PJO;

public class Studente {

	private int ID;
	private String nome;
	private String cognome;
	private int preferenza;
	private String email;
	private String password;
	private boolean IsAdmin;
	private boolean IsSospeso;
	private int Valutazione;
	
	public Studente(int ID,String nome,String cognome,int preferenza,String email,String password,boolean isAdmin,boolean isSospeso,int valutazione) {
		setID(ID);
		setNome(nome);
		setCognome(cognome);
		setPreferenza(preferenza);
		setEmail(email);
		setPassword(password);
		setIsAdmin(isAdmin);
		setIsSospeso(isSospeso);
		setValutazione(valutazione);
	}
	
	public Studente(int ID,String nome,String cognome,String email,String username,String password) {
		setID(ID);
		setNome(nome);
		setCognome(cognome);
		setEmail(email);
		setPassword(password);
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getPreferenza() {
		return preferenza;
	}
	public void setPreferenza(int preferenza) {
		this.preferenza = preferenza;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		IsAdmin = isAdmin;
	}
	public boolean isIsSospeso() {
		return IsSospeso;
	}
	public void setIsSospeso(boolean isSospeso) {
		IsSospeso = isSospeso;
	}
	public int getValutazione() {
		return Valutazione;
	}
	public void setValutazione(int valutazione) {
		Valutazione = valutazione;
	}
}
