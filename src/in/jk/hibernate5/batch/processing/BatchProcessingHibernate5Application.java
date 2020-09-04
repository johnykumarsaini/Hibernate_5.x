package in.jk.hibernate5.batch.processing;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class BatchProcessingHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();

		BatchProcessingHibernate5Application.batchInsert();

		BatchProcessingHibernate5Application.batchUpdate();

	}

	private static void batchInsert() {

		Session session = sessionFactory.openSession();

		session.setJdbcBatchSize(5);
		// session.setHibernateFlushMode(FlushMode.AUTO);
		Transaction transaction = session.beginTransaction();
		int batchSize = 5;

		for (int i = 1; i <= 100; i++) {

			MovieTicket movieTicket = new MovieTicket();
			movieTicket.setTicketId(i);
			movieTicket.setMovieName("Transformer");
			movieTicket.setMovieShowTime(new Date());
			movieTicket.setPrice(100);
			System.out.println("" + movieTicket);
			session.save(movieTicket);

			if (i > 0 && i % batchSize == 0) {

				session.flush();
				session.clear();

				System.out.println("--->" + i);
			}

		}

		transaction.commit();
		session.close();

		System.out.println("All Movie Tickets are added ....");

	}

	private static void batchUpdate() {

		Session session = sessionFactory.openSession();

		session.setJdbcBatchSize(5);
		// session.setHibernateFlushMode(FlushMode.AUTO);
		Transaction transaction = session.beginTransaction();
		int batchSize = 5;
		int incrementPrice=50;

		for (int i = 1; i <= 100; i++) {

			MovieTicket movieTicket = new MovieTicket();
			movieTicket.setTicketId(i);
			movieTicket.setMovieName("Transformer");
			movieTicket.setMovieShowTime(new Date());
			movieTicket.setPrice(100+incrementPrice);
			System.out.println("" + movieTicket);
			session.update(movieTicket);

			if (i > 0 && i % batchSize == 0) {

				session.flush();
				session.clear();

				
			}

		}

		transaction.commit();
		
		session.createQuery("FROM MovieTicket").list().forEach(System.out::println);
		
		session.close();
		
		

		System.out.println("All Movie Tickets price updated with 50 RS are added ....");

	}

}
