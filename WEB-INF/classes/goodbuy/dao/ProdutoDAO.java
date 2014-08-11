package goodbuy.dao;

import goodbuy.modelo.Produto;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ProdutoDAO {

	private final Session session;

	public ProdutoDAO(Session session) {
		this.session = session;
	}

	public void atualiza(Produto p) {
		Transaction tx = session.beginTransaction();
		session.update(p);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> busca(String nome) {
		return session.createCriteria(Produto.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).list();
	}

	public Produto carrega(Long id) {
		return (Produto) session.load(Produto.class, id);
	}

	public void deleta(Produto p) {
		Transaction tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> lista() {
		return session.createCriteria(Produto.class).list();
	}

	public void recarrega(Produto produto) {
		session.refresh(produto);
	}

	public void salva(Produto p) {
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
	}
}
