package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.AnimalDAO;
import pet_shop.negocio.beans.Animal;

public class AnimalController {
	
	private AnimalDAO animalrepository;
	private static AnimalController instance;
	
	//Singleton
	private AnimalController() {
		this.animalrepository = AnimalDAO.getInstance();
	}
	
	public static AnimalController getInstance() {
		if(instance == null) {
			instance = new AnimalController();
		}
		return instance;
	}
	
	//Controle dos métodos do repositório
	public void saveAnimal(Animal animal) {
		
		if(animal != null && (!this.animalrepository.existe(animal))) {
			this.animalrepository.cadastrarAnimal(animal);
		}
		
	}
	
	public void updateAnimal(Animal animal) {
		
		Animal a = this.animalrepository.listarAnimal(animal.getId());
		
		if(a != null) {
			this.animalrepository.alterarAnimal(animal);
		}
		
	}
	
	public void deleteAnimal(long id) {
		
		if(id >= 0 && this.animalrepository.existe(id)) {
			this.animalrepository.excluirAnimal(id);
		}
		
	}
	
	public Animal findAnimal(long id) {
		
		if(id >= 0 && this.animalrepository.existe(id)) {
			return this.animalrepository.listarAnimal(id);
		} else {
			return null;
		}
		
	}
	
	public ArrayList<Animal> listarTudo() {
		return this.animalrepository.listarTudo();	
	}

}
