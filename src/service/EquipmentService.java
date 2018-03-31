package service;

import java.util.List;

import dao.classdao.EquipmentDao;
import dao.pojo.Equip;

public class EquipmentService {

	EquipmentDao equipmentDao = new EquipmentDao();
	
	/**
	 * 添加设备
	 * @param equip
	 * @return
	 */
	public Boolean saveEquip(Equip equip){
		
		equipmentDao.saveQuipment(equip);
		return true;
		
	}
	
	/**
	 * 查找全部设备
	 * @return
	 */
	public List<Equip> findAll(){
		List<Equip> allList = equipmentDao.findAll();
		return allList;
	}
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Boolean delById(Integer id){
		equipmentDao.deleteEquipById(id);
		return true;
	}
	
}
