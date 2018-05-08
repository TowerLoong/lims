package service;

import dao.classdao.MessageDao;
import dao.pojo.Message;

public class MessageService {

	private MessageDao messageDao = new MessageDao();
	
	/**
	 * 添加message记录
	 * @param message
	 * @return
	 */
	public Boolean saveMessage(Message message){
		
		messageDao.saveMessage(message);
		
		return true;
	}
	
	/**
	 * 查询最近的一条“联系我们”信息
	 */
	public Message findLatestMes(){
		return messageDao.findLatestMes();
	}
}
