package pet_shop.negocio.beans;

import java.time.LocalDate;

public class Atendimento {

	private static long proximoID = 1;
	
	private long id;
	private Animal animal;
	private Funcionario funcionario;
	private Venda compra;
	private LocalDate data;
	private String observacao;
	
	public Atendimento(Animal animal, Funcionario funcionario, Venda compra, LocalDate data, String observacao) {
		this.id = proximoID;
		proximoID++;
		this.animal = animal;
		this.funcionario = funcionario;
		this.compra = compra;
		this.data = data;
		this.observacao = observacao;
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

	public Venda getCompra() {
		return compra;
	}

	public void setCompra(Venda compra) {
		this.compra = compra;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public long getId() {
		return id;
	}
	
	public String toString() {
		return "\nID: " + this.id + "\nNome do animal: " + this.animal.getNome() + "\nNome do funcionário: " + this.funcionario.getNome() 
		+ "\n" + this.compra + "\nData: " + this.data + "\nObservação: " + this.observacao;
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
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
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
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}
	
	
}
