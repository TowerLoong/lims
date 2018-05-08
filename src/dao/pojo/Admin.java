package dao.pojo;

public class Admin {

	private Integer adminId;
	
	private String adminName;
	
	private String adminPassword;

	@Override
	public String toString() {
		return "AdminDao [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}

	public Admin() {
		super();
	}

	public Admin(Integer adminId, String adminName, String adminPassword) {
		super(); 
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
