package dao.pojo;

public class UserInfo {
	
	private Integer userId; //id
	private String userName; //名字
	private String userSId; //ѧ��
	private String userMajor; //רҵ
	private String userClass; //�༶
	private String userPhone; //�手机
	private String userEmail; //邮箱
	private String userIntroduce; //简介
	
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
