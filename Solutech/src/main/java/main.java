import java.sql.SQLException;

import br.com.fiap.solutech.dao.ChamadoDao;
import br.com.fiap.solutech.exception.IdNotFoundException;
import br.com.fiap.solutech.model.Chamado;
import br.com.fiap.solutech.model.Segurado;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IdNotFoundException {
		Chamado ch = new Chamado();
		Segurado sg = new Segurado();
		ChamadoDao Dao = new ChamadoDao();
		
		Dao.pesquisar(440);
	}
}
