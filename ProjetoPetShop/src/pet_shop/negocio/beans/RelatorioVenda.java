package pet_shop.negocio.beans;

import java.time.YearMonth;
import java.util.ArrayList;

public class RelatorioVenda {

	private static long proximoID = 1;
	
	private long id;
	private ArrayList<Venda> vendas;
	private YearMonth data;
	
	public RelatorioVenda(ArrayList<Venda> vendas, YearMonth data) {
		this.id = proximoID;
		proximoID++;
		this.vendas = vendas;
		this.data = data;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

	public YearMonth getData() {
		return data;
	}

	public void setData(YearMonth data) {
		this.data = data;
	}

	public long getId() {
		return id;
	}
	
	public String toString() {
		String text = "\nID: " + this.id + "\t\tData: " + this.data + "\nVenda(s): ";
		
		for (int i = 0; i < this.vendas.size(); i++) {
			text += "------------------------------------------------------------------";
			text += "\nID Venda: " + this.vendas.get(i).getId() + "\nCliente: " + this.vendas.get(i).getCliente().getNome() + "\nData: " + this.vendas.get(i).getData() 
					+ "\nValor: " + String.format("%.2f", this.vendas.get(i).getValorTotal());
		}
		
		text += "------------------------------------------------------------------";
		
		return text;
	}
	
}
