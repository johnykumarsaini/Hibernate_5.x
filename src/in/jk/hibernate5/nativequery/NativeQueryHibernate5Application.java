package in.jk.hibernate5.nativequery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;

import in.jk.hibernate5.HibernateUtils;

public class NativeQueryHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		NativeQueryHibernate5Application.addfootWear();

		NativeQueryHibernate5Application.findfootWear();

	}

	private static void addfootWear() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		FootWear footWear1 = new FootWear();
		footWear1.setProductId(1);
		footWear1.setProductName("Sole Fury   ");
		footWear1.setCompany("Rebook");
		footWear1.setPrice(9999);

		FootWear footWear2 = new FootWear();
		footWear2.setProductId(2);
		footWear2.setProductName("Hexafect 5.0 ");
		footWear2.setCompany("Rebook");
		footWear2.setPrice(7999);

		FootWear footWear3 = new FootWear();
		footWear3.setProductId(3);
		footWear3.setProductName("Hexafect 4.0 ");
		footWear3.setCompany("Rebook");
		footWear3.setPrice(6999);

		session.persist(footWear1);
		session.persist(footWear2);
		session.persist(footWear3);

		transaction.commit();
		session.close();

		System.out.println("Footwear Added Succussfully ...");

	}

	private static void findfootWear() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String sqlQuery = "select product_id,product_name,company,price from hibernate5_footwear order by product_id asc";
		Query<Object[]> query = session.createNativeQuery(sqlQuery);

		List<Object[]> list = query.getResultList();

		System.out.println("Foot Wear List :: ");
		System.out.print("Product Id     Name          Company  Price ");
		System.out.println();

		for (Object[] objects : list) {

			System.out.println(objects[0] + "             " + objects[1] + "  " + objects[2] + "   " + objects[3]);

		}

		transaction.commit();
		session.close();
		System.out.println();
		System.out.println("Foot Wear Data Fetch Succussfully ...");

	}

}
