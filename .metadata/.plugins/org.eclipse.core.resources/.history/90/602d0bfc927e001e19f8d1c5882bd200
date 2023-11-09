package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.dao.ChamadoDao;
import br.com.fiap.banco.dao.SeguradoDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Chamado;
import br.com.fiap.banco.model.Produto;
import br.com.fiap.banco.model.Segurado;


public class ChamadoService {


	private SeguradoDao seguradoDao;
	private ChamadoDao chamadoDao;
	
	public ChamadoService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		chamadoDao = new ChamadoDao(conn);
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

	private void validar(Produto produto) throws BadInfoException {
		//Implementar algumas regras:
		//Nome obrigatorio e nao pode ter mais do que 50 caracteres
		if (produto.getNome() == null || produto.getNome().length() > 50) {
			throw new BadInfoException("Nome invalido, nao pode ser nulo e no maximo 50 caracteres");
		}
		//Estoque, Valor de Compra e Venda tem que ser maiores do que 0
		if (produto.getValorCompra() < 0) {
			throw new BadInfoException("Valor de compra precisa que ser positivo");
		}
		if (produto.getEstoque() < 0) {
			throw new BadInfoException("Estoque precisa ser positivo");
		}
		if (produto.getValorVenda() < 0) {
			throw new BadInfoException("Valor de venda precisa ser positivo");
		}
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
		
//	public Produto pesquisar(int codigo) throws ClassNotFoundException, SQLException, IdNotFoundException{
//		Produto p = produtoDao.pesquisar(codigo);
//		//Recuperar a categoria do produto, se existir
//		if (p.getCategoria() != null) {
//			Categoria c = categoriaDao.pesquisar(p.getCategoria().getCodigo());
//			p.setCategoria(c);
//		}
//		return p;
//	}
	public Chamado pesquisar(int id) throws ClassNotFoundException, SQLException, IdNotFoundException{
		Chamado ch = chamadoDao.pesquisar(id);
		//Recuperar a categoria do produto, se existir
		if (ch.getSegurado() != null) {
			Segurado s = seguradoDao.pesquisar(ch.getSegurado().getId());
			ch.setSegurado(s);
		}
		return ch;
	}

}