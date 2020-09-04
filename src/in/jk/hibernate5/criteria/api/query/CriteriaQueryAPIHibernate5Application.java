package in.jk.hibernate5.criteria.api.query;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class CriteriaQueryAPIHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		CriteriaQueryAPIHibernate5Application.addProduct();
		CriteriaQueryAPIHibernate5Application.findProdcutById();
		CriteriaQueryAPIHibernate5Application.findProdcutName();
		CriteriaQueryAPIHibernate5Application.findProdcutNameAndCompany();
		CriteriaQueryAPIHibernate5Application.findProdcutDataWithMultiSelect();
		CriteriaQueryAPIHibernate5Application.findAllProdcut();

	}

	private static void addProduct() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		MensWear mensWear1 = new MensWear();
		mensWear1.setProductId(1);
		mensWear1.setProductName("Active Chill");
		mensWear1.setCompany("Reebok");
		mensWear1.setProductType("T-Shirts");
		mensWear1.setPrice("2300");

		MensWear mensWear2 = new MensWear();
		mensWear2.setProductId(2);
		mensWear2.setProductName("Sweet Animal");
		mensWear2.setCompany("Reebok");
		mensWear2.setProductType("T-Shirts");
		mensWear2.setPrice("1799");

		MensWear mensWear3 = new MensWear();
		mensWear3.setProductId(3);
		mensWear3.setProductName("Addidas ZNE");
		mensWear3.setCompany("Addidas");
		mensWear3.setProductType("Hoody");
		mensWear3.setPrice("6999");

		MensWear mensWear4 = new MensWear();
		mensWear4.setProductId(4);
		mensWear4.setProductName("Skull Cap");
		mensWear4.setCompany("Reebok");
		mensWear4.setProductType("Cap");
		mensWear4.setPrice("1499");

		session.persist(mensWear1);
		session.persist(mensWear2);
		session.persist(mensWear3);
		session.persist(mensWear4);

		transaction.commit();
		session.close();

		System.out.println("Mens Wear Prodcut add Succussfully ...");
	}

	private static void findProdcutById() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<MensWear> criteriaQuery = criteriaBuilder.createQuery(MensWear.class);
		Root<MensWear> root = criteriaQuery.from(MensWear.class);

		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("productId"), 1));

		Query<MensWear> query = session.createQuery(criteriaQuery);

		MensWear mensWear = query.uniqueResult();
		System.out.println("MensWear :: " + mensWear);

		transaction.commit();
		session.close();
	}

	

	private static void findProdcutName() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<MensWear> root = criteriaQuery.from(MensWear.class);

		criteriaQuery.select(root.get("productName"));

		Query<String> query = session.createQuery(criteriaQuery);

		System.out.println("MensWear Product Name :: ");

		query.list().forEach(System.out::println);

		transaction.commit();
		session.close();
	}
	
	private static void findProdcutNameAndCompany() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<MensWear> root = criteriaQuery.from(MensWear.class);
		
		Path<Object> prdouctName = root.get("productName");
		Path<Object> company = root.get("company");

		criteriaQuery.select(criteriaBuilder.array(prdouctName,company));
		

		Query<Object[]> query = session.createQuery(criteriaQuery);

		System.out.println("MensWear Product Name  :: ");

		query.list().forEach(product->{
			
			System.out.println("Name    ::  "+product[0]);
			System.out.println("Comapny ::   "+product[1]);
		});

		System.out.println();
		transaction.commit();
		session.close();
	}
	
	private static void findProdcutDataWithMultiSelect() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<MensWear> root = criteriaQuery.from(MensWear.class);
		
		Path<Object> prdouctName = root.get("productName");
		Path<Object> company = root.get("company");
		Path<Object> price = root.get("price");

		criteriaQuery.multiselect(prdouctName,company,price);
		

		Query<Object[]> query = session.createQuery(criteriaQuery);

		System.out.println("MensWear Product Name  :: ");

		query.list().forEach(product->{
			
			System.out.println("Name    ::  "+product[0]);
			System.out.println("Comapny ::   "+product[1]);
			System.out.println("Price   ::   "+product[2]);
		});

		System.out.println();
		transaction.commit();
		session.close();
	}

	private static void findAllProdcut() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<MensWear> criteriaQuery = criteriaBuilder.createQuery(MensWear.class);
		Root<MensWear> root = criteriaQuery.from(MensWear.class);

		criteriaQuery.select(root);

		Query<MensWear> query = session.createQuery(criteriaQuery);

		List<MensWear> mensWears = query.getResultList();
		System.out.println("All MensWear Product :: ");
		mensWears.forEach(System.out::println);

		transaction.commit();
		session.close();
	}

}
