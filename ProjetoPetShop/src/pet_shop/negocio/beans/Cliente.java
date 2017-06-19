package pet_shop.negocio.beans;

public class Cliente extends Pessoa {

	public Cliente(String nome, String cpf, String rua, String bairro, String numCasa, String email, String telefone) {
		super(nome, cpf, rua, bairro, numCasa, email, telefone);
	}

	public String toString() {
		return "ID: " + this.id + "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nRua: " + this.rua + "\nBairro: " + this.bairro + 
				"\nNúmero da casa: " + this.numCasa + "\nEmail: " + this.email + "\nTelefone: " + this.telefone;
	}

}
