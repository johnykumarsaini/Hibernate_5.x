package in.jk.hibernate5.collection.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5CollectionMappingApplication {
	
	public static void main(String[] args) {
		
		
		Session session = HibernateUtils.buildSessionFactory().openSession();
		
		Transaction  transaction = session.beginTransaction();
		Developer developer =new Developer();
		developer.setDeveloperId(1);
		developer.setName("J K");
		developer.setCompany("Google ");
		
		
		Language language = new  Language();
		language.setLanguageId(1);
		language.setName("Java");
		
		Language language1 = new  Language();
		language1.setLanguageId(2);
		language1.setName("Kotlin");
		
		developer.getLanguages().add(language);
		developer.getLanguages().add(language1);
		
		session.persist(developer);
		transaction.commit();
		session.close();
		
		System.out.println("Data Saved Successfully....");

		
	}

}
