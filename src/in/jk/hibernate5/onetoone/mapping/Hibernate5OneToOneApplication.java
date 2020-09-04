package in.jk.hibernate5.onetoone.mapping;

import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5OneToOneApplication {

	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setUserId(1);
		user.setName("J K");
		user.setEmail("jk@gmail.com");

		Address address = new Address();
		address.setAddressId(1);
		address.setStreet("1205");
		address.setCity("GZB");

		user.setAddress(address);

		session.persist(user);

		transaction.commit();
	

		System.out.println("Data Persist Succussfully ....");
		Transaction transaction1 = session.beginTransaction();
		
		User  user2 = session.get(User.class, 1);
		
		System.out.println("User :: "+user2);
		
		transaction1.commit();
		session.close();

	}

}
