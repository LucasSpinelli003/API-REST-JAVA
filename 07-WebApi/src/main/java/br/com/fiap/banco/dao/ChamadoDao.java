package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.model.Categoria;
import br.com.fiap.banco.model.Chamado;
import br.com.fiap.banco.model.ContatoSegurado;
import br.com.fiap.banco.model.EnderecoChamado;
import br.com.fiap.banco.model.EnderecoSegurado;
import br.com.fiap.banco.model.Produto;
import br.com.fiap.banco.model.Segurado;
import br.com.fiap.banco.model.Veiculo;

public class ChamadoDao {

	private Connection conn;
	
	public ChamadoDao() {}
	
	public ChamadoDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<Chamado> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from t_sip_chamado");

		ResultSet result = stm.executeQuery();

		List<Chamado> lista = new ArrayList<Chamado>();

		while (result.next()) {
			Chamado chamado = parse(result);
			lista.add(chamado);
		}
		return lista;
	}
	
	private Chamado parse(ResultSet result) throws SQLException {
		int id = result.getInt("id_chamado");
		int idSegurado = result.getInt("id_segurado");
		int idEnderecoSegurado = result.getInt("id_endereco_segurado");
		int idContatoSegurado = result.getInt("id_contato_segurado");
		int idInfoVeiculo = result.getInt("id_info_veiculo");
		int idEnderecoChamado = result.getInt("id_endereco_chamado");
		String descricao = result.getString("descricao");
		LocalDateTime dataCadastro = result.getObject("data_chamado", LocalDateTime.class);
		
		Chamado chamado = new Chamado(id,descricao,dataCadastro);
		
		if (idSegurado != 0) {
			Segurado segurado = new Segurado();
			segurado.setId(idSegurado);
			chamado.setIdSegurado(idSegurado);
		}
		if (idEnderecoSegurado != 0) {
			Segurado segurado = new Segurado();
			EnderecoSegurado enderecoSegurado = new EnderecoSegurado();
			enderecoSegurado.setId(idEnderecoSegurado);
			segurado.setIdEndereco(idEnderecoSegurado);
			chamado.setIdEnderecoSegurado(idEnderecoSegurado);
		}
		if (idContatoSegurado != 0) {
			Segurado segurado = new Segurado();
			ContatoSegurado contatoSegurado = new ContatoSegurado();
			segurado.setIdContato(idContatoSegurado);
			chamado.setIdContatoSegurado(idContatoSegurado);
			contatoSegurado.setId(idContatoSegurado);
		}
		if (idInfoVeiculo != 0) {
			Veiculo veiculo = new Veiculo();
			veiculo.setId(idInfoVeiculo);
			chamado.setIdInfoVeiculo(idInfoVeiculo);
		}
		if (idEnderecoChamado != 0) {
			EnderecoChamado enderecoChamado = new EnderecoChamado();
			enderecoChamado.setId(idEnderecoChamado);
			chamado.setIdEnderecoChamado(idEnderecoChamado);
		}
		
		return chamado;
	}
	
	public void cadastrar(Chamado chamado) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement("INSERT INTO" + " T_SIP_CHAMADO (id_chamado, id_segurado, id_endereco_segurado,"
				+ " , id_contato_segurado, id_info_veiculo, id_endereco_chamado,descricao, data_chamado) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)");

		// Setar os valores no comando SQL
		stm.setInt(1, chamado.getId());
		stm.setInt(2, chamado.getSegurado().getId());
		stm.setInt(3, chamado.getEnderecoSegurado().getId());
		stm.setInt(4, chamado.getContatoSegurado().getId());
		stm.setInt(5, chamado.getVeiculo().getId());
		stm.setInt(6, chamado.getEnderecoChamado().getId());
		stm.setString(7, chamado.getDescricao());
		stm.setObject(8, chamado.getDataCadastro());
		// Executar o comando SQL
		stm.executeUpdate();
	}
	
}
