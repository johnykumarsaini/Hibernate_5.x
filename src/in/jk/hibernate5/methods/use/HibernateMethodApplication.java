package in.jk.hibernate5.methods.use;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.hibernate.jdbc.WorkExecutor;

import in.jk.hibernate5.HibernateUtils;

public class HibernateMethodApplication {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();

//		HibernateMethodApplication.persistUser();
//		HibernateMethodApplication.saveUser();
//		HibernateMethodApplication.saveOrUpdateUser();
//		HibernateMethodApplication.getUser();
//		HibernateMethodApplication.loadUser();
//		HibernateMethodApplication.findUserById();
//		HibernateMethodApplication.delete();

		// HibernateMethodApplication.refresh();

		HibernateMethodApplication.evict();

	}

	/*
	 * session.persist() method save object in database for given object id if same
	 * object with duplicate id then it Throws an Exception ::
	 * org.hibernate.exception.ConstraintViolationException:
	 */

	private static void persistUser() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setUserId(1);
		user.setName("J K");
		user.setEmailId("jk@mail.com");
		user.setContactNumber("28046746546");

		session.persist(user);

		System.out.println("User Persist Succussfully ...");

		transaction.commit();
		session.close();
	}

	/*
	 * session.save() method save object in database for given object id if same
	 * object with duplicate id then it Throws an Exception ::
	 * org.hibernate.exception.ConstraintViolationException:
	 */

	private static void saveUser() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setUserId(2);
		user.setName("John");
		user.setEmailId("john@mail.com");
		user.setContactNumber("28046746546");

		int userId = (int) session.save(user);

		System.out.println("User Save Succussfully with User Id " + userId);

		session.save(user);

		transaction.commit();
		session.close();
	}
	/*
	 * session.saveOrUpdate() method save object in database for given object id if
	 * same object with duplicate id then it update the object
	 */

	private static void saveOrUpdateUser() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setUserId(3);
		user.setName("John");
		user.setEmailId("john@mail.com");
		user.setContactNumber("280467465445");

		session.saveOrUpdate(user);

		System.out.println("User Save Succussfully ...");

		session.save(user);

		transaction.commit();
		session.close();
	}

	/*
	 * session.get() method return object for given object id if object not found in
	 * data base it return null;
	 */
	private static void getUser() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user1 = session.get(User.class, 1);

		System.out.println("User 1 ::" + user1);

		User user2 = session.get(User.class, 100);

		System.out.println("User 1 ::" + user2);

		transaction.commit();
		session.close();
	}

	/*
	 * session.load() method return object for given object id if object not found
	 * in data base it throw an Exception : org.hibernate.ObjectNotFoundException:
	 * No row with the given identifier exists: ;
	 */
	private static void loadUser() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user1 = session.load(User.class, 1);

		System.out.println("User 1 ::" + user1);

		try {
			User user2 = session.load(User.class, 100);
			System.out.println("User 1 ::" + user2);
		} catch (Exception e) {
			System.out.println("Error in find User :: " + e);
		}

		transaction.commit();
		session.close();
	}

	/*
	 * session.byId() method return object for given object id if object not found
	 * in data base it return null;
	 */

	private static void findUserById() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user1 = session.byId(User.class).load(1);

		System.out.println("User 1 ::" + user1);

		try {
			User user2 = session.byId(User.class).load(100);
			System.out.println("User 1 ::" + user2);
		} catch (Exception e) {
			System.out.println("Error in find User :: " + e);
		}

		transaction.commit();
		session.close();
	}

	private static void delete() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user1 = session.byId(User.class).load(1);
		System.out.println("User 1 ::" + user1);

		session.delete(user1);

		System.out.println("Object Deleted Succussfully ...");

		transaction.commit();
		session.close();
	}

	private static void refresh() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user1 = session.byId(User.class).load(3);
		System.out.println("User 1 ::" + user1);

		Work work = new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {

				PreparedStatement statement = connection
						.prepareStatement("Update hibernate5_user_list set name=? where user_id=?");

				statement.setString(1, "Johnson Legend");
				statement.setInt(2, 3);
				int count = statement.executeUpdate();
				System.out.println("Update Count : " + count);

			}
		};
		session.doWork(work);

		session.refresh(user1);
		System.out.println("User After Update  ::" + user1);

		System.out.println("Object Deleted Succussfully ...");

		transaction.commit();
		session.close();
	}

	private static void evict() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user1 = session.byId(User.class).load(3);
		System.out.println("User 1  :: I ::" + user1);

		System.out.println("------------------Without Calling Evict method ----------------------------");
		
		User user2 = session.byId(User.class).load(3);
		System.out.println("User 1 :: II ::" + user2);
		
		
        System.out.println("-----------------After Calling of Evict method-----------------------------");
		
        session.evict(user1);
		User user3 = session.byId(User.class).load(3);
		System.out.println("User 1 :: III ::" + user3);

		System.out.println("Object Deleted Succussfully ...");

		transaction.commit();
		session.close();
	}

}
