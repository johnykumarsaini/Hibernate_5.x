package in.jk.hibernate5.mergeandupdate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;


public class PersistEmployeeHibernate5Application {
	
	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setName("J K");
		employee.setCompany("Google");
		employee.setDesignation("Developer");
		
		Employee employee1 = new Employee();
		employee1.setEmpId(2);
		employee1.setName("Johny");
		employee1.setDesignation("Manager");
		
		session.persist(employee);
		session.persist(employee1);

		transaction.commit();
		session.close();

		Session session2 = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction1 = session2.beginTransaction();

		Employee emp1 = session2.get(Employee.class, 1);
		Employee emp2 = session2.get(Employee.class, 2);

		System.out.println("Employee :: 1 " + emp1);
		System.out.println("Employee :: 2 " + emp2);

		transaction1.commit();
		session2.close();
		

	}


}
