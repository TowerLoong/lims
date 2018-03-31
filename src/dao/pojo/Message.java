package dao.pojo;

public class Message {

	private Integer mesId;
	
	private String mesContent;
	
	private Admin admin;

	@Override
	public String toString() {
		return "Message [mesId=" + mesId + ", mesContent=" + mesContent + ", admin=" + admin + "]";
	}

	public Message() {
		super();
	}

	public Message(Integer mesId, String mesContent, Admin admin) {
		super();
		this.mesId = mesId;
		this.mesContent = mesContent;
		this.admin = admin;
	}

	public Integer getMesId() {
		return mesId;
	}

	public void setMesId(Integer mesId) {
		this.mesId = mesId;
	}

	public String getMesContent() {
		return mesContent;
	}

	public void setMesContent(String mesContent) {
		this.mesContent = mesContent;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
