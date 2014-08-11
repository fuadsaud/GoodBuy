package goodbuy.dao;

import goodbuy.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class UsuarioDAO {

	private final Session session;

	public UsuarioDAO(Session session) {
		this.session = session;
	}

	public void adiciona(Usuario usuario) {
		Transaction tx = this.session.beginTransaction();
		this.session.save(usuario);
		tx.commit();
	}

	public Usuario carrega(Usuario usuario) {
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("username", usuario.getUsername()))
				.add(Restrictions.eq("senha", usuario.getSenha())).uniqueResult();
	}

	public boolean existeUsuario(Usuario usuario) {
		Usuario usuarioEncontrado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("username", usuario.getUsername())).uniqueResult();

		return usuarioEncontrado != null;
	}
}
