package in.jk.hibernate5;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import in.jk.hibernate5.example.Employee;
import in.jk.hibernate5.onetoone.mapping.Address;
import in.jk.hibernate5.onetoone.mapping.User;

public class HibernateUtils {

	private static StandardServiceRegistry standardServiceRegistry = null;
	private static SessionFactory sessionFactory = null;

	// SessionFactory using java Hibernate.cfg.xml
	static {

		standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources metadataSource = new MetadataSources(standardServiceRegistry);
		Metadata metadata = metadataSource.getMetadataBuilder().build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

	// SessionFactory using java config
	public static SessionFactory buildSessionFactory() {

		// Session Factory Service To Config and Integrate Hibernate Listener
		// BootstrapServiceRegistry bootstrapServiceRegistry = new
		// BootstrapServiceRegistryBuilder()
		// .applyIntegrator(new HibernateEventListnerIntergarator()).build();
		// StandardServiceRegistryBuilder serviceRegistryBuilder = new
		// StandardServiceRegistryBuilder(bootstrapServiceRegistry);

		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		Map<String, String> hibernateProperties = new HashMap<String, String>();

		hibernateProperties.put(Environment.DRIVER, "org.postgresql.Driver");
		hibernateProperties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
		hibernateProperties.put(Environment.USER, "postgres");
		hibernateProperties.put(Environment.PASS, "jk123");
		hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		hibernateProperties.put(Environment.SHOW_SQL, "true");
		hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");

		// Second Level Cache Config
		hibernateProperties.put(Environment.USE_SECOND_LEVEL_CACHE, Boolean.toString(Boolean.TRUE));
		hibernateProperties.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		hibernateProperties.put(Environment.CACHE_PROVIDER_CONFIG, "net.sf.ehcache.hibernate.EhCacheProvider");

		serviceRegistryBuilder.applySettings(hibernateProperties);
		standardServiceRegistry = serviceRegistryBuilder.build();
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

		metadataSources.addAnnotatedClass(Employee.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.collection.mapping.Developer.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.onetomany.mapping.Developer.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.onetomany.mapping.Language.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.manytoone.mapping.JavaDeveloper.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.manytoone.mapping.JavaFramework.class);

		// Many to Many mapping
		metadataSources.addAnnotatedClass(in.jk.hibernate5.manytomany.mapping.Employee.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.manytomany.mapping.Address.class);

		// Merge vs Update method
		metadataSources.addAnnotatedClass(in.jk.hibernate5.mergeandupdate.Employee.class);

		// Hql Query
		metadataSources.addAnnotatedClass(in.jk.hibernate5.hqlquery.example.JavaDeveloper.class);

		// HQL One to One Mapping
		metadataSources.addAnnotatedClass(in.jk.hibernate5.onetoone.mapping.hql.join.Student.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.onetoone.mapping.hql.join.Course.class);

		// Group by Clause
		metadataSources.addAnnotatedClass(in.jk.hibernate5.groupbyandhaving.clause.SoftwareDeveloper.class);

		// Named HQL Query
		metadataSources.addAnnotatedClass(in.jk.hibernate5.named.hqlquery.example.Burger.class);

		// Named Native Query
		metadataSources.addAnnotatedClass(in.jk.hibernate5.named.nativequery.Computer.class);

		// Native SQL Query
		metadataSources.addAnnotatedClass(in.jk.hibernate5.nativequery.FootWear.class);

		// Criteria Query
		metadataSources.addAnnotatedClass(in.jk.hibernate5.criteria.query.Person.class);

		// Criteria API Query
		metadataSources.addAnnotatedClass(in.jk.hibernate5.criteria.api.query.MensWear.class);

		// Criteria API Tuple Query
		metadataSources.addAnnotatedClass(in.jk.hibernate5.criteria.tuple.query.Beverage.class);

		// Criteria Query Join and Eager and Lazy Fetch
		metadataSources.addAnnotatedClass(in.jk.hibernate5.criteria.join.query.Passenger.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.criteria.join.query.Ticket.class);

		// Criteria Builder Parameter
		metadataSources.addAnnotatedClass(in.jk.hibernate5.criteria.paramter.query.City.class);

		// Criteria Query with Aggregate Method
		metadataSources.addAnnotatedClass(in.jk.hibernate5.criteria.aggregate.method.query.Employee.class);

		// Criteria Query with Clause
		metadataSources.addAnnotatedClass(in.jk.hibernate5.criteria.using.clause.query.Player.class);

		// Hibernate Method Use
		metadataSources.addAnnotatedClass(in.jk.hibernate5.methods.use.User.class);

		// Use of Natural Id in Hibernate
		// metadataSources.addAnnotatedClass(in.jk.hibernate5.naturalid.example.Product.class);

		// Use of Defualt Column value
		metadataSources.addAnnotatedClass(in.jk.hibernate5.defualtcolumn.value.example.Student.class);

		// Use of Flush Mode
		metadataSources.addAnnotatedClass(in.jk.hibernate5.flush.mode.use.BankAccount.class);

		// Batch Processing
		metadataSources.addAnnotatedClass(in.jk.hibernate5.batch.processing.MovieTicket.class);

		// Join Fetch and N+1 Problem
		metadataSources.addAnnotatedClass(in.jk.hibernate5.n.plus.one.problem.JavaProgramer.class);
		metadataSources.addAnnotatedClass(in.jk.hibernate5.n.plus.one.problem.TechnicalSkill.class);

		// First Level Cache
		metadataSources.addAnnotatedClass(in.jk.hibernate5.first.level.cache.Employee.class);

		// Second Level Cache
		metadataSources.addAnnotatedClass(in.jk.hibernate5.second.level.cache.Employee.class);

		// Query Level Cache
		metadataSources.addAnnotatedClass(in.jk.hibernate5.query.second.level.cache.Employee.class);

		// Hibernate Interceptor
		metadataSources.addAnnotatedClass(in.jk.hibernate5.interceptor.use.Employee.class);

		// Hibernate Listener
		metadataSources.addAnnotatedClass(in.jk.hibernate5.event.listener.use.Employee.class);

		metadataSources.addAnnotatedClass(User.class);
		metadataSources.addAnnotatedClass(Address.class);

		Metadata metadata = metadataSources.getMetadataBuilder().build();

		sessionFactory = metadata.getSessionFactoryBuilder().build();

		// Apply Interceptor Config to Hibernate
		// sessionFactory = metadata.getSessionFactoryBuilder().applyInterceptor(new
		// EmployeeInterceptor()).build();

		return sessionFactory;

	}

}
