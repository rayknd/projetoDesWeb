package Service;

import DAO.OlimpiadaDAO;
import Model.Olimpiada;
import TO.OlimpiadaTO;

public class OlimpiadaService {

	OlimpiadaDAO pp = new OlimpiadaDAO();
	public void criarOlimpiada(Olimpiada p) {
		pp.criarOlimpiada(p);
	}
	public void carregarOlimpiada(Olimpiada p) {
		pp.carregarOlimpiada(p);
	}
	public void atualizarOlimpiada(Olimpiada p) {
		pp.atualizarOlimpiada(p);
	}
	public void excluirPais(Olimpiada p) {
		pp.excluirOlimpiada(p);
	}
}
