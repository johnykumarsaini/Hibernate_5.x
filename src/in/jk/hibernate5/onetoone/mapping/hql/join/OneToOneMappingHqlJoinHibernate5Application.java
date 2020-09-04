package in.jk.hibernate5.onetoone.mapping.hql.join;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class OneToOneMappingHqlJoinHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		
		//OneToOneMappingHqlJoinHibernate5Application.addStudent();
		OneToOneMappingHqlJoinHibernate5Application.findStudentById(1);
		OneToOneMappingHqlJoinHibernate5Application.findStudentDataById(1);

	}

	private static void addStudent() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Course course = new Course();
		course.setCourseId(1);
		course.setCourseName("Btech");
		course.setBranch("Computer Science");

		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("J K");
		student.setAddress("1205/Ghaziabad");
		student.setCourse(course);

		session.persist(student);

		transaction.commit();
		session.close();

		System.out.println("Student Data Persist Succussfully ..");

	}

	private static void findStudentById(int studentId) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String hqlQuery = "FROM Student student LEFT JOIN FETCH student.course WHERE student.studentId=:studentId";

		Query<Student> query = session.createQuery(hqlQuery, Student.class);
		query.setParameter("studentId", studentId);
		Student student = query.uniqueResult();
		System.out.println("student :: " + student);

		transaction.commit();
		session.close();

		System.out.println("Student Data Fetch Succussfully ..");

	}
	
	 private static void findStudentDataById(int studentId) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String hqlQuery = "SELECT student.studentId,student.studentName ,course.courseName FROM Student student LEFT JOIN  student.course course where student.studentId=:studentId";

		Query<Object[]> query = session.createQuery(hqlQuery);
		query.setParameter("studentId", studentId);
		Object[] student = query.uniqueResult();
		System.out.println("Student Id    :: " + student[0]);
		System.out.println("Student Name  :: " + student[1]);
		System.out.println("Student Course:: " + student[2]);

		transaction.commit();
		session.close();

		System.out.println("Student Data Fetch Succussfully ..");

	}

}
