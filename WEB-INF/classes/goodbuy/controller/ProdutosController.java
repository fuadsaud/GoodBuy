package goodbuy.controller;

import static br.com.caelum.vraptor.view.Results.json;
import goodbuy.annotation.Restrito;
import goodbuy.dao.ProdutoDAO;
import goodbuy.modelo.Produto;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class ProdutosController {

	private ProdutoDAO dao;
	private final Result result;
	private final Validator validator;

	public ProdutosController(Result result, Validator validator, ProdutoDAO dao) {
		this.result = result;
		this.validator = validator;
		this.dao = dao;
	}

	@Post
	@Path("/produtos")
	@Restrito
	public void adiciona(Produto produto) {
		valida(produto);
		validator.onErrorUsePageOf(this).novo();

		dao.salva(produto);
		result.redirectTo(this).lista();
	}

	@Put
	@Path("/produtos/{produto.id}")
	@Restrito
	public void altera(Produto produto) {
		valida(produto);
		validator.onErrorUsePageOf(this).edita(produto.getId());

		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}

	@Get
	@Path("/produtos/busca")
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	@Get
	@Path("/produtos/busca.json")
	public void buscaJSON(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id", "descricao")
				.serialize();
	}

	@Get
	@Path("/produtos/{id}")
	@Restrito
	public Produto edita(Long id) {
		return dao.carrega(id);
	}

	@Get
	@Path("/produtos")
	public List<Produto> lista() {
		return dao.lista();
	}

	@Get
	@Path("/produtos/novo")
	@Restrito
	public void novo() {

	}

	@Delete
	@Path("/produtos/{id}")
	@Restrito
	public void remove(Long id) {
		dao.deleta(dao.carrega(id));
		result.redirectTo(this).lista();
	}

	private void valida(Produto produto) {
		if (produto.getNome() == null || produto.getNome().length() < 2) {
			validator.add(new ValidationMessage(
					"Nome é obrigatório e precisa ter mais de 3 letras", "produto.nome"));
		}
		if (produto.getDescricao() == null || produto.getDescricao().length() > 40) {
			validator.add(new ValidationMessage(
					"Descrição é obrigatória não pode ter mais que 40 letras",
					"produto.descricao"));
		}
		if (produto.getPreco() == null || produto.getPreco() <= 0) {
			validator
					.add(new ValidationMessage("Preço precisa ser positivo", "produto.preco"));
		}
	}
}
