package in.jk.hibernate5.criteria.using.clause.query;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class CriteriaQueryWithClauseHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory =  HibernateUtils.buildSessionFactory();

		CriteriaQueryWithClauseHibernate5Application.addPlayer();
		CriteriaQueryWithClauseHibernate5Application.findPlayer();
		CriteriaQueryWithClauseHibernate5Application.findPlayerGroupByAndHavingClause();
		CriteriaQueryWithClauseHibernate5Application.findPlayerOrderByClause();

	}

	public static void findPlayer() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<Player> root = criteriaQuery.from(Player.class);

		criteriaQuery.multiselect(criteriaBuilder.count(root.get("playerId")), root.get("country"),
				root.get("countryCode"));
		criteriaQuery.groupBy(root.get("country"), root.get("countryCode"));

		Query<Object[]> query = session.createQuery(criteriaQuery);

		List<Object[]> objects = query.getResultList();
		System.out.println("Player no" + "      " + "Country" + "        " + "Country Code ");

		for (Object[] object : objects) {

			System.out.println(object[0] + "            " + object[1] + "     " + object[2]);

		}

		transaction.commit();
		session.close();
	}

	public static void findPlayerGroupByAndHavingClause() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<Player> root = criteriaQuery.from(Player.class);

		criteriaQuery.multiselect(criteriaBuilder.count(root.get("playerId")), root.get("country"),
				root.get("countryCode"));
		criteriaQuery.groupBy(root.get("country"), root.get("countryCode"));

		criteriaQuery.having(criteriaBuilder.greaterThan(root.get("countryCode"), 3));

		Query<Object[]> query = session.createQuery(criteriaQuery);

		List<Object[]> objects = query.getResultList();
		System.out.println("Player List Havig Country Code >3");
		System.out.println("Player no" + "      " + "Country" + "        " + "Country Code ");

		for (Object[] object : objects) {

			System.out.println(object[0] + "            " + object[1] + "     " + object[2]);

		}

		transaction.commit();
		session.close();
	}

	public static void findPlayerOrderByClause() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Player> criteriaQuery = criteriaBuilder.createQuery(Player.class);
		Root<Player> root = criteriaQuery.from(Player.class);

		criteriaQuery.orderBy(criteriaBuilder.desc(root.get("playerId")));

		Query<Player> query = session.createQuery(criteriaQuery);

		List<Player> objects = query.getResultList();

		System.out.println("Player no" + "      " + "Country" + "        " + "Country Code ");

		for (Player object : objects) {

			System.out.println(object);

		}

		transaction.commit();
		session.close();
	}

	public static void addPlayer() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Player player1 = new Player();
		player1.setPlayerId(1);
		player1.setPalyerName("Virat Kohli");
		player1.setCountry("India");
		player1.setCountryCode(1);

		Player player2 = new Player();
		player2.setPlayerId(2);
		player2.setPalyerName("David Warner");
		player2.setCountry("Australia");
		player2.setCountryCode(2);

		Player player3 = new Player();
		player3.setPlayerId(3);
		player3.setPalyerName("Pat Cummins");
		player3.setCountry("Australia");
		player3.setCountryCode(2);

		Player player4 = new Player();
		player4.setPlayerId(4);
		player4.setPalyerName("Cagiso Rabada");
		player4.setCountry("South Africa");
		player4.setCountryCode(3);

		Player player5 = new Player();
		player5.setPlayerId(5);
		player5.setPalyerName("David Miller");
		player5.setCountry("South Africa");
		player5.setCountryCode(3);

		Player player6 = new Player();
		player6.setPlayerId(6);
		player6.setPalyerName("Joe Root");
		player6.setCountry("England");
		player6.setCountryCode(4);

		Player player7 = new Player();
		player7.setPlayerId(7);
		player7.setPalyerName("James Anderson");
		player7.setCountry("England");
		player7.setCountryCode(4);

		Player player8 = new Player();
		player8.setPlayerId(8);
		player8.setPalyerName("Jony Bairstow");
		player8.setCountry("England");
		player8.setCountryCode(4);

		Player player9 = new Player();
		player9.setPlayerId(9);
		player9.setPalyerName("Josh Buttler");
		player9.setCountry("England");
		player9.setCountryCode(4);

		Player player10 = new Player();
		player10.setPlayerId(10);
		player10.setPalyerName("Eon Morgan");
		player10.setCountry("England/IreLand");
		player10.setCountryCode(4);

		Player player11 = new Player();
		player11.setPlayerId(11);
		player11.setPalyerName("Ros Taylor");
		player11.setCountry("New Zewland");
		player11.setCountryCode(5);

		Player player12 = new Player();
		player12.setPlayerId(12);
		player12.setPalyerName("Martin Guptil");
		player12.setCountry("New Zewland");
		player12.setCountryCode(5);

		Player player13 = new Player();
		player13.setPlayerId(13);
		player13.setPalyerName("Tim Southee");
		player13.setCountry("New Zewland");
		player13.setCountryCode(5);

		Player player14 = new Player();
		player14.setPlayerId(14);
		player14.setPalyerName("Sunil Naraine");
		player14.setCountry("West Indies");
		player14.setCountryCode(6);

		Player player15 = new Player();
		player15.setPlayerId(15);
		player15.setPalyerName("Kiron Polard");
		player15.setCountry("West Indies");
		player15.setCountryCode(6);

		Player player16 = new Player();
		player16.setPlayerId(16);
		player16.setPalyerName("Jason Holder");
		player16.setCountry("West Indies");
		player16.setCountryCode(6);

		Player player17 = new Player();
		player17.setPlayerId(17);
		player17.setPalyerName("Sakib Al Hasan");
		player17.setCountry("Bangladesh");
		player17.setCountryCode(7);

		Player player18 = new Player();
		player18.setPlayerId(18);
		player18.setPalyerName("Mustaza fir Rehamaan");
		player18.setCountry("Bangladesh");
		player18.setCountryCode(7);

		session.persist(player1);
		session.persist(player2);
		session.persist(player3);
		session.persist(player4);
		session.persist(player5);
		session.persist(player6);

		session.persist(player7);
		session.persist(player8);
		session.persist(player9);
		session.persist(player10);
		session.persist(player11);
		session.persist(player12);

		session.persist(player13);
		session.persist(player14);
		session.persist(player15);
		session.persist(player16);
		session.persist(player17);
		session.persist(player18);

		transaction.commit();
		session.close();

		System.out.println("Palyer Added Succussfully ...");

	}

}
