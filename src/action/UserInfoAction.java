package action;

import com.opensymphony.xwork2.ModelDriven;

import dao.pojo.UserInfo;
import service.UserInfoService;

public class UserInfoAction implements ModelDriven<UserInfo>{
	
	private UserInfo userInfo;
	
	@Override
	public UserInfo getModel() {
	      if(userInfo == null){
	    	  userInfo = new UserInfo();
	       }
	       return userInfo;
	}
	
	/**
	 * 保存申请信息的
	 * @return
	 */
	public String saveUserInfo(){
		
		UserInfoService userInfoService = new UserInfoService();
		userInfoService.saveUserInfo(userInfo);
		
		return "success";
		
	}


}
