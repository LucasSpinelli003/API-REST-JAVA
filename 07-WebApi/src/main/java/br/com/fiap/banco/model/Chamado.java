package br.com.fiap.banco.model;

import java.time.LocalDateTime;

public class Chamado {
	private int id;
	private int idSegurado, idEnderecoSegurado,idContatoSegurado,idInfoVeiculo,idEnderecoChamado;
	private String descricao;
	private LocalDateTime dataCadastro;
	private EnderecoChamado enderecoChamado;
	private EnderecoSegurado enderecoSegurado;
	private ContatoSegurado contatoSegurado;
	private Segurado segurado;
	private Veiculo veiculo;
	
	public Chamado() {}
	
	

	public Chamado(int id, String descricao, LocalDateTime dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
	}


	
	

	public ContatoSegurado getContatoSegurado() {
		return contatoSegurado;
	}



	public void setContatoSegurado(ContatoSegurado contatoSegurado) {
		this.contatoSegurado = contatoSegurado;
	}



	public EnderecoSegurado getEnderecoSegurado() {
		return enderecoSegurado;
	}



	public void setEnderecoSegurado(EnderecoSegurado enderecoSegurado) {
		this.enderecoSegurado = enderecoSegurado;
	}



	public EnderecoChamado getEnderecoChamado() {
		return enderecoChamado;
	}



	public void setEnderecoChamado(EnderecoChamado enderecoChamado) {
		this.enderecoChamado = enderecoChamado;
	}



	public Segurado getSegurado() {
		return segurado;
	}



	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}



	public Veiculo getVeiculo() {
		return veiculo;
	}



	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}



	public int getIdSegurado() {
		return idSegurado;
	}



	public void setIdSegurado(int idSegurado) {
		this.idSegurado = idSegurado;
	}




	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}



	public int getIdEnderecoSegurado() {
		return idEnderecoSegurado;
	}



	public void setIdEnderecoSegurado(int idEnderecoSegurado) {
		this.idEnderecoSegurado = idEnderecoSegurado;
	}



	public int getIdContatoSegurado() {
		return idContatoSegurado;
	}



	public void setIdContatoSegurado(int idContatoSegurado) {
		this.idContatoSegurado = idContatoSegurado;
	}



	public int getIdInfoVeiculo() {
		return idInfoVeiculo;
	}



	public void setIdInfoVeiculo(int idInfoVeiculo) {
		this.idInfoVeiculo = idInfoVeiculo;
	}



	public int getIdEnderecoChamado() {
		return idEnderecoChamado;
	}



	public void setIdEnderecoChamado(int idEnderecoChamado) {
		this.idEnderecoChamado = idEnderecoChamado;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
