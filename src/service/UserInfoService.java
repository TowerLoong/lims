package service;

import java.util.List;

import dao.classdao.UserInfoDao;
import dao.pojo.UserInfo;

public class UserInfoService {
	
	private UserInfoDao userInfoDao = new UserInfoDao();
	
	/**
	 * 保存用户信息
	 * @param userInfo
	 * @return
	 */
	public Boolean saveUserInfo(UserInfo userInfo){
		
		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.saveUserInfo(userInfo);
		
		return true;
	}
	
	/*
	 * 查询全部用户信息
	 */
	public List<UserInfo> findAll(){
		List<UserInfo> allList = userInfoDao.findAll();
		
		return allList;
	}
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Boolean delById(Integer id){
		userInfoDao.deleteUserInfoById(id);
		
		return true;
	}
}
