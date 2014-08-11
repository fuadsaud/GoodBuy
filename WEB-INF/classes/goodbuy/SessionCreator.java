package goodbuy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class SessionCreator implements ComponentFactory<Session> {

	private final SessionFactory sessionFactory;
	private Session session;

	public SessionCreator(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@PostConstruct
	public void abre() {
		session = sessionFactory.openSession();
	}

	@PreDestroy
	public void fecha() {
		session.close();
	}

	@Override
	public Session getInstance() {
		return session;
	}
}
