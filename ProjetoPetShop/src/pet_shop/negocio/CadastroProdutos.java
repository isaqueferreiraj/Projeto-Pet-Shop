package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.ProdutoDAO;
import pet_shop.negocio.beans.Produto;

public class CadastroProdutos {
	
	private ProdutoDAO repositorioProdutos;
	private static CadastroProdutos instance;
	
	private CadastroProdutos() {
        this.repositorioProdutos = ProdutoDAO.getInstance(); 
    }
	
	public static CadastroProdutos getInstance() {
		if(instance == null)
			instance = new CadastroProdutos();
		
		return instance;
	}
	
	//Cadastro do produto
	public void cadastrar(Produto p) {
	    if (p == null) {
	      //Exce��o
	    } else {
	      if (!this.existe(p)) {
	        this.repositorioProdutos.cadastrarProduto(p);
	      } else {
	    	  System.out.println("Aqui ser� colocada a exce��o");
	      }
	    }
	}
	
	//Descadastra o produto do id repassado, depois de verificar a exist�ncia do produto
	public void descadastrar(long id){
		Produto p = this.repositorioProdutos.listarProduto(id);
		if(p != null){
			this.repositorioProdutos.excluirProduto(id);
		}
		else
			System.out.println("Aqui ser� colocada a exce��o");
	}
	
	//Lista produto de acordo com o id repassado
	public Produto listar(long id){
		return this.repositorioProdutos.listarProduto(id);
	}
	
	//Verifica se o produto existe
	public boolean existe(Produto p) {
	    return this.repositorioProdutos.existe(p);
	}
	
	//Exclui o produto de acordo com o id repassado
	public void excluirProduto(long id){
		this.repositorioProdutos.excluirProduto(id);
	}

	//Listar todos os produtos
	public ArrayList<Produto> listarTudo(){
		return this.repositorioProdutos.listarTudo();
	}
	
	public void AlteraProduto(Produto novoProduto) {
		Produto p = this.repositorioProdutos.listarProduto(novoProduto.getId());
		if( (p != null) && (novoProduto.getNome() != null)) {
			this.repositorioProdutos.alterarProduto(novoProduto);
		}
		else {
			System.out.println("Aqui ficar� a exce��o");
		}
	}
}
