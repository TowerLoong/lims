package dao.pojo;

public class User {
	
	private Integer userId; //id
	private String userName; //”√ªß√˚
	private String userPassword; //√‹¬Î
	
	public String getUserName() {
		return userName;
	}
	
	
	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	

}
