package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import dao.pojo.Message;
import net.sf.json.JSONObject;
import service.MessageService;

public class MessageAction implements ModelDriven<Message>{

	private Message message;
	
	private MessageService messageServicec;
	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		if(message == null)
			message = new Message();
		return message;
	}
	
	/**
	 * 保存帖子信息（联系我们的信息，发布后管理员邮箱就可以收到）
	 * @param message
	 * @return
	 * @throws IOException 
	 */
	public void saveMessage() throws IOException{	
		HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		messageServicec = new MessageService();
		messageServicec.saveMessage(message);
		
		 JSONObject obj = new JSONObject();
		 obj.put("result", true);
		//输出最后的json对象
		 out.println(obj); 
		 out.flush(); 
		 out.close(); 
	}
	
	public void findLatestMes() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		messageServicec = new MessageService();
		Message temp = messageServicec.findLatestMes();
		
		JSONObject obj = new JSONObject();
		obj.put("mesId", temp.getMesId());
		obj.put("mesContent", temp.getMesContent());
		
		//输出最后的json对象
		 out.println(obj); 
		 out.flush(); 
		 out.close(); 
	}

}
