package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;

public class ClassTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		System.out.println("init");
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		
	}

	@After
	public void destory() {
		System.out.println("destory");
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void  TestClass(){
	/*	UserInfo userInfo = new UserInfo();
		User user = new User();
		
		user.setUserName("xiaoming");
		user.setUserPassword("666");
		
		session.save(user);
		*/
		
	       Configuration cfg = new Configuration().configure();  
	          
	        SchemaExport export = new SchemaExport(cfg);  
	        //�������·���������  
	        export.create(true, true);  
	}
	
}
