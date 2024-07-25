package model;

public class User {
	private int userID;
	private String fullName;
	private String phone;
	private String userPassword;
	private String address;
	private String district;
	private String city;
	private boolean userRole;
	public User() {
		
	}
	
	public User(int userID, String fullName, String phone, String userPassword, String address, String district,
			String city, boolean userRole) {
		
		this.userID = userID;
		this.fullName = fullName;
		this.phone = phone;
		this.userPassword = userPassword;
		this.address = address;
		this.district = district;
		this.city = city;
		this.userRole = userRole;
	}

	public User(String fullName, String phone, String userPassword, String address, String district, String city,
			boolean userRole) {
		this.fullName = fullName;
		this.phone = phone;
		this.userPassword = userPassword;
		this.address = address;
		this.district = district;
		this.city = city;
		this.userRole = userRole;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isUserRole() {
		return userRole;
	}
	public void setUserRole(boolean userRole) {
		this.userRole = userRole;
	}
	
	

}
