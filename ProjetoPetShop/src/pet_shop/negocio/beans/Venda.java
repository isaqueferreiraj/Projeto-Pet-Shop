package pet_shop.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {

	private static long proximoID = 1;
	
	private long id;
	private Cliente cliente;
	private ArrayList<Servico> servicos;
	private ArrayList<Produto> produtos;
	private LocalDate data;
	private double valorTotal;
	
	public Venda(Cliente cliente, ArrayList<Servico> servicos, ArrayList<Produto> produtos, LocalDate data) {
		this.id = proximoID;
		proximoID++;
		this.cliente = cliente;
		this.servicos = servicos;
		this.produtos = produtos;
		this.data = data;
		this.valorTotal = valorServicos() + valorProdutos();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(ArrayList<Servico> servicos) {
		this.servicos = servicos;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public long getId() {
		return id;
	}
	
	public void adicionarProduto(Produto p) {
		if (p != null) {
			this.produtos.add(p);
		}
	}
	
	public void remover(long id) {
		boolean achou = false;
		for (int i = 0; i < this.produtos.size() && achou == false; i++) {
			if (this.produtos.get(i).getId() == id) {
				this.produtos.remove(i);
				achou = true;
			}
		}
	}
	
	public void adicionarServico(Servico s) {
		if (s != null) {
			this.servicos.add(s);
		}
	}
	
	public void removerServico(long id) {
		boolean achou = false;
		for (int i = 0; i < this.servicos.size() && achou == false; i++) {
			if (this.servicos.get(i).getId() == id) {
				this.servicos.remove(i);
				achou = true;
			}
		}
	}
	
	private double valorServicos() {
		double valorTotalServicos = 0;
		for (int i = 0; i < this.servicos.size(); i++) {
			valorTotalServicos += this.servicos.get(i).getPreco();
		}
		return valorTotalServicos;
	}
	
	private double valorProdutos() {
		double valorTotalProdutos = 0;
		for (int i = 0; i < this.produtos.size(); i++) {
			valorTotalProdutos += this.produtos.get(i).getPreco();
		}
		return valorTotalProdutos;
	}
	
	public String toString() {
		String text = "ID: " + this.id + "\nData: " + this.data + "\n Nome do cliente: " + this.cliente.getNome() + "\nProduto(s): ";
		
		for (int i = 0; i < this.produtos.size(); i++) {
			text += String.format("\n%20s \t%.2f", this.produtos.get(i).getNome(), this.produtos.get(i).getPreco());
		}
		
		text += "\nServiço(s): ";
		
		for (int i = 0; i < this.servicos.size(); i++) {
			text += String.format("\n%20s \t%.2f", this.servicos.get(i).getNome(), this.servicos.get(i).getPreco());
		}
		
		text += "\n\nValor Total: " + String.format("%.2f", this.valorTotal);
		
		return text;
	}
	
}
