package br.com.fiap.solutech.model;

import java.time.LocalDateTime;

public class Segurado {
	private int id;
	private String nome;
	private String rg;
	private String cpf;
	private LocalDateTime dataNascimento;
	private EnderecoSegurado enderecoSegurado;
	private ContatoSegurado contatoSegurado;
	private Veiculo veiculo;
	
	
	public Segurado() {}

	public Segurado(int id, String nome, String rg, String cpf, LocalDateTime dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}







	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getRg() {
		return rg;
	}







	public void setRg(String rg) {
		this.rg = rg;
	}







	public String getCpf() {
		return cpf;
	}







	public void setCpf(String cpf) {
		this.cpf = cpf;
	}







	public EnderecoSegurado getEnderecoSegurado() {
		return enderecoSegurado;
	}

	public void setEnderecoSegurado(EnderecoSegurado enderecoSegurado) {
		this.enderecoSegurado = enderecoSegurado;
	}

	public ContatoSegurado getContatoSegurado() {
		return contatoSegurado;
	}

	public void setContatoSegurado(ContatoSegurado contatoSegurado) {
		this.contatoSegurado = contatoSegurado;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
}
