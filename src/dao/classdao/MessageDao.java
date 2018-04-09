package dao.classdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.pojo.Message;

public class MessageDao {

	/**
	 * 保存帖子信息（联系我们信息）
	 * @param message
	 * @return
	 */
	public Boolean saveMessage(Message message){
		
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
		
		session.save(message);
		
		session.close();
		transaction.commit();
		return true;
		
	}
	
	/**
	 * 查询最近的一条“联系我们“信息
	 * @return
	 */
	public Message findLatestMes(){
		SessionFactory sessionFactory;
		Session session;
		Transaction transaction;

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		String hql = "from Message";
		Query query = session.createQuery(hql);
		List<Message> emps = query.list();

		transaction.commit();
		session.close();
		return emps.get(emps.size() - 1);
	}
}
