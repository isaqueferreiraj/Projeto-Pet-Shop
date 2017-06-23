package pet_shop.negocio;

import pet_shop.DAO.ProdutoDAO;
import pet_shop.negocio.beans.Produto;

public class CadastroProdutos {
	
	private ProdutoDAO repositorioProdutos;
	
	public CadastroProdutos(ProdutoDAO instanciaRepositorio) {
	    this.repositorioProdutos = instanciaRepositorio;
	}
	
	//Cadastro do produto
	public void cadastrar(Produto p) {
	    if (p == null) {
	      //Exceção
	    } else {
	      if (!this.existe(p)) {
	        this.repositorioProdutos.cadastrarProduto(p);
	      } else {
	    	  System.out.println("Aqui será colocada a exceção");
	      }
	    }
	}
	
	//Descadastra o produto do id repassado, depois de verificar a existência do produto
	public void descadastrar(long id){
		Produto p = this.repositorioProdutos.listarProduto(id);
		if(p != null){
			this.repositorioProdutos.excluirProduto(id);
		}
		else
			System.out.println("Aqui será colocada a exceção");
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
}
