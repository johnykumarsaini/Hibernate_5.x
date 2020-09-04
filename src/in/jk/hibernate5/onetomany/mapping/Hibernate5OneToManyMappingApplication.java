package in.jk.hibernate5.onetomany.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5OneToManyMappingApplication {

	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Developer developer = new Developer();
		developer.setDeveloperId(1);
		developer.setName("J K");
		developer.setCompany("Google");

		Language language = new Language();
		language.setLanguageId(1);
		language.setName("Java");

		Language language2 = new Language();
		language2.setLanguageId(2);
		language2.setName("Kotlin");

		List<Language> languages = new ArrayList<Language>();
		languages.add(language);
		languages.add(language2);

		developer.setLanguages(languages);
        session.save(developer);
        System.out.println("Developer Saved Successfully ...");
		transaction.commit();

		Transaction transaction2 = session.beginTransaction();
        Developer developer2 = session.get(Developer.class, 1);
        System.out.println("Developer :: " + developer2);
        transaction2.commit();

		session.close();

	}

}
