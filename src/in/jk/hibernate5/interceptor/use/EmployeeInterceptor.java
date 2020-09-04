package in.jk.hibernate5.interceptor.use;

import java.io.Serializable;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class EmployeeInterceptor extends EmptyInterceptor {

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
			throws CallbackException {

		System.out.println("Employee Interceptor ....");

		if (entity instanceof Employee) {

			Employee employee = (Employee) entity;
			System.out.println("Employee Entity :: On Save Intceptor :: " + employee);
		}

		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
			throws CallbackException {

		System.out.println("Employee Interceptor ....");

		if (entity instanceof Employee) {

			Employee employee = (Employee) entity;
			System.out.println("Employee Entity :: On LoadIntceptor :: " + employee);
		}

		return super.onLoad(entity, id, state, propertyNames, types);
	}

}
