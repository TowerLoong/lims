package dao.classdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.pojo.Equip;
import dao.pojo.UserInfo;

public class UserInfoDao {

	/**
	 * 保存用户信息
	 * @param userInfo
	 * @return
	 */
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
	
	/**
	 * 查询全部的人员信息
	 * @return
	 */
	public List<UserInfo> findAll(){
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
	
		String hql = "from UserInfo";
		Query query = session.createQuery(hql);
		List<UserInfo> emps = query.list();
	
		transaction.commit();
		session.close();
		return emps;
	}
	
	/**
	 * 通过id删除人员信息
	 * @param id
	 * @return
	 */
	public Boolean deleteUserInfoById(Integer id) {
		SessionFactory sessionFactory;
		Session session;
		Transaction transaction;
	
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	
		//开始删除操作
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(id);
		session.delete(userInfo);
		
		transaction.commit();
		session.close();
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
