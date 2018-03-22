package dao.classdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.pojo.User;

public class UserDao {

	public static Boolean haveUser(User user){
		
		SessionFactory sessionFactory;
	    Session session;
		Transaction transaction;
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		String hql = "from user a where a.USERNAME = ? and a.PASSWORD = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user.getUserName());
		query.setParameter(1, user.getUserPassword());
		
		List<User> list = query.list(); 
		
		session.close();
		transaction.commit();
		
		System.out.println(list.get(0).getUserName());
		return true;
		/*
		if(list.get(0) == null)
			return false;
		else
			return true;
		*/
	}
	
	public static Boolean saveuser(User user){
		
		SessionFactory sessionFactory;
	    Session session;
		Transaction transaction;
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		session.save(user);
		
		session.close();
		transaction.commit();
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setUserName("ming");
		user.setUserPassword("999");
		
		saveuser(user);

	}

}
