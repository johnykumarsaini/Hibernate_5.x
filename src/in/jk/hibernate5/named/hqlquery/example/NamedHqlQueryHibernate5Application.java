package in.jk.hibernate5.named.hqlquery.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class NamedHqlQueryHibernate5Application {

	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Burger burger = new Burger();
		burger.setBurgerId(1);
		burger.setName("McDonalds");
		burger.setPrice(100);
		burger.setResturentLocation("Opulnet Mall Ghaziabad");

		//session.persist(burger);

		System.out.println("Burger added Succussfully  " + burger);

		transaction.commit();

		Transaction transaction2 = session.beginTransaction();

		Query<Burger> query = session.createNamedQuery("burgerQuery", Burger.class);

		query.setParameter("burgerId", 1);
		Burger burger1 = query.uniqueResult();

		System.out.println("Burged Id   :: " + burger1.getBurgerId());
		System.out.println("Burger Name :: " + burger1.getName());
		System.out.println("Burger price :: " + burger1.getPrice());
		System.out.println("Location     :: " + burger1.getResturentLocation());

		transaction.commit();

		session.close();

	}

}
