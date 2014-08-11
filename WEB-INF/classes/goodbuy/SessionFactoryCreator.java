package goodbuy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class SessionFactoryCreator implements ComponentFactory<SessionFactory> {

	private SessionFactory sessionFactory;

	@PostConstruct
	public void abre() {
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@PreDestroy
	public void fecha() {
		sessionFactory.close();
	}

	@Override
	public SessionFactory getInstance() {
		return sessionFactory;
	}
}
