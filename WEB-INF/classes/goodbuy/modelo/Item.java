package goodbuy.modelo;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class Item {

	private Produto produto;

	private Integer quantidade;

	public Produto getProduto() {
		return produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
