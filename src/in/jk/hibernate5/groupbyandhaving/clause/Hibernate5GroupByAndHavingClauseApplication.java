
package in.jk.hibernate5.groupbyandhaving.clause;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5GroupByAndHavingClauseApplication {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		//Hibernate5GroupByAndHavingClauseApplication.addSoftwareDeveloper();
		Hibernate5GroupByAndHavingClauseApplication.findDeveloperWithGroupByClause();

	}

	private static void findDeveloperWithGroupByClause() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String hqlQuery = "FROM SoftwareDeveloper developer GROUP BY developer.developerId Having developer.developerId>1";

		Query<SoftwareDeveloper> query = session.createQuery(hqlQuery, SoftwareDeveloper.class);
		List<SoftwareDeveloper> developers = query.getResultList();
		System.out.println("Software Developer List :: ");
		developers.forEach(System.out::println);

		transaction.commit();
		session.close();
		System.out.println("Developer Fetch Succussfully ...");

	
	}
	
	
//	private static void findDeveloperWithGroupBy() {
//
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//
//		String hqlQuery = "SELECT  developer.company FROM SoftwareDeveloper developer GROUP BY developer.company Having developer.developerId>1";
//
//		Query<Object[]> query = session.createQuery(hqlQuery);
//		List<Object[]> developers = query.getResultList();
//		System.out.println("Software Developer List :: ");
//	for (Object[] objects : developers) {
//		
//		System.out.println("Name :: "+objects[0]);
//		//System.out.println("Company :: "+objects[1]);
//		
//	}
//
//		transaction.commit();
//		session.close();
//		System.out.println("Developer Fetch Succussfully ...");
//
//	}


	private static void addSoftwareDeveloper() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		SoftwareDeveloper softwareDeveloper = new SoftwareDeveloper();
		softwareDeveloper.setDeveloperId(1);
		softwareDeveloper.setName("J K");
		softwareDeveloper.setCompany("Google");
		softwareDeveloper.setSalary(1000);

		SoftwareDeveloper softwareDeveloper2 = new SoftwareDeveloper();
		softwareDeveloper2.setDeveloperId(2);
		softwareDeveloper2.setName("John");
		softwareDeveloper2.setCompany("Google");
		softwareDeveloper2.setSalary(2000);

		SoftwareDeveloper softwareDeveloper3 = new SoftwareDeveloper();
		softwareDeveloper3.setDeveloperId(3);
		softwareDeveloper3.setName("Johny Kumar");
		softwareDeveloper3.setCompany("Google");
		softwareDeveloper3.setSalary(3000);

		SoftwareDeveloper softwareDeveloper4 = new SoftwareDeveloper();
		softwareDeveloper4.setDeveloperId(4);
		softwareDeveloper4.setName("Larry");
		softwareDeveloper4.setCompany("Oracle");
		softwareDeveloper4.setSalary(4000);

		SoftwareDeveloper softwareDeveloper5 = new SoftwareDeveloper();
		softwareDeveloper5.setDeveloperId(5);
		softwareDeveloper5.setName("Sunder");
		softwareDeveloper5.setCompany("Oracle");
		softwareDeveloper5.setSalary(5000);

		session.persist(softwareDeveloper);
		session.persist(softwareDeveloper2);
		session.persist(softwareDeveloper3);
		session.persist(softwareDeveloper4);
		session.persist(softwareDeveloper5);

		System.out.println("Developer Data Added Succussfully ...");

		transaction.commit();
		session.close();

	}

}