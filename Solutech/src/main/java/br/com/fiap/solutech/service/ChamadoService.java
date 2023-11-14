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
	private EnderecoChamadoDao enderecoChamadoDao;
	
	public ChamadoService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		chamadoDao = new ChamadoDao(conn);
		enderecoChamadoDao = new EnderecoChamadoDao(conn); 
		seguradoDao = new SeguradoDao(conn);
		}
	
	public void cadastrar(Chamado chamado) throws ClassNotFoundException, SQLException, BadInfoException, IdNotFoundException {
		validar(chamado);
		chamadoDao.cadastrar(chamado);
	}

	private void validar(Chamado chamado) throws BadInfoException {
		if (chamado.getDescricao() == null || chamado.getDescricao().length() > 200) {
			throw new BadInfoException("Descricao invalida, nao pode ser nula e no maximo 200 caracteres");
		}
	}
	
	public void atualizar(Chamado chamado) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		validar(chamado);
		chamadoDao.atualizar(chamado);
	}
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		chamadoDao.remover(id);
	}
	
	public List<Chamado> listar() throws ClassNotFoundException, SQLException, IdNotFoundException{
		return chamadoDao.listar();
	}
		
	public Chamado pesquisar(int id) throws ClassNotFoundException, SQLException, IdNotFoundException{
		Chamado ch = chamadoDao.pesquisar(id);
		if (ch.getSegurado() != null) {
			Segurado segurado = seguradoDao.pesquisar(ch.getSegurado().getId());
			ch.setSegurado(segurado);
		}
		if (ch.getEnderecoChamado() != null) {
			EnderecoChamado enderecoChamado = enderecoChamadoDao.pesquisar(ch.getEnderecoChamado().getId());
			ch.setEnderecoChamado(enderecoChamado);
		}
		return ch;
	}

}