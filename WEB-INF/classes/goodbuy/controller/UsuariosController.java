package goodbuy.controller;

import goodbuy.SessaoUsuario;
import goodbuy.dao.UsuarioDAO;
import goodbuy.modelo.Usuario;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class UsuariosController {

	private final Result result;
	private final Validator validator;
	private final UsuarioDAO dao;
	private final SessaoUsuario sessaoUsuario;

	public UsuariosController(Result result, Validator validator, UsuarioDAO dao,
			SessaoUsuario sessaoUsuario) {
		this.result = result;
		this.validator = validator;
		this.dao = dao;
		this.sessaoUsuario = sessaoUsuario;
	}

	@Post
	@Path("/usuario")
	public void adiciona(Usuario usuario) {
		if (dao.existeUsuario(usuario)) {
			validator.add(new ValidationMessage("Login já existe", "usuario.login"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).novo();
		dao.adiciona(usuario);

		sessaoUsuario.login(usuario);
		result.redirectTo(ProdutosController.class).lista();
	}

	@Post
	@Path("/usuario/autenticacao")
	public void autentica(Usuario usuario) {
		Usuario carregado = dao.carrega(usuario);

		if (carregado == null) {
			validator
					.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).login();
		sessaoUsuario.login(carregado);

		result.redirectTo(ProdutosController.class).lista();
	}

	@Get
	@Path("/login")
	public void login() {

	}

	@Get
	@Path("/logout")
	public void logout() {
		this.sessaoUsuario.logout();

		result.redirectTo(ProdutosController.class).lista();
	}

	@Path("/usuario/novo")
	public void novo() {

	}
}
