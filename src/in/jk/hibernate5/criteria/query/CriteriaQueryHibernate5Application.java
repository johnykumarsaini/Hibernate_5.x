package in.jk.hibernate5.criteria.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class CriteriaQueryHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		CriteriaQueryHibernate5Application.addPerson();
		CriteriaQueryHibernate5Application.findPerson();

	}

	private static void addPerson() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = new Person();
		person.setPersonId(1);
		person.setPersonName("J K");
		person.setMobileNumber("7827694252");
		person.setGender("Male");

		session.persist(person);

		transaction.commit();
		session.close();
	}

	private static void findPerson() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);

		criteriaQuery.select(root);

		Query<Person> query = session.createQuery(criteriaQuery);

		Person person = query.uniqueResult();
		System.out.println("Person :: " + person);

		transaction.commit();
		session.close();
	}

}
