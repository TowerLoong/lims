package action;

import com.opensymphony.xwork2.ModelDriven;

import dao.pojo.Message;
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
	 * 保存帖子信息
	 * @param message
	 * @return
	 */
	public void saveMessage(){
		
		messageServicec = new MessageService();
		messageServicec.saveMessage(message);
		
	}

}
