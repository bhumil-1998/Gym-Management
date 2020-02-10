package com.GymManagement.gym.Model;

import java.util.Date;


public class UserModel {

//	private Long id;
	
	private String userName;
	
	private String fullName;
	
	private String emailid;
	
	private String contactno;
	
	private String password;
	
	private Long createdBy;
	
	private Date createdDate;
	
	private boolean isDeleted;

	private Integer userType;

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String userName, String fullName, String emailid, String contactno, String password,
			Long createdBy, Date createdDate, boolean isDeleted, Integer userType) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.emailid = emailid;
		this.contactno = contactno;
		this.password = password;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.isDeleted = isDeleted;
		this.userType = userType;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", fullName=" + fullName + ", emailid=" + emailid + ", contactno="
				+ contactno + ", password=" + password + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", isDeleted=" + isDeleted + ", userType=" + userType + "]";
	}

}
