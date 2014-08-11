package goodbuy.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	private String username;

	private String nome;

	private String senha;

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getUsername() {
		return username;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}