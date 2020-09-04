package in.jk.hibernate5.mergeandupdate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;


public class MergeVsUpdateHibernate5Application {
	
	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = session.get(Employee.class, 1);

		System.out.println("Employee :: 1 " + emp);

		transaction.commit();
		session.close();

		Session session2 = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction1 = session2.beginTransaction();

		Employee emp1 = session2.get(Employee.class, 1);
		emp.setDesignation("Java Developer");
		//session2.update(emp); --> org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session

		session2.merge(emp);
		System.out.println("Employee :: 2 " + emp1);
		
		Employee emp3 = session2.get(Employee.class, 1);
		System.out.println("Employee :: 3 " + emp3);

		transaction1.commit();
		session2.close();
		

	}

}
