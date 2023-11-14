package br.com.fiap.solutech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.solutech.exception.IdNotFoundException;
import br.com.fiap.solutech.model.ContatoSegurado;
import br.com.fiap.solutech.model.EnderecoSegurado;
import br.com.fiap.solutech.model.Segurado;
import br.com.fiap.solutech.model.Veiculo;


public class SeguradoDao {

	private Connection conn;

	public SeguradoDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public List<Segurado> pesquisarPorNome(String nome) throws SQLException{
	
		PreparedStatement stm = conn.prepareStatement("select * from t_sip_segurado where nome_completo like ?");
		
		stm.setString(1, "%"+nome+"%");
		
		ResultSet result = stm.executeQuery();
	
		List<Segurado> lista = new ArrayList<>();
		
		while (result.next()) {
			Segurado segurado = parse(result);
			lista.add(segurado);
		}
		
		return lista;
	}

	public List<Segurado> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from t_sip_segurado");

		ResultSet result = stm.executeQuery();

		List<Segurado> lista = new ArrayList<Segurado>();

		while (result.next()) {
			Segurado segurado = parse(result);
			lista.add(segurado);
		}
		return lista;
	}

	private Segurado parse(ResultSet result) throws SQLException {
		int id = result.getInt("id_segurado");
		int idEnderecoSegurado = result.getInt("id_endereco_segurado");
		int idContatoSegurado = result.getInt("id_contato_segurado");
		int idInfoVeiculo = result.getInt("id_info_veiculo");
		String nomeCompleto = result.getString("nome_completo");
		LocalDateTime dataNascimento = result.getObject("data_nascimento", LocalDateTime.class);
		String rg = result.getString("rg");
		String cpf = result.getString("cpf");

		Segurado segurado = new Segurado(id, nomeCompleto, rg, cpf, dataNascimento);

		if (idEnderecoSegurado != 0) {
			EnderecoSegurado enderecoSegurado = new EnderecoSegurado();
			enderecoSegurado.setId(idEnderecoSegurado);
			segurado.setEnderecoSegurado(enderecoSegurado);
		}
		if (idContatoSegurado != 0) {
			ContatoSegurado contatoSegurado = new ContatoSegurado();
			contatoSegurado.setId(idContatoSegurado);
			segurado.setContatoSegurado(contatoSegurado);
		}
		if(idInfoVeiculo != 0) {
			Veiculo veiculo = new Veiculo();
			veiculo.setId(idInfoVeiculo);
			segurado.setVeiculo(veiculo);
		}

		return segurado;
	}

	public void cadastrar(Segurado segurado) throws ClassNotFoundException, SQLException {
		
		PreparedStatement stmm = conn.prepareStatement("select * from t_sip_segurado");

		ResultSet resultGet = stmm.executeQuery();

		List<Segurado> lista = new ArrayList<Segurado>();

		while (resultGet.next()) {
			Segurado seguradoGet = parse(resultGet);
			lista.add(seguradoGet);
		}
		
		int id = lista.size() + 1;

		
		PreparedStatement stm = conn.prepareStatement(
				"INSERT INTO" + " T_SIP_SEGURADO (id_segurado, id_endereco_segurado, id_contato_segurado,"
						+ " id_info_veiculo ,nome_completo, data_nascimento, rg,cpf) " + "values (?, ?, ?, ?, ?, ?, ?, ?)");

		
		stm.setInt(1, id);
		stm.setInt(2, segurado.getEnderecoSegurado().getId());
		stm.setInt(3, segurado.getContatoSegurado().getId());
		stm.setInt(4,segurado.getVeiculo().getId());
		stm.setString(5, segurado.getNome());
		stm.setObject(6, segurado.getDataNascimento());
		stm.setString(7, segurado.getRg());
		stm.setString(8, segurado.getCpf());
		
		stm.executeUpdate();
	}

	public Segurado pesquisar(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

	
		PreparedStatement stm = conn.prepareStatement("select * from" + " t_sip_segurado where id_segurado = ?");

		
		stm.setInt(1, id);

	
		ResultSet result = stm.executeQuery();

		
		if (!result.next()) {
			
			throw new IdNotFoundException("Segurado não encontrado");
		}
		Segurado segurado = parse(result);
	
		return segurado;
	}

	public void atualizar(Segurado segurado) throws ClassNotFoundException, SQLException, IdNotFoundException {

		
		PreparedStatement stm = conn
				.prepareStatement("update t_sip_segurado set nome_completo = ?, rg = ?, cpf =? where id_segurado = ?");
		
		stm.setString(1, segurado.getNome());
		stm.setString(2, segurado.getRg());
		stm.setString(3, segurado.getCpf());
		stm.setInt(4, segurado.getId());
		
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Segurado não encontrado para atualizar");
	}

	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		
		PreparedStatement stm = conn.prepareStatement("delete from t_sip_segurado where id_segurado = ?");
		
		stm.setInt(1, id);
		
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Segurado não encontrado para remoção");
	}

}
