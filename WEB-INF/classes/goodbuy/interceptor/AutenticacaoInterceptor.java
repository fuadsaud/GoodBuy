package goodbuy.interceptor;

import goodbuy.SessaoUsuario;
import goodbuy.annotation.Restrito;
import goodbuy.controller.UsuariosController;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class AutenticacaoInterceptor implements Interceptor {

	private final Result result;
	private final SessaoUsuario sessaoUsario;

	public AutenticacaoInterceptor(Result result, SessaoUsuario sessaoUsario) {
		this.result = result;
		this.sessaoUsario = sessaoUsario;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return !sessaoUsario.isLogado() && method.containsAnnotation(Restrito.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.redirectTo(UsuariosController.class).login();
	}

}
