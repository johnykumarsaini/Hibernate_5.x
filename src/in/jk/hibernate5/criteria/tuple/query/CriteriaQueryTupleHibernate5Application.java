package in.jk.hibernate5.criteria.tuple.query;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class CriteriaQueryTupleHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		CriteriaQueryTupleHibernate5Application.addBeverage();
		CriteriaQueryTupleHibernate5Application.findAllBeverage();
	}

	private static void addBeverage() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Beverage bevarage1 = new Beverage();
		bevarage1.setBeverageId(1);
		bevarage1.setName("Thumbs Up");
		bevarage1.setPrice("20");

		Beverage bevarage2 = new Beverage();
		bevarage2.setBeverageId(2);
		bevarage2.setName("Frooti");
		bevarage2.setPrice("20");

		Beverage bevarage3 = new Beverage();
		bevarage3.setBeverageId(3);
		bevarage3.setName("Sprite");
		bevarage3.setPrice("20");

		Beverage bevarage4 = new Beverage();
		bevarage4.setBeverageId(4);
		bevarage4.setName("Mazza");
		bevarage4.setPrice("20");

		session.persist(bevarage1);
		session.persist(bevarage2);
		session.persist(bevarage3);
		session.persist(bevarage4);

		transaction.commit();
		session.close();

		System.out.println("Beverage Data Added Succussfully ....");
	}

	private static void findAllBeverage() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Beverage> root = criteriaQuery.from(Beverage.class);

		Path<Object> beveragePath = root.get("beverageId");
		Path<Object> beverageNamePath = root.get("name");
		Path<Object> beveragePricePath = root.get("price");

		criteriaQuery.multiselect(beveragePath, beverageNamePath, beveragePricePath);

		Query<Tuple> query = session.createQuery(criteriaQuery);

		List<Tuple> tuples = query.getResultList();

		for (Tuple tuple : tuples) {

			System.out.println("Beverage Id    : " + tuple.get(beveragePath));
			System.out.println("Beverage Name  : " + tuple.get(beverageNamePath));
			System.out.println("Beverage price : " + tuple.get(beveragePricePath));

		}

		transaction.commit();
		session.close();

		System.out.println("Beverage Data Fetch Succussfully ....");
	}

}
