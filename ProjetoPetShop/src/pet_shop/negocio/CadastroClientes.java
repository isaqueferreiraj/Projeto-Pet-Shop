package pet_shop.negocio;

import pet_shop.DAO.ClienteDAO;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.AgendaController;

public class CadastroClientes {
	
	private ClienteDAO repositorioClientes;
	private static CadastroClientes instance;
	
	private CadastroClientes() {
        this.repositorioClientes = ClienteDAO.getInstance(); 
    }
	
	public static CadastroClientes getInstance() {
		if(instance == null)
			instance = new CadastroClientes();
		
		return instance;
	}
	
	public void cadastrar(Cliente c) {
	    if (c == null) {
	      //Exce��o
	    } else {
	      if (!this.existe(c)) {
	        this.repositorioClientes.cadastrarCliente(c);
	      } else {
	    	  System.out.println("Aqui ser� colocado a exce��o");
	      }
	    }
	}
	
	public void descadastrar(long id){
		Cliente c = this.repositorioClientes.listarCliente(id);
		
		if(c != null  /*E se ele tiver um agendamento?*/){
			this.repositorioClientes.excluirCliente(id);
			for(int i = 0; i < AgendaController.getInstance().listarTodasAgendas().size(); i++){
				if()
				AgendaController.getInstance().deleteAgenda(id);
			}
		}
		else
			System.out.println("Aqui ser� colocado a exce��o");
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
			System.out.println("Aqui ficar� a exce��o");
		}
	}
}
