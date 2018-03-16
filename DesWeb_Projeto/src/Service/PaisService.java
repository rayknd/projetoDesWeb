package Service;

import DAO.PaisDAO;
import Model.Pais;
import TO.PaisTO;

public class PaisService {
	
	PaisDAO pp = new PaisDAO();
	public void criarPais(Pais p) {
		pp.criarPais(p);
	}
	public void carregarPais(Pais p) {
		pp.carregar(p);
	}
	public void atualizarPais(Pais p) {
		pp.atualizar(p);
	}
	public void excluirPais(Pais p) {
		pp.excluir(p);
	}
	
}
