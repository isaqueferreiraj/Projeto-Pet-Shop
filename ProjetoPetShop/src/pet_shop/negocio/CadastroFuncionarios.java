package pet_shop.negocio;

import pet_shop.DAO.FuncionarioDAO;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.beans.Funcionario;

import java.util.ArrayList;

public class CadastroFuncionarios {
	private FuncionarioDAO repositorioFuncionarios;
	private static CadastroFuncionarios instance;
	
	private CadastroFuncionarios() {
        this.repositorioFuncionarios = FuncionarioDAO.getInstance(); 
    }
	
	public static CadastroFuncionarios getInstance() {
		if(instance == null)
			instance = new CadastroFuncionarios();
		
		return instance;
	}
	
	public void cadastrar(Funcionario f) {
	    if (f == null) {
	      //Exce��o
	    } else {
	      if (!this.existe(f)) {
	        this.repositorioFuncionarios.cadastrarFuncionario(f);
	      } else {
	    	  System.out.println("Aqui ser� colocado a exce��o");
	      }
	    }
	}
	
	public void descadastrar(long id){
		Funcionario f = this.repositorioFuncionarios.listarFuncionario(id);
		if(f != null){
			this.repositorioFuncionarios.excluirFuncionario(id);
		}
		else
			System.out.println("Aqui ser� colocado a exce��o");
	}
	
	public Funcionario listar(long id){
		return this.repositorioFuncionarios.listarFuncionario(id);
	}
	
	public boolean existe(Funcionario f) {
	    return this.repositorioFuncionarios.existe(f);
	}
	
	public void excluirFuncionario(long id){
		this.repositorioFuncionarios.excluirFuncionario(id);
	}
	
	public ArrayList<Funcionario> listarTudo(){
		return this.repositorioFuncionarios.listarTudo();
	}
	
	public void AlteraFuncionario(Funcionario novoFuncionario) {
		Funcionario f = this.repositorioFuncionarios.listarFuncionario(novoFuncionario.getId());
		if( (f != null) && (novoFuncionario.getNome() != null) && (novoFuncionario.getCpf()!=null)) {
			this.repositorioFuncionarios.alterarFuncionario(novoFuncionario);
		}
		else {
			System.out.println("Aqui ficar� a exce��o");
		}
	}
}
