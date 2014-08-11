package goodbuy.controller;

import goodbuy.dao.ProdutoDAO;
import goodbuy.modelo.Carrinho;
import goodbuy.modelo.Item;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CarrinhoController {

	private Carrinho carrinho;
	private ProdutoDAO dao;
	private Result result;

	public CarrinhoController(Result result, Carrinho carrinho, ProdutoDAO dao) {
		this.result = result;
		this.carrinho = carrinho;
		this.dao = dao;
	}

	@Post
	@Path("/carrinho")
	public void adiciona(Item item) {
		dao.recarrega(item.getProduto());
		carrinho.adiciona(item);

		result.redirectTo(this).visualiza();
	}

	@Delete
	@Path("/carrinho/{indice}")
	public void remove(int indice) {
		carrinho.remove(indice);

		result.redirectTo(this).visualiza();
	}

	@Get
	@Path("/carrinho")
	public void visualiza() {
	}
}
