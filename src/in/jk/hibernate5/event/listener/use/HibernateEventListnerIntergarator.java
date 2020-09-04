package in.jk.hibernate5.event.listener.use;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class HibernateEventListnerIntergarator implements Integrator {

	@Override
	public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {
		
		EventListenerRegistry eventListenerRegistry =serviceRegistry.getService(EventListenerRegistry.class);
		eventListenerRegistry.getEventListenerGroup(EventType.SAVE).appendListener(new EmployeeSaveOrUpdateListener());
		
		
	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
		
		
	}

}
