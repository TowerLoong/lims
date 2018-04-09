package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import dao.pojo.UserInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.UserInfoService;

public class UserInfoAction implements ModelDriven<UserInfo>{
	
	private UserInfo userInfo;
	
	private UserInfoService userInfoService;
	
	@Override
	public UserInfo getModel() {
	      if(userInfo == null){
	    	  userInfo = new UserInfo();
	       }
	       return userInfo;
	}
	
	/**
	 * 保存申请信息
	 * @return
	 */
	public String saveUserInfo(){
		
		UserInfoService userInfoService = new UserInfoService();
		userInfoService.saveUserInfo(userInfo);
		
		return "success";
		
	}

	/**
	 * 通过成员管理表格管理成员
	 * @throws IOException 
	 */
	public void saveAUserInfo() throws IOException{
		
		HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		UserInfoService userInfoService = new UserInfoService();
		userInfoService.saveUserInfo(userInfo);
		
		 JSONObject obj = new JSONObject();
		 obj.put("result", true);
		//输出最后的json对象
		 out.println(obj); 
		 out.flush(); 
		 out.close(); 
	}
	
	/**
	 * 查询全部用户数据
	 * @throws IOException
	 */
	public void findAll() throws IOException{
		
		userInfoService = new UserInfoService();
		List<UserInfo> allList = new ArrayList<UserInfo>();
		
		allList = userInfoService.findAll();
		
		HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		//创建json数组，把查询出来的每一个json对象装到数组里面，然后再返回给前端
		JSONArray jsonArray = new JSONArray();
		for(int i = 0;i < allList.size();i++){
			
			 JSONObject obj = new JSONObject();
			 
			 UserInfo temp = allList.get(i);
			 obj.put("userId", temp.getUserId());
			 obj.put("userName", temp.getUserName());
			 obj.put("userMajor", temp.getUserMajor());
			 obj.put("userPhone", temp.getUserPhone());
			 obj.put("userIntroduce", temp.getUserIntroduce());
			 
			 jsonArray.put(obj);
		}
		//输出最后的json数组
		 out.println(jsonArray); 
		 out.flush(); 
		 out.close(); 
		
	}
	
	/**
	 * 通过id删除
	 * @param id
	 * @throws IOException 
	 */
	public void delById() throws IOException{
	
		userInfoService = new UserInfoService();
		HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		System.out.println(userInfo.getUserId() + "****");
		
		userInfoService.delById(userInfo.getUserId());
		
		 JSONObject obj = new JSONObject();
		 obj.put("result", true);
		//输出最后的json对象
		 out.println(obj); 
		 out.flush(); 
		 out.close(); 
	}
	
}
