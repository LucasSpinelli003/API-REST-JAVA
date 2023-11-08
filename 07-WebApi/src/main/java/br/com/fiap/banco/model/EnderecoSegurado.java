package br.com.fiap.banco.model;

public class EnderecoSegurado {
	private int id;
	private int idSegurado;
	private String cep;
	private String logradouro;
	private String bairro;
	private String complemento;
	
	public EnderecoSegurado() {}

	public EnderecoSegurado(int id, int idSegurado, String cep, String logradouro, String bairro, String complemento) {
		super();
		this.id = id;
		this.idSegurado = idSegurado;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.complemento = complemento;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	

}
