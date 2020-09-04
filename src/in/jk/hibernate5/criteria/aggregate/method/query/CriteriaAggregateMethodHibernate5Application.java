package in.jk.hibernate5.criteria.aggregate.method.query;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.jk.hibernate5.HibernateUtils;

public class CriteriaAggregateMethodHibernate5Application {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = HibernateUtils.buildSessionFactory();
		
		//CriteriaAggregateMethodHibernate5Application.addEmployee();
		CriteriaAggregateMethodHibernate5Application.findEmployeeCount();
		CriteriaAggregateMethodHibernate5Application.findEmployeeMaxSalary();
		CriteriaAggregateMethodHibernate5Application.findEmployeeSalarySum();
		CriteriaAggregateMethodHibernate5Application.findEmployeeSalary();
		CriteriaAggregateMethodHibernate5Application.findEmployeeSalaryUsingBetween();
		CriteriaAggregateMethodHibernate5Application.findEmployeeByNameLikeMethod();
		CriteriaAggregateMethodHibernate5Application.findEmployeeByAndMethod();
	}

	private static void addEmployee() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee1 = new Employee();
		employee1.setEmpId(1);
		employee1.setName("J K");
		employee1.setCompany("Google");
		employee1.setSalary(1000);

		Employee employee2 = new Employee();
		employee2.setEmpId(2);
		employee2.setName("Johny");
		employee2.setCompany("Alphabet");
		employee2.setSalary(2000);

		Employee employee3 = new Employee();
		employee3.setEmpId(3);
		employee3.setName("Johny Kumar");
		employee3.setCompany("Amazon");
		employee3.setSalary(3000);

		Employee employee4 = new Employee();
		employee4.setEmpId(4);
		employee4.setName("Johny");
		employee4.setCompany("Dell");
		employee4.setSalary(4000);

		Employee employee5 = new Employee();
		employee5.setEmpId(5);
		employee5.setName("John");
		employee5.setCompany("Youtube");
		employee5.setSalary(5000);

		session.persist(employee1);
		session.persist(employee2);
		session.persist(employee3);
		session.persist(employee4);
		session.persist(employee5);

		transaction.commit();
		session.close();
		System.out.println("Employee Added Succussfully ...");
	}

	private static void findEmployeeCount() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		criteriaQuery.select(criteriaBuilder.count(root));

		Query<Long> query = session.createQuery(criteriaQuery);

		Long employeeCount = query.uniqueResult();
		System.out.println("Employee Count :: " + employeeCount);

		transaction.commit();
		session.close();
		System.out.println("Employee Fetch Succussfully ...");

	}

	private static void findEmployeeMaxSalary() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		criteriaQuery.select(criteriaBuilder.max(root.get("salary")));

		Query<Integer> query = session.createQuery(criteriaQuery);

		Integer maxSalary = query.uniqueResult();
		System.out.println("Employee Max Salary :: " + maxSalary);

		transaction.commit();
		session.close();
		System.out.println("Employee Data Fetch Succussfully ...");

	}

	private static void findEmployeeSalarySum() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		criteriaQuery.select(criteriaBuilder.sum(root.get("salary")));

		Query<Integer> query = session.createQuery(criteriaQuery);

		Integer salarySum = query.uniqueResult();
		System.out.println("Employee  Salary Sum:: " + salarySum);

		transaction.commit();
		session.close();
		System.out.println("Employee Data Fetch Succussfully ...");

	}
	
	
	private static void findEmployeeSalary() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		criteriaQuery.select(root).where(criteriaBuilder.lessThan(root.get("salary"),4000));

		Query<Employee> query = session.createQuery(criteriaQuery);

		List<Employee> employeeList = query.getResultList();
		System.out.println("Employee List of Salary  less then 4000 :: ");
		
		employeeList.forEach(System.out::println);

		transaction.commit();
		session.close();
		System.out.println("Employee Data Fetch Succussfully ...");

	}
	
	
	private static void findEmployeeSalaryUsingBetween() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		criteriaQuery.select(root).where(criteriaBuilder.between(root.get("salary"),2000,4000));

		Query<Employee> query = session.createQuery(criteriaQuery);

		List<Employee> employeeList = query.getResultList();
		System.out.println("Employee List  of Salary Between 2000 to 4000 :: ");
		
		employeeList.forEach(System.out::println);

		transaction.commit();
		session.close();
		System.out.println("Employee Data Fetch Succussfully ...");

	}
	
	
	private static void findEmployeeByNameLikeMethod() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"),"John"));

		Query<Employee> query = session.createQuery(criteriaQuery);

		List<Employee> employeeList = query.getResultList();
		System.out.println("Employee List  of Name like John :: ");
		
		employeeList.forEach(System.out::println);

		transaction.commit();
		session.close();
		System.out.println("Employee Data Fetch Succussfully ...");

	}
	
	
	private static void findEmployeeByAndMethod() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		Predicate nameRestriction = criteriaBuilder.equal(root.get("name"), "Johny");
		Predicate salaryRestriction = criteriaBuilder.lessThan(root.get("salary"), 4000);

		
		criteriaQuery.select(root).where(criteriaBuilder.and(nameRestriction,salaryRestriction));

		Query<Employee> query = session.createQuery(criteriaQuery);

		List<Employee> employeeList = query.getResultList();
		System.out.println("Employee List  :: ");
		
		employeeList.forEach(System.out::println);

		transaction.commit();
		session.close();
		System.out.println("Employee Data Fetch Succussfully ...");

	}
}
