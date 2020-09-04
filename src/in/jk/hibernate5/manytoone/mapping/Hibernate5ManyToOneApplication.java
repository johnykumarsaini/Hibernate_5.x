package in.jk.hibernate5.manytoone.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5ManyToOneApplication {

	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		
		JavaDeveloper javaDeveloper = new  JavaDeveloper();
		javaDeveloper.setJavaDeveloperId(1);
		javaDeveloper.setDeveloperName("J K");
		javaDeveloper.setCompany("Google");
		
		JavaFramework framework = new JavaFramework();
		framework.setFrameworkId(1);
		framework.setName("Spring");
		framework.setJavaDeveloper(javaDeveloper);
		JavaFramework framework1 = new JavaFramework();
		framework1.setFrameworkId(2);
		framework1.setName("Hibernate");
		framework1.setJavaDeveloper(javaDeveloper);
        JavaFramework framework2 = new JavaFramework();
        framework2.setFrameworkId(3);
		framework2.setName("Struts");
		framework2.setJavaDeveloper(javaDeveloper);
		
		//session.save(framework);
		//session.save(framework1);
		//session.save(framework2);


		transaction.commit();
		
		System.out.println("Data Saved Succussuuly ...");

		Transaction transaction2 = session.beginTransaction();
		
		JavaFramework developer = session.get(JavaFramework.class, 1);

		
		//JavaDeveloper developer = session.get(JavaDeveloper.class, 1);
		System.out.println("Java Developer with Framework :: ");
		System.out.println(developer);
		//System.out.println(developer.getJavaFramework());
		

		transaction2.commit();

		session.close();

	}

}
