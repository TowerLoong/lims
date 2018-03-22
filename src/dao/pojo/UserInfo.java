package dao.pojo;

public class UserInfo {
	
	private Integer userId; //id
	private String userName; //姓名
	private String userSId; //学号
	private String userMajor; //专业
	private String userClass; //班级
	private String userPhone; //手机号
	private String userEmail; //邮箱
	private String userIntroduce; //个人介绍
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSId() {
		return userSId;
	}
	public void setUserSId(String userSId) {
		this.userSId = userSId;
	}
	public String getUserMajor() {
		return userMajor;
	}
	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}
	public String getUserClass() {
		return userClass;
	}
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserIntroduce() {
		return userIntroduce;
	}
	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userSId=" + userSId + ", userMajor="
				+ userMajor + ", userClass=" + userClass + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", userIntroduce=" + userIntroduce + "]";
	}
	
}
