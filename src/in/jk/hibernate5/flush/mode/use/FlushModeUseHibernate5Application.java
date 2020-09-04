package in.jk.hibernate5.flush.mode.use;

import java.util.List;

import javax.persistence.FlushModeType;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class FlushModeUseHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		
		//FlushModeUseHibernate5Application.autoFlushMode();
		
		//commitFlushMode();
		//alwaysFlushMode();
		manualFlushMode();

	}

	private static void autoFlushMode() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		BankAccount account = new BankAccount();
		account.setAccountNumber(8);
		account.setUserName("J K");
		account.setBankName("State Bank Of India");
		account.setBranchName("Khatuali");

		session.save(account);
		
		
		List<BankAccount>bankAccounts=session.createQuery("FROM BankAccount").getResultList();
         
		System.out.println();
		bankAccounts.forEach(System.out::println);
		
		transaction.commit();

		//session.close();

	}
	
	/*
	 * Change flush to data base while commit the transaction .
	 */
	private static void commitFlushMode() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		BankAccount account = new BankAccount();
		account.setAccountNumber(12);
		account.setUserName("John Johnson");
		account.setBankName("City Bank");
		account.setBranchName("New York");

		session.save(account);
		
		transaction.commit(); // above change or object id 12 will reflect for following fetch .
		
		List<BankAccount> bankAccounts=session.createQuery("FROM BankAccount ").setFlushMode(FlushModeType.COMMIT).list();

		bankAccounts.forEach(System.out::println);
		
		System.out.println("----------------------------");
		
		List<BankAccount> bankAccountList=session.createQuery("FROM BankAccount ").setFlushMode(FlushModeType.COMMIT).list();

		bankAccountList.forEach(System.out::println);
		
		//transaction.commit(); // the above object  with id 12 will not be  reflect for above  fetch .

		//session.close();

	}
	
	private static void manualFlushMode() {

		Session session = sessionFactory.openSession();
		session.setHibernateFlushMode(FlushMode.MANUAL);
		Transaction transaction = session.beginTransaction();
		BankAccount account = new BankAccount();
		account.setAccountNumber(17);
		account.setUserName("John Johnson");
		account.setBankName("City Bank");
		account.setBranchName("New York");

		session.save(account);
		
		transaction.commit(); // above change or object id 12 will reflect for following fetch .
		
		List<BankAccount> bankAccounts=session.createQuery("FROM BankAccount ").list();

		bankAccounts.forEach(System.out::println);
		
		System.out.println("----------------------------");
		
		List<BankAccount> bankAccountList=session.createQuery("FROM BankAccount ").list();

		bankAccountList.forEach(System.out::println);
		
		//transaction.commit(); // the above object  with id 12 will not be  reflect for above  fetch .

		//session.close();

	}
	
	
	private static void alwaysFlushMode() {

		Session session = sessionFactory.openSession();
		session.setHibernateFlushMode(FlushMode.ALWAYS);
		Transaction transaction = session.beginTransaction();
		BankAccount account = new BankAccount();
		account.setAccountNumber(15);
		account.setUserName("John Johnson");
		account.setBankName("City Bank");
		account.setBranchName("New York");

		session.save(account);
		
		//transaction.commit(); // above change or object id 12 will reflect for following fetch .
		
		List<BankAccount> bankAccounts=session.createQuery("FROM BankAccount ").list();

		bankAccounts.forEach(System.out::println);
		
		System.out.println("----------------------------");
		
		List<BankAccount> bankAccountList=session.createQuery("FROM BankAccount ").list();

		bankAccountList.forEach(System.out::println);
		
		transaction.commit(); // the above object  with id 12 will not be  reflect for above  fetch .

		//session.close();


	}

}
