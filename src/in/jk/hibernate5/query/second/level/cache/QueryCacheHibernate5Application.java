
package in.jk.hibernate5.query.second.level.cache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class QueryCacheHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		QueryCacheHibernate5Application.addEmployee();
		QueryCacheHibernate5Application.findEmployee();

	}

	private static void addEmployee() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setName("J K");
		employee.setCompany("Google");
		session.persist(employee);

		transaction.commit();

		session.close();

		System.out.println("Employee Added ....");
	}

	private static void findEmployee() {

		Session session = sessionFactory.openSession();

		Transaction transaction1 = session.beginTransaction();

		Query<Employee> query = session.createQuery("FROM Employee" ,Employee.class); 
		query.setCacheable(Boolean.TRUE);
		List<Employee> employees =query.getResultList();
		
		employees.forEach(System.out::println);

	

		System.out.println("-------------------------------------------------");

		Query<Employee> query2 = session.createQuery("FROM Employee" ,Employee.class); 
		query2.setCacheable(Boolean.TRUE);
		List<Employee> employees2 =query2.getResultList();
		
		employees2.forEach(System.out::println);
		transaction1.commit();

		session.close();

		System.out.println("..............Session Close .........");
		System.out.println();

		Session session2 = sessionFactory.openSession();

		Transaction transaction2 = session2.beginTransaction();

		Query<Employee> query3 = session2.createQuery("FROM Employee" ,Employee.class); 
		query3.setCacheable(Boolean.TRUE);
		List<Employee> employees3 =query3.getResultList();
		
		employees3.forEach(System.out::println);

		System.out.println("-------------------------------------------------");

		Query<Employee> query4 = session2.createQuery("FROM Employee" ,Employee.class); 
		query4.setCacheable(Boolean.TRUE);
		List<Employee> employees4 =query4.getResultList();
		
		employees4.forEach(System.out::println);

		transaction2.commit();

		session2.close();

	}

}
