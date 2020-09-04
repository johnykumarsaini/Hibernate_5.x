package in.jk.hibernate5.defualtcolumn.value.example;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class DefultColumnValueHibernate5Application {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setStudentId(4);
		student.setName("J K");
		student.setAdmissionDate(new Date());
		
	//	session.persist(student);
		
		System.out.println("Student added Succussully...");
		
	
		Student student2 = session.get(Student.class, 4);
		
		System.out.println("Student :: "+student2);
		
		transaction.commit();
		session.close();
				
		
	}

}
