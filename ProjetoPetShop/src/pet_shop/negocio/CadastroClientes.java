package pet_shop.negocio;

import pet_shop.DAO.ClienteDAO;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Pessoa;	

public class CadastroClientes {
	
	private ClienteDAO repositorioClientes;
	
	public CadastroClientes(ClienteDAO instanciaRepositorio) {
	    this.repositorioClientes = instanciaRepositorio;
	}
	
	public void cadastrar(Cliente c) {
	    if (c == null) {
	      //Exceção
	    } else {
	      if (!this.existe(c)) {
	        this.repositorioClientes.cadastrarCliente(c);
	      } else {
	    	  System.out.println("Aqui será colocado a exceção");
	      }
	    }
	}
	
	public void descadastrar(long id){
		Cliente c = this.repositorioClientes.listarCliente(id);
		if(c != null  /*E se ele tiver um agendamento?*/){
			this.repositorioClientes.excluirCliente(id);
		}
		else
			System.out.println("Aqui será colocado a exceção");
	}
	
	public Cliente listar(long id){
		return this.repositorioClientes.listarCliente(id);
	}
	
	public boolean existe(Cliente c) {
	    return this.repositorioClientes.existe(c);
	}
	
	public void excluirCliente(long id){
		this.repositorioClientes.excluirCliente(id);
	}
	
	public void AlteraCliente(Cliente novoCliente) {
		Cliente c = this.repositorioClientes.listarCliente(novoCliente.getId());
		if( (c != null) && (novoCliente.getNome() != null) && (novoCliente.getCpf()!=null)) {
			this.repositorioClientes.alterarCliente(novoCliente);
		}
		else {
			System.out.println("Aqui ficará a exceção");
		}
	}
}
