package in.jk.hibernate5.criteria.api.query;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import hibernate5.dto.MensWearDTO;
import in.jk.hibernate5.HibernateUtils;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class CriteriaQueryWithDTOHibernate5Application {

	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("--------");
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<MensWearDTO> criteriaQuery = criteriaBuilder.createQuery(MensWearDTO.class);
		System.out.println("--------");
		Root<MensWear> root = criteriaQuery.from(MensWear.class);

		Path<Object> productId = root.get("productId");
		Path<Object> productName = root.get("productName");

		Path<Object> productType = root.get("productType");
		Path<Object> comapny = root.get("company");
		Path<Object> price = root.get("price");
		System.out.println("--------");
		criteriaQuery.select(
				criteriaBuilder.construct(MensWearDTO.class, productId, productName, comapny, productType, price));
		System.out.println("--------4");

		Query<MensWearDTO> query = session.createQuery(criteriaQuery);

		System.out.println("--------5");
		List<MensWearDTO> mensWearDTOs = query.getResultList();
		System.out.println("All Product List :: ");
		mensWearDTOs.forEach(System.out::println);

		transaction.commit();
		session.close();
	}

}
