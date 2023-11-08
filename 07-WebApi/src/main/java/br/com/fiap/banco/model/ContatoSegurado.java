package br.com.fiap.banco.model;

public class ContatoSegurado {
	
	private int id;
	private int idSegurado;
	private String telefone;
	private String email;
	
	public ContatoSegurado() {}

	public ContatoSegurado(int id, int idSegurado, String telefone, String email) {
		super();
		this.id = id;
		this.idSegurado = idSegurado;
		this.telefone = telefone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSegurado() {
		return idSegurado;
	}

	public void setIdSegurado(int idSegurado) {
		this.idSegurado = idSegurado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}
