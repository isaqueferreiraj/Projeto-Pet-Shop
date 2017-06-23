package pet_shop.negocio.beans;

import java.time.LocalDate;

public class Atendimento {

	private static long proximoID = 1;
	
	private long id;
	private Animal animal;
	private Funcionario funcionario;
	private Servico servico;
	private LocalDate data;
	private String diagnostico;
	
	public Atendimento(Animal animal, Funcionario funcionario, Servico servico, LocalDate data, String diagnostico) {
		this.id = proximoID;
		proximoID++;
		this.animal = animal;
		this.funcionario = funcionario;
		this.servico = servico;
		this.data = data;
		this.diagnostico = diagnostico;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getObservacao() {
		return diagnostico;
	}

	public void setObservacao(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public long getId() {
		return id;
	}
	
	public String toString() {
		return "\nID: " + this.id + "\nNome do animal: " + this.animal.getNome() + "\nNome do funcion�rio: " + this.funcionario.getNome() 
		+ "\n" + this.servico + "\nData: " + this.data + "\nObserva��o: " + this.diagnostico;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (diagnostico == null) {
			if (other.diagnostico != null)
				return false;
		} else if (!diagnostico.equals(other.diagnostico))
			return false;
		return true;
	}
	
	
}
