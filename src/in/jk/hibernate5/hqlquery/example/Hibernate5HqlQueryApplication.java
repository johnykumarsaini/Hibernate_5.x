package in.jk.hibernate5.hqlquery.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5HqlQueryApplication {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory();
		//Hibernate5HqlQueryApplication.addDeveloper(sessionFactory);
		System.out.println();
		//Hibernate5HqlQueryApplication.findAllDevelopers(sessionFactory);
		System.out.println();
		//Hibernate5HqlQueryApplication.findDeveloperById(sessionFactory);
		Hibernate5HqlQueryApplication.findDeveloperNameById(sessionFactory);
		System.out.println();
		Hibernate5HqlQueryApplication.findDeveloperNameAndCompanyById(sessionFactory);
		Hibernate5HqlQueryApplication.updateDeveloperCompanyById(sessionFactory);

	}

	private static void addDeveloper(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		JavaDeveloper javaDeveloper = new JavaDeveloper();
		javaDeveloper.setDeveloperId(1);
		;
		javaDeveloper.setName("J K");
		javaDeveloper.setCompany("Google");
		session.persist(javaDeveloper);

		JavaDeveloper javaDeveloper2 = new JavaDeveloper();
		javaDeveloper2.setDeveloperId(2);
		;
		javaDeveloper2.setName("Johny");
		javaDeveloper2.setCompany("Oracle");
		session.persist(javaDeveloper2);

		transaction.commit();
		session.close();

		System.out.println("Data Persist Succussfully ..");

	}

	private static void findAllDevelopers(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String hqlQuery = "FROM JavaDeveloper";

		Query<JavaDeveloper> query = session.createQuery(hqlQuery, JavaDeveloper.class);
		List<JavaDeveloper> developers = query.getResultList();

		System.out.println("All Developer List ::");
		developers.forEach(System.out::println);

		transaction.commit();
		session.close();

	}

	private static void findDeveloperById(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		int javaDeveloperId = 1;
		String hqlQuery = "FROM JavaDeveloper WHERE developerId=:javaDeveloperId";

		Query<JavaDeveloper> query = session.createQuery(hqlQuery, JavaDeveloper.class);
		query.setParameter("javaDeveloperId", javaDeveloperId);
		JavaDeveloper developer = query.uniqueResult();

		System.out.println("Java Developer By Id :: " + developer);

		transaction.commit();
		session.close();

	}
	
	
	private static void findDeveloperNameById(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		int javaDeveloperId = 1;
		String hqlQuery = "SELECT name FROM JavaDeveloper WHERE developerId=:javaDeveloperId";

		Query<String> query = session.createQuery(hqlQuery,String.class);
		query.setParameter("javaDeveloperId", javaDeveloperId);
		String developerName = query.uniqueResult();

		System.out.println("Java Developer Name By Id :: " + developerName);

		transaction.commit();
		session.close();

	}
	
	private static void findDeveloperNameAndCompanyById(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		int javaDeveloperId = 1;
		String hqlQuery = "SELECT name,company FROM JavaDeveloper WHERE developerId=:javaDeveloperId";

		Query query = session.createQuery(hqlQuery);
		query.setParameter("javaDeveloperId", javaDeveloperId);
		Object[] developer = (Object[]) query.uniqueResult();

		System.out.println("Java Developer Name By Id :: " + developer[0]);
		System.out.println("Java Developer Company By Id :: " + developer[1]);


		transaction.commit();
		session.close();

	}
	
	
	private static void updateDeveloperCompanyById(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		int javaDeveloperId = 1;
		String hqlQuery = "UPDATE JavaDeveloper SET company=:companyName  WHERE developerId=:javaDeveloperId";

		Query query = session.createQuery(hqlQuery);
		query.setParameter("companyName", "Alphabet");

		query.setParameter("javaDeveloperId", javaDeveloperId);
		
		int count =query.executeUpdate();
		
		if(count==1) {
			
			JavaDeveloper developer =  session.get(JavaDeveloper.class, 1);

			
			System.out.println("Java Developer with Updated Company By Id :: " + developer);

			
			
		}
		
		

		transaction.commit();
		session.close();

	}
	
	
	


}
