package model.PJO;

public class Preferenza {

	private int ID;
	private String nome;
	
	public Preferenza(int ID,String Nome) {
		setID(ID);
		setNome(nome);
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
	
}
