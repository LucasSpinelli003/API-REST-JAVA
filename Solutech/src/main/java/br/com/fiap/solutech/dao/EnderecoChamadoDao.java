	package br.com.fiap.solutech.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import br.com.fiap.solutech.exception.IdNotFoundException;
import br.com.fiap.solutech.model.EnderecoChamado;
	
	
	public class EnderecoChamadoDao {
	
		private Connection conn;
	
		public EnderecoChamadoDao(Connection conn) {
			super();
			this.conn = conn;
		}
		
		public List<EnderecoChamado> pesquisarPorNome(String nome) throws SQLException{
			
			PreparedStatement stm = conn.prepareStatement("select * from t_sip_endereco_chamado where logradouro like ?");
		
			stm.setString(1, "%"+nome+"%");
			
			ResultSet result = stm.executeQuery();
			
			List<EnderecoChamado> lista = new ArrayList<>();
			
			while (result.next()) {
				EnderecoChamado enderecoChamado = parse(result);
				lista.add(enderecoChamado);
			}
			
			return lista;
		}
		
		public List<EnderecoChamado> listar() throws ClassNotFoundException, SQLException {
	
			PreparedStatement stm = conn.prepareStatement("select * from t_sip_endereco_chamado");
	
			ResultSet result = stm.executeQuery();
	
			List<EnderecoChamado> lista = new ArrayList<EnderecoChamado>();
	
			while (result.next()) {
				EnderecoChamado enderecoChamado = parse(result);
				lista.add(enderecoChamado);
			}
			return lista;
		}
		
		private EnderecoChamado parse(ResultSet result) throws SQLException {
			int id = result.getInt("id_endereco_chamado");
			String idEnderecoSegurado = result.getString("logradouro");
			String idContatoSegurado = result.getString("ponto_referencia");
		
			
			EnderecoChamado enderecoChamado = new EnderecoChamado(id, idEnderecoSegurado, idContatoSegurado);
	
			return enderecoChamado;
		}
		
		public void cadastrar(EnderecoChamado enderecoChamado) throws ClassNotFoundException, SQLException {
			
			PreparedStatement stmm = conn.prepareStatement("select * from t_sip_endereco_chamado");
			
			ResultSet resultGet = stmm.executeQuery();
	
			List<EnderecoChamado> lista = new ArrayList<EnderecoChamado>();
	
			while (resultGet.next()) {
				EnderecoChamado enderecoChamadoGet = parse(resultGet);
				lista.add(enderecoChamadoGet);
			}
			
			int id = lista.size() + 1;
	
			
			PreparedStatement stm = conn.prepareStatement(
					"INSERT INTO" + " T_SIP_ENDERECO_CHAMADO (id_endereco_chamado, logradouro, ponto_referencia) " + "values (?, ?, ?)");
	
			
			stm.setInt(1, id);
			stm.setString(2, enderecoChamado.getLogradouro());
			stm.setString(3, enderecoChamado.getPontoReferencia());
			
			
			stm.executeUpdate();
		}
		
		public EnderecoChamado pesquisar(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
	
			
			PreparedStatement stm = conn.prepareStatement("select * from" + " t_sip_endereco_chamado where id_endereco_chamado = ?");
	
			
			stm.setInt(1, id);
	
			ResultSet result = stm.executeQuery();
	
		
			if (!result.next()) {
				throw new IdNotFoundException("Endereço do chamado não encontrado");
			}
			EnderecoChamado enderecoChamado = parse(result);
			return enderecoChamado;
		}
		
		public void atualizar(EnderecoChamado enderecoChamado) throws ClassNotFoundException, SQLException, IdNotFoundException {
	
		
			PreparedStatement stm = conn
					.prepareStatement("update t_sip_endereco_chamado set logradouro = ?, ponto_referencia = ? where id_endereco_chamado = ?");
		
			stm.setString(1, enderecoChamado.getLogradouro());
			stm.setString(2, enderecoChamado.getPontoReferencia());
			stm.setInt(3, enderecoChamado.getId());
			
			int linha = stm.executeUpdate();
			if (linha == 0)
				throw new IdNotFoundException("Endereço do chamado não encontrado para atualizar");
		}
		
		public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
	
			
			PreparedStatement stm = conn.prepareStatement("delete from t_sip_endereco_chamado where id_endereco_chamado = ?");
		
			stm.setInt(1, id);
	
			int linha = stm.executeUpdate();
			if (linha == 0)
				throw new IdNotFoundException("Endereço do chamado não encontrado para remoção");
		}
	
		
		
	}
