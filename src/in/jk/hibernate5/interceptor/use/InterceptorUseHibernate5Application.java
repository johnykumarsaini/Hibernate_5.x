package in.jk.hibernate5.interceptor.use;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;


public class InterceptorUseHibernate5Application {
	
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory();
		
		Session session =sessionFactory.withOptions().interceptor(new EmployeeInterceptor()).openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(11);
		employee.setName("J K");
		employee.setCompany("Google");
		//session.persist(employee);

		transaction.commit();

		
		Transaction transaction1 = session.beginTransaction();

		Employee emp = session.load(Employee.class, 1);

		System.out.println("Employee :: " + emp);

		transaction1.commit();
		session.close();

	}

}
