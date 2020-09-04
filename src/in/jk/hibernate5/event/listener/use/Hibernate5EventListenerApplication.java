package in.jk.hibernate5.event.listener.use;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5EventListenerApplication {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory();

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(5);
		employee.setName("J K");
		employee.setCompany("Google");
		session.save(employee);

		transaction.commit();

		Transaction transaction1 = session.beginTransaction();

		Employee emp = session.get(Employee.class, 1);

		System.out.println("Employee :: " + emp);

		transaction1.commit();
		session.close();

	}

}
