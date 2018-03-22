package service;

import dao.classdao.UserInfoDao;
import dao.pojo.UserInfo;

public class UserInfoService {
	
	public Boolean saveUserInfo(UserInfo userInfo){
		
		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.saveUserInfo(userInfo);
		
		return true;
	}
	
}
