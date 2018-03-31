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

public class EquipmentDao {

	/**
	 * 保存一个设备
	 * 
	 * @param equip
	 * @return
	 */
	public static Boolean saveQuipment(Equip equip) {

		SessionFactory sessionFactory;
		Session session;
		Transaction transaction;

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		String hql = "FROM Equip e WHERE e.equipName = ?";
		Query query = session.createQuery(hql);
		query.setString(0, equip.getEquipName());

		List<Equip> emps = query.list();
		System.out.println(emps.size());

		// 如果查询出来这个设备的数量为0就在数据库中新加一条数据
		if (emps.size() == 0) {
			Equip tempEquip = new Equip();
			tempEquip.setEquipName(equip.getEquipName());
			tempEquip.setEquipNum(equip.getEquipNum());
			session.save(tempEquip);
			transaction.commit();
		} else {
			// 如果查询出来这个设备的数量是大于0，就表示已经存在，只需要让它在数据库中的数量加1
			Integer equipId = emps.get(0).getEquipId();
			Equip tempEquip = (Equip) session.get(Equip.class, equipId);
			tempEquip.setEquipNum(tempEquip.getEquipNum() + equip.getEquipNum());
			// String hql2 = "update Equip e set e.equipNum = e.equipNum + ?
			// where e.equipId = ?";

			session.update(tempEquip);
			session.getTransaction().commit();
		}

		session.close();

		return true;

	}

	/**
	 * 查找全部的设备
	 * 
	 * @return
	 */
	public List<Equip> findAll() {
		SessionFactory sessionFactory;
		Session session;
		Transaction transaction;

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		String hql = "from Equip";
		Query query = session.createQuery(hql);
		List<Equip> emps = query.list();

		transaction.commit();
		session.close();
		return emps;
	}

	public Boolean deleteEquipById(Integer id) {
		SessionFactory sessionFactory;
		Session session;
		Transaction transaction;

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		//开始删除操作
		Equip equip = new Equip();
		equip.setEquipId(id);
		session.delete(equip);
		
		transaction.commit();
		session.close();
		return true;
	}

	public static void main(String[] args) {
		// Equip equip = new Equip();
		// equip.setEquipName("显示器");
		// equip.setEquipNum(20);
		//
		// EquipmentDao.saveQuipment(equip);
	}

}
