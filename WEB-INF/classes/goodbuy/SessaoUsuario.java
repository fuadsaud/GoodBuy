package goodbuy;

import goodbuy.modelo.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class SessaoUsuario {

	private Usuario logado;

	public String getNome() {
		return logado.getNome();
	}

	public boolean isLogado() {
		return logado != null;
	}

	public void login(Usuario usuario) {
		logado = usuario;
	}

	public void logout() {
		this.logado = null;
	}
}
