package goodbuy.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho {

	private List<Item> itens = new ArrayList<Item>();

	private Double total = 0.0;

	public void adiciona(Item item) {
		itens.add(item);
		total += item.getProduto().getPreco() * item.getQuantidade();
	}

	public List<Item> getItens() {
		return itens;
	}

	public Double getTotal() {
		return total;
	}

	public Integer getTotalDeItens() {
		return itens.size();
	}

	public void remove(int index) {
		Item removido = itens.remove(index);
		total -= removido.getProduto().getPreco() * removido.getQuantidade();
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
