package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Agenda;

public class AgendaDAO {

	private ArrayList<Agenda> repositorioAgenda;
	private static AgendaDAO instance;
	
	private AgendaDAO() {
		this.repositorioAgenda = new ArrayList<>();
	}
	
	public static AgendaDAO getInstance() {
		if (instance == null) {
			instance = new AgendaDAO();
		}
		return instance;
	}
	
	public void cadastrarAgenda(Agenda a) {
		this.repositorioAgenda.add(a);
	}
	
	public void alterarAgenda(Agenda a) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioAgenda.size() && achou == false; i++) {
			if (this.repositorioAgenda.get(i).getId() == a.getId()) {
				this.repositorioAgenda.remove(i);
				this.repositorioAgenda.add(i, a);
				achou = true;
			}
		}
	}
	
	public void excluirAgenda(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioAgenda.size() && achou == false; i++) {
			if (this.repositorioAgenda.get(i).getId() == id) {
				this.repositorioAgenda.remove(i);
				achou = true;
			}
		}
	}
	
	public Agenda listarAgenda(long id) {
		boolean achou = false;
		Agenda busca = null;
		for (int i = 0; i < this.repositorioAgenda.size() && achou == false; i++) {
			if (this.repositorioAgenda.get(i).getId() == id) {
				busca = this.repositorioAgenda.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Agenda> listarTudo() {
		return this.repositorioAgenda;
	}
	
}
