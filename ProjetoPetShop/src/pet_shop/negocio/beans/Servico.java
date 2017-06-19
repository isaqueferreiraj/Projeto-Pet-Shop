package pet_shop.negocio.beans;

public class Servico {

	private static long proximoID = 1;
	
	private long id;
	private String nome;
	private double preco;
	private boolean consulta;
	
	public Servico(String nome, double preco, boolean consulta) {
		this.id = proximoID;
		proximoID++;
		this.nome = nome;
		this.preco = preco;
		this.consulta = consulta;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public String toString() {
		String text ="ID: " + this.id + "\nNome do produto: " + this.nome + "\nPreço: R$" + String.format("%.2f", this.preco) + "\nConsulta: ";
		
		if (this.consulta == true) {
			text += "Sim";
		} else {
			text += "Não";
		}
		
		return text;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (consulta != other.consulta)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco != other.preco)
			return false;
		return true;
	}

}
