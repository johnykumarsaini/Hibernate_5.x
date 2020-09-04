package in.jk.hibernate5.naturalid.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class NaturalIdHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		NaturalIdHibernate5Application.addProduct();
		NaturalIdHibernate5Application.findProductNaturalId();
		NaturalIdHibernate5Application.findProductSimpleNaturalId();
	}

	private static void findProductNaturalId() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Product product = session.byNaturalId(Product.class).using("serialNo", 1001).load();

		System.out.println("Product by Simple Natural Id :: " + product);
		
		transaction.commit();
		session.close();
	

	}

	
	private static void findProductSimpleNaturalId() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Product product = session.bySimpleNaturalId(Product.class).getReference(1001);

		System.out.println("Product by Simple Natural Id :: " + product);

		transaction.commit();
		session.close();
	

	}

	public static void addProduct() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Product product = new Product();
		product.setProductId(1);
		product.setName("Mobile");
		product.setSerialNo(1001);
		product.setPrice(1000);
		
		session.persist(product);

		System.out.println("Object Save Succussfully ...");

		transaction.commit();
		session.close();

	}

}
