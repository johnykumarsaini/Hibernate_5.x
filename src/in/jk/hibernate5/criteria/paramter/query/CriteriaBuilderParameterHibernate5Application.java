package in.jk.hibernate5.criteria.paramter.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class CriteriaBuilderParameterHibernate5Application {
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		sessionFactory = HibernateUtils.buildSessionFactory();
		CriteriaBuilderParameterHibernate5Application.addCity();
		CriteriaBuilderParameterHibernate5Application.findCity();
	}
	
	private static void addCity() {
		
		Session session = sessionFactory.openSession();
		Transaction tranasction = session.beginTransaction();
		
		
		City city = new City();
		city.setCityId(1);
		city.setCityName("Ghaziabad");
		city.setState("Uttar Pradesh");
		city.setCountry("India");
		
		session.persist(city);
		
		tranasction.commit();
		session.close();
		
	}
	
private static void findCity() {
		
		Session session = sessionFactory.openSession();
		Transaction tranasction = session.beginTransaction();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<City> criteriaQuery = criteriaBuilder.createQuery(City.class);
		Root<City> root = criteriaQuery.from(City.class);

		ParameterExpression<String> parameterExpression = criteriaBuilder.parameter(String.class);
		
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("country"), parameterExpression));
		
		

		Query<City> query = session.createQuery(criteriaQuery);
		query.setParameter(parameterExpression, "India");

		City city = query.uniqueResult();
		System.out.println("City :: " + city);
		
		tranasction.commit();
		session.close();
		
	}

}
