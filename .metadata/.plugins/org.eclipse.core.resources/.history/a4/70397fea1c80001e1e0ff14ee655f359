package br.com.fiap.solutech.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.solutech.dao.ChamadoDao;
import br.com.fiap.solutech.dao.ContatoSeguradoDao;
import br.com.fiap.solutech.dao.EnderecoChamadoDao;
import br.com.fiap.solutech.dao.EnderecoSeguradoDao;
import br.com.fiap.solutech.dao.SeguradoDao;
import br.com.fiap.solutech.dao.VeiculoDao;
import br.com.fiap.solutech.exception.BadInfoException;
import br.com.fiap.solutech.exception.IdNotFoundException;
import br.com.fiap.solutech.factory.ConnectionFactory;
import br.com.fiap.solutech.model.Chamado;
import br.com.fiap.solutech.model.ContatoSegurado;
import br.com.fiap.solutech.model.EnderecoChamado;
import br.com.fiap.solutech.model.EnderecoSegurado;
import br.com.fiap.solutech.model.Segurado;
import br.com.fiap.solutech.model.Veiculo;


public class ChamadoService {


	private SeguradoDao seguradoDao;
	private ChamadoDao chamadoDao;
	private ContatoSeguradoDao contatoSeguradoDao;
	private EnderecoChamadoDao enderecoChamadoDao;
	private EnderecoSeguradoDao enderecoSeguradoDao;
	private VeiculoDao veiculoDao;
	
	public ChamadoService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		chamadoDao = new ChamadoDao(conn);
		enderecoChamadoDao = new EnderecoChamadoDao(conn); 
		contatoSeguradoDao = new ContatoSeguradoDao(conn);
		enderecoSeguradoDao = new EnderecoSeguradoDao(conn);
		veiculoDao = new VeiculoDao(conn);
		seguradoDao = new SeguradoDao(conn);
		}
	
	/*
	 * public void cadastrar(Produto produto) throws ClassNotFoundException,
	 * SQLException, BadInfoException { validar(produto);
	 * produtoDao.cadastrar(produto); }
	 */
	
	public void cadastrar(Chamado chamado) throws ClassNotFoundException, SQLException, BadInfoException {
		//validar(produto);
		chamadoDao.cadastrar(chamado);
	}

	private void validar(Chamado chamado) throws BadInfoException {
		//Implementar algumas regras:
		//Nome obrigatorio e nao pode ter mais do que 50 caracteres
//		if (produto.getNome() == null || produto.getNome().length() > 50) {
//			throw new BadInfoException("Nome invalido, nao pode ser nulo e no maximo 50 caracteres");
//		}
	}
	
	public void atualizar(Chamado chamado) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		//validar(produto);
		chamadoDao.atualizar(chamado);
	}
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		chamadoDao.remover(id);
	}
	
	public List<Chamado> listar() throws ClassNotFoundException, SQLException{
		return chamadoDao.listar();
	}
		
	public Chamado pesquisar(int id) throws ClassNotFoundException, SQLException, IdNotFoundException{
		Chamado ch = chamadoDao.pesquisar(id);
		//Recuperar a categoria do produto, se existir
		if (ch.getSegurado() != null) {
			Segurado segurado = seguradoDao.pesquisar(ch.getSegurado().getId());
			ch.setSegurado(segurado);
		}
		if (ch.getContatoSegurado() != null) {
			ContatoSegurado contatoSegurado = contatoSeguradoDao.pesquisar(ch.getContatoSegurado().getId());
			ch.setContatoSegurado(contatoSegurado);
		}
		if (ch.getEnderecoChamado() != null) {
			EnderecoChamado enderecoChamado = enderecoChamadoDao.pesquisar(ch.getEnderecoChamado().getId());
			ch.setEnderecoChamado(enderecoChamado);
		}
		if (ch.getEnderecoSegurado() != null) {
			EnderecoSegurado enderecoSegurado = enderecoSeguradoDao.pesquisar(ch.getEnderecoSegurado().getId());
			ch.setEnderecoSegurado(enderecoSegurado);
		}
		if (ch.getVeiculo() != null) {
			Veiculo veiculo = veiculoDao.pesquisar(ch.getVeiculo().getId());
			ch.setVeiculo(veiculo);
		}
		return ch;
	}

}