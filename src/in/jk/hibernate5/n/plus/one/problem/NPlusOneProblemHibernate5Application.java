package in.jk.hibernate5.n.plus.one.problem;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class NPlusOneProblemHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		
		//NPlusOneProblemHibernate5Application.addProgramer();
		System.out.println("------------- N+1 Problem ------------------");
		NPlusOneProblemHibernate5Application.nPlusProblem();;
		System.out.println("--------------Solution of N+1 Problem By Join Fetch-----------------");
		NPlusOneProblemHibernate5Application.JoinFetchWithQuery();;
		System.out.println("---------------Solution of N+1 Problem By Criteria Join Fetch----------------");
		NPlusOneProblemHibernate5Application.JoinFetchWithCriteriaQuery();;
		System.out.println("-------------------------------");
		

	}

	private static void addProgramer() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		JavaProgramer javaProgramer = new JavaProgramer();
		javaProgramer.setProgrmerId(1);
		javaProgramer.setName("J K");
		javaProgramer.setComapny("Google");

		TechnicalSkill skill = new TechnicalSkill();
		skill.setSkillId(1);
		skill.setName("Java");

		TechnicalSkill skill2 = new TechnicalSkill();
		skill2.setSkillId(2);
		skill2.setName("Servlet");

		TechnicalSkill skill3 = new TechnicalSkill();
		skill3.setSkillId(3);
		skill3.setName("JSP");

		TechnicalSkill skill4 = new TechnicalSkill();
		skill4.setSkillId(4);
		skill4.setName("Spring");

		TechnicalSkill skill5 = new TechnicalSkill();
		skill5.setSkillId(5);
		skill5.setName("Hibernate");

		List<TechnicalSkill> technicalSkills = new ArrayList<TechnicalSkill>();
		technicalSkills.add(skill);
		technicalSkills.add(skill2);
		technicalSkills.add(skill3);
		technicalSkills.add(skill4);
		technicalSkills.add(skill5);

		javaProgramer.setTechnicalSkill(technicalSkills);
		
		session.persist(javaProgramer);

		transaction.commit();

		session.close();

		System.out.println("Programer details added ....");
	}

	private static void nPlusProblem() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String hqlQuery = "FROM JavaProgramer ";

		Query<JavaProgramer> query = session.createQuery(hqlQuery, JavaProgramer.class);

		List<JavaProgramer> javaProgramers = query.getResultList();
		for (JavaProgramer javaProgramer : javaProgramers) {

			System.out.println("Java Programer :: " + javaProgramer);
			System.out.println("Technical Skill :: ");

			System.out.println(javaProgramer.getTechnicalSkill());

		}

		transaction.commit();

		session.close();

		System.out.println("Programer details  ....");
	}

	private static void JoinFetchWithQuery() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String hqlQuery = "FROM JavaProgramer programer JOIN FETCH programer.technicalSkill ";

		Query<JavaProgramer> query = session.createQuery(hqlQuery, JavaProgramer.class);

		List<JavaProgramer> javaProgramers = query.getResultList();
		System.out.println("Java Progrmaer List Size  "+javaProgramers.size());
		for (JavaProgramer javaProgramer : javaProgramers) {

			System.out.println("Java Programer :: " + javaProgramer);
			System.out.println("Technical Skill :: ");

			System.out.println(javaProgramer.getTechnicalSkill());

		}

		transaction.commit();

		session.close();

		System.out.println("Programer details  ....");
	}

	private static void JoinFetchWithCriteriaQuery() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<JavaProgramer> criteriaQuery = criteriaBuilder.createQuery(JavaProgramer.class);
		Root<JavaProgramer> root = criteriaQuery.from(JavaProgramer.class);

		root.fetch("technicalSkill", JoinType.LEFT);
		
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("progrmerId"), 1));

		Query<JavaProgramer> query = session.createQuery(criteriaQuery);

		List<JavaProgramer> javaProgramers = query.getResultList();
		for (JavaProgramer javaProgramer : javaProgramers) {

			System.out.println("Java Programer :: " + javaProgramer);
			System.out.println("Technical Skill :: ");

			System.out.println(javaProgramer.getTechnicalSkill());

		}

		transaction.commit();

		session.close();

		System.out.println("Programer details  ....");
	}

}
