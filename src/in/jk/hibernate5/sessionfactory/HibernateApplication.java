package in.jk.hibernate5.sessionfactory;

import org.hibernate.SessionFactory;

import in.jk.hibernate5.HibernateUtils;

public class HibernateApplication {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		System.out.println("Database :: "+sessionFactory.openSession().createNativeQuery("Select version()").getResultList());
		
		System.out.println();
		SessionFactory sessionFactory1 = HibernateUtils.buildSessionFactory();
		System.out.println("Session Factory Config in java "+sessionFactory1);
		System.out.println("Database :: "+sessionFactory1.openSession().createNativeQuery("Select version()").getResultList());
		
		
	}

}
