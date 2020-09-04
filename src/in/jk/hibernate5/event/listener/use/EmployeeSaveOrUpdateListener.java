package in.jk.hibernate5.event.listener.use;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

public class EmployeeSaveOrUpdateListener implements SaveOrUpdateEventListener {

	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
	
		System.out.println("Employee :: Save Or Update Lisnter :: ");

		Object object = event.getEntity();
		
		if(object instanceof Employee) {
			Employee employee = (Employee) object;
			
			System.out.println("Employee Save Or Update :: Listener ::  "+employee);
			
		}
		
	}

}
