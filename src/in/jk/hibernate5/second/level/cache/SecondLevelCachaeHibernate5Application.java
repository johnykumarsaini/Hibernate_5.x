package in.jk.hibernate5.second.level.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class SecondLevelCachaeHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		SecondLevelCachaeHibernate5Application.addEmployee();
		SecondLevelCachaeHibernate5Application.findEmployee();

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

		Employee emp = session.get(Employee.class, 1);

		System.out.println("Employee :: 1 " + emp);

		System.out.println("-------------------------------------------------");

		Employee emp2 = session.get(Employee.class, 1);

		System.out.println("Employee :: 2  " + emp2);

		transaction1.commit();
		
		session.close();
		
		System.out.println("..............Session Close .........");
		System.out.println();
		
		
		Session session2 = sessionFactory.openSession();

		Transaction transaction2 = session2.beginTransaction();

		Employee emp3 = session2.get(Employee.class, 1);

		System.out.println("Employee :: 3 " + emp3);

		System.out.println("-------------------------------------------------");

		Employee emp4 = session2.get(Employee.class, 1);

		System.out.println("Employee :: 4  " + emp4);

		transaction2.commit();
		
		session2.close();
		
	}

}
