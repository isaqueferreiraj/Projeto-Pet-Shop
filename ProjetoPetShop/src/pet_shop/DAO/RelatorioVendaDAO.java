package pet_shop.DAO;

import java.time.YearMonth;
import java.util.ArrayList;

import pet_shop.negocio.beans.RelatorioVenda;

public class RelatorioVendaDAO {

	private ArrayList<RelatorioVenda> repositorioRelatorioVenda;
	private static RelatorioVendaDAO instance;
	
	private RelatorioVendaDAO() {
		this.repositorioRelatorioVenda = new ArrayList<>();
	}
	
	public static RelatorioVendaDAO getInstance() {
		if (instance == null) {
			instance = new RelatorioVendaDAO();
		}
		return instance;
	}
	
	public void cadastrarRelatorio(RelatorioVenda r) {
		this.repositorioRelatorioVenda.add(r);
	}
	
	public RelatorioVenda listarRelatorio(long id) {
		boolean achou = false;
		RelatorioVenda busca = null;
		for (int i = 0; i < this.repositorioRelatorioVenda.size() && achou == false; i++) {
			if (this.repositorioRelatorioVenda.get(i).getId() == id) {
				busca = this.repositorioRelatorioVenda.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<RelatorioVenda> listarTudo() {
		return this.repositorioRelatorioVenda;
	}
	
	public boolean existe(YearMonth data) {
		boolean verificar = false;
		for (int i = 0; i < this.repositorioRelatorioVenda.size() && verificar == false; i++) {
			if (data.equals(this.repositorioRelatorioVenda.get(i))) {
				verificar = true;
			}
		}
		return verificar;
	}
}
