package goodbuy.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String descricao;

	private Double preco;

	public String getDescricao() {
		return descricao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public Produto setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public Produto setId(Long id) {
		this.id = id;
		return this;
	}

	public Produto setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public Produto setPreco(Double preco) {
		this.preco = preco;
		return this;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao
				+ ", preco=" + preco + "]";
	}
}
