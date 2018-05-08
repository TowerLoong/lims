package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import dao.pojo.Equip;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.EquipmentService;

public class EquipmentAction implements ModelDriven<Equip>{

	private Equip equip;
	private EquipmentService equipmentService;
	
	@Override
	public Equip getModel() {
		// TODO Auto-generated method stub
		if(equip == null){
			equip = new Equip();
		}
		return equip;
	}

	/**
	 * 添加实验室器材
	 * @return
	 * @throws IOException 
	 */
	public void saveEquipment() throws IOException{
		//保存数据
		equipmentService = new EquipmentService();
		equipmentService.saveEquip(equip);
		
		//返回json数据（！！！中文有乱码）
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		 PrintWriter out = response.getWriter(); 
		 //JSON在传递过程中是普通字符串形式传递的
		 JSONObject obj = new JSONObject();
		 obj.put("equipmentName", equip.getEquipName());
		 obj.put("equipmentNum", equip.getEquipNum());
		 out.println(obj); 
		 out.flush(); 
		 out.close(); 
	}
	
	/**
	 * 查找全部素材
	 * @throws IOException
	 */
	public void findAll() throws IOException{
		equipmentService = new EquipmentService();
		List<Equip> allList = equipmentService.findAll();
		
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		//创建json数组，把查询出来的每一个json对象装到数组里面，然后再返回给前端
		JSONArray jsonArray = new JSONArray();
		for(int i = 0;i < allList.size();i++){
			
			 JSONObject obj = new JSONObject();
			 
			 Equip temp = allList.get(i);
			 obj.put("equipId", temp.getEquipId());
			 obj.put("equipmentName", temp.getEquipName());
			 obj.put("equipmentNum", temp.getEquipNum());
			 
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
		equipmentService = new EquipmentService();
		
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		
		equipmentService.delById(equip.getEquipId());
		
		 JSONObject obj = new JSONObject();
		 obj.put("result", true);
		//输出最后的json对象
		 out.println(obj); 
		 out.flush(); 
		 out.close(); 
		
	}
	
}
