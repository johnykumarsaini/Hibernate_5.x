package in.jk.hibernate5.criteria.join.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class CriteriaQueryJoinHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		//CriteriaQueryJoinHibernate5Application.addPassengerWithTicket();
		CriteriaQueryJoinHibernate5Application.findPassengerWithTicket();
		CriteriaQueryJoinHibernate5Application.findPassengerWithTicketEgaerFecth();

	}

	private static void addPassengerWithTicket() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Passenger passenger = new Passenger();
		passenger.setPassengerId(1);
		passenger.setName("J K");
		passenger.setAge(30);

		Ticket ticket = new Ticket();
		ticket.setTicketId(2);
		ticket.setStartStation("Ghaziabad Junction");
		ticket.setDestinationStation("Tilak Bridge Junction");
		ticket.setPrice(10);

		passenger.setTicket(ticket);
		session.persist(passenger);

		transaction.commit();
		session.close();

		System.out.println("Ticket Added Succusslly");

	}

	private static void findPassengerWithTicket() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Passenger> criteriaQuery = criteriaBuilder.createQuery(Passenger.class);
		Root<Passenger> root = criteriaQuery.from(Passenger.class);

		root.join("ticket");
		criteriaQuery.select(root);

		//criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("passengerId"), 1));

		Query<Passenger> query = session.createQuery(criteriaQuery);

		Passenger passenger = query.uniqueResult();
		
		System.out.println("Passenger Info :: "+passenger);
		System.out.println("Passenger Ticket :: ");
		System.out.println(passenger.getTicket());

        transaction.commit();
		session.close();

		System.out.println("Ticket Fetch Succusslly");

	}
	
	

	private static void findPassengerWithTicketEgaerFecth() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Passenger> criteriaQuery = criteriaBuilder.createQuery(Passenger.class);
		Root<Passenger> root = criteriaQuery.from(Passenger.class);

		criteriaQuery.select(root);
		root.fetch("ticket"); //eager fecth

		Query<Passenger> query = session.createQuery(criteriaQuery);

		Passenger passenger = query.uniqueResult();
		
		System.out.println("Passenger Info :: "+passenger);
		System.out.println("Passenger Ticket :: ");
		System.out.println(passenger.getTicket());

        transaction.commit();
		session.close();

		System.out.println("Ticket Fetch Succusslly");

	}

}
