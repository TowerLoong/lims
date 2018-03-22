package dao.classdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.pojo.User;
import dao.pojo.UserInfo;

public class UserInfoDao {

public static Boolean saveUserInfo(UserInfo userInfo){
		
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
		
		session.save(userInfo);
		
		session.close();
		transaction.commit();
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		UserInfo userInfo = new UserInfo();
		userInfo.setUserSId("5120152467");
		userInfo.setUserClass("׿��1501");
		userInfo.setUserEmail("towerloong@hotmail.com");
		userInfo.setUserIntroduce("��Һã����ǿɰ���С�ɰ�");
		userInfo.setUserMajor("�������ѧ�뼼��");
		userInfo.setUserName("������");
		userInfo.setUserPhone("18784028326");
		
		saveUserInfo(userInfo);
		*/
	}

}
