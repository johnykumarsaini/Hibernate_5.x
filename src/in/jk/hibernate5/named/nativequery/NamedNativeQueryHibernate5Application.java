package in.jk.hibernate5.named.nativequery;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class NamedNativeQueryHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		//addComputer();
		findComputer();

	}

	private static void addComputer() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Computer computer = new Computer();

		computer.setComputerId(1);
		computer.setCoumpterName("Dell");
		computer.setPrice(35000);

		session.persist(computer);

		transaction.commit();
		session.close();

		System.out.println("Computer Added Succussfully ...");

	}

	private static void findComputer() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createNamedQuery("findComputer");

		List<Object[]> list = query.getResultList();
		
		for (Object[] objects : list) {
			
			System.out.println("Computer Id    : "+objects[0]);
			System.out.println("Computer Name  : "+objects[1]);
			System.out.println("Computer Price : "+objects[2]);
			
		}

		transaction.commit();
		session.close();

		System.out.println("Computer Data Fetch Succussfully ...");

	}

}
