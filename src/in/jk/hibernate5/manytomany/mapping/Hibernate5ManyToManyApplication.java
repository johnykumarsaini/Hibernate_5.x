package in.jk.hibernate5.manytomany.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jk.hibernate5.HibernateUtils;

public class Hibernate5ManyToManyApplication {

	public static void main(String[] args) {

		Session session = HibernateUtils.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setName("J K");
		employee.setCompany("Google");

		Employee employee1 = new Employee();
		employee1.setEmpId(2);
		employee1.setName("J K");
		employee1.setCompany("Tesla");

		Address address = new Address();
		address.setAddressId(1);
		address.setStreet("1205");
		address.setCity("GZB");

		Address address1 = new Address();
		address1.setAddressId(2);
		address1.setStreet("44/45");
		address1.setCity("Neveda");

		Address address2 = new Address();
		address2.setAddressId(3);
		address2.setStreet("10");
		address2.setCity("California");

		List<Employee> employees = new ArrayList<Employee>();

		employees.add(employee);
		employees.add(employee1);

		List<Address> addressList = new ArrayList<Address>();

		addressList.add(address);
		addressList.add(address1);
		addressList.add(address2);

		employee.setAddresses(addressList);
		employee1.setAddresses(addressList);

		address.setEmployees(employees);
		address1.setEmployees(employees);

		session.persist(employee);
		session.persist(employee1);

		transaction.commit();
		session.close();
		
		Session session2 = HibernateUtils.buildSessionFactory().openSession();
		System.out.println("Data Saved Succussfully...");

		Transaction transaction2 = session2.beginTransaction();

		Employee employee2 = session2.get(Employee.class, 1);

		System.out.println("Employee 1 :: " + employee2);

		Employee employee3 = session2.get(Employee.class, 2);
		System.out.println(employee3);

		System.out.println("Employee 2 :: " + employee3);

		transaction2.commit();

		session2.close();

	}

}
