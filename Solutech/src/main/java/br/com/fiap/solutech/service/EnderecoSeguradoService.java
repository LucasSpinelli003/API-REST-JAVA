package br.com.fiap.solutech.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.solutech.dao.EnderecoSeguradoDao;
import br.com.fiap.solutech.exception.BadInfoException;
import br.com.fiap.solutech.exception.IdNotFoundException;
import br.com.fiap.solutech.factory.ConnectionFactory;
import br.com.fiap.solutech.model.EnderecoSegurado;

public class EnderecoSeguradoService {

	private EnderecoSeguradoDao enderecoSeguradoDao;
	
	
	public EnderecoSeguradoService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		enderecoSeguradoDao = new EnderecoSeguradoDao(conn);
		}
	
	public void cadastrar(EnderecoSegurado enderecoSegurado) throws ClassNotFoundException, SQLException, BadInfoException {
		validar(enderecoSegurado);
		enderecoSeguradoDao.cadastrar(enderecoSegurado);
	}

	private void validar(EnderecoSegurado enderecoSegurado) throws BadInfoException {
		if (enderecoSegurado.getCep() == null || enderecoSegurado.getCep().length() > 11) {
			throw new BadInfoException("Telefone invalido, nao pode ser nulo e no maximo 11 caracteres");
		}
		if (enderecoSegurado.getLogradouro() == null || enderecoSegurado.getLogradouro().length() > 100) {
			throw new BadInfoException("Email invalido, nao pode ser nulo e no maximo 100 caracteres");
		}
	}
	
	public void atualizar(EnderecoSegurado enderecoSegurado) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		validar(enderecoSegurado);
		enderecoSeguradoDao.atualizar(enderecoSegurado);
	}
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		enderecoSeguradoDao.remover(id);
	}
	
	public List<EnderecoSegurado> listar() throws ClassNotFoundException, SQLException{
		return enderecoSeguradoDao.listar();
	}
	
	public List<EnderecoSegurado> pesquisarPorBairro(String bairro) throws SQLException{
		return enderecoSeguradoDao.pesquisarPorBairro(bairro);
	}
		
	public EnderecoSegurado pesquisar(int id) throws ClassNotFoundException, SQLException, IdNotFoundException{
		EnderecoSegurado eS = enderecoSeguradoDao.pesquisar(id);
		return eS;
	}

}