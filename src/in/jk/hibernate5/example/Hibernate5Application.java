package in.jk.hibernate5.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5Application {

	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setName("J K");
		employee.setCompany("Google");
		//session.persist(employee);

		transaction.commit();

		Transaction transaction1 = session.beginTransaction();

		Employee emp = session.get(Employee.class, 1);

		System.out.println("Employee :: " + emp);

		transaction1.commit();
		session.close();

	}

}
