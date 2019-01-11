package model.PJO;

public class Studente {

	private String nome;
	private String cognome;
	private String username;
	private String preferenza;
	private String email;
	private String password;
	private boolean IsAdmin;
	private boolean IsSospeso;
	private int Valutazione;
	
	public Studente(String nome,String cognome,String preferenza,String email,String username,String password,boolean isAdmin,boolean isSospeso,int valutazione) {
		setNome(nome);
		setCognome(cognome);
		setPreferenza(preferenza);
		setEmail(email);
		setUsername(username);
		setPassword(password);
		setIsAdmin(isAdmin);
		setIsSospeso(isSospeso);
		setValutazione(valutazione);
	}
	
	public Studente(String nome,String cognome,String email,String username,String password,String preferenza) {
		setNome(nome);
		setCognome(cognome);
		setEmail(email);
		setUsername(username);
		setPassword(password);
		setPreferenza(preferenza);
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPreferenza() {
		return preferenza;
	}
	public void setPreferenza(String preferenza) {
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
