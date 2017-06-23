package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.negocio.beans.Agenda;
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Atendimento;

public class SistemaFachada {
	
	private AgendaController controleAgendas;
	private AnimalController controleAnimais;
	private AtendimentoController controleAtendimentos;
	
	private static SistemaFachada instance;
	
	//Singleton
	private SistemaFachada() {
		
		this.controleAgendas = AgendaController.getInstance();
		this.controleAnimais = AnimalController.getInstance();
		this.controleAtendimentos = AtendimentoController.getInstance();
		
	}
	
	public static SistemaFachada getInstance() {
		if(instance == null) {
			instance = new SistemaFachada();
		}
		return instance;
	}
	
	//controle agendas
	public void saveAgenda(Agenda agenda) {
		controleAgendas.saveAgenda(agenda);
	}

	public Agenda findAgenda(long id) {
		return controleAgendas.findAgenda(id);
	}

	public void updateAgenda(Agenda newAgenda) {
		controleAgendas.updateAgenda(newAgenda);
	}

	public void deleteAgenda(long id) {
		controleAgendas.deleteAgenda(id);
	}

	public ArrayList<Agenda> listarTodasAgendas() {
		return controleAgendas.listarTodasAgendas();
	}
	
	//controle animais
	public void saveAnimal(Animal animal) {
		controleAnimais.saveAnimal(animal);
	}

	public void updateAnimal(Animal animal) {
		controleAnimais.updateAnimal(animal);
	}

	public void deleteAnimal(long id) {
		controleAnimais.deleteAnimal(id);
	}

	public Animal findAnimal(long id) {
		return controleAnimais.findAnimal(id);
	}

	public ArrayList<Animal> listarTodosAnimais() {
		return controleAnimais.listarTodosAnimais();
	}
	
	//controle atendimentos
	public void saveAtendimento(Atendimento atendimento) {
		controleAtendimentos.saveAtendimento(atendimento);
	}

	public void updateAtendimento(Atendimento atendimento) {
		controleAtendimentos.updateAtendimento(atendimento);
	}

	public void deleteAtendimento(long id) {
		controleAtendimentos.deleteAtendimento(id);
	}

	public Atendimento findAtendimento(long id) {
		return controleAtendimentos.findAtendimento(id);
	}

	public ArrayList<Atendimento> listarTodosAtendimentos() {
		return controleAtendimentos.listarTodosAtendimentos();
	}
	

	

}
