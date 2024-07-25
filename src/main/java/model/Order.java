package model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Order {
	private int orderId;
	private int userId;
	private LocalDateTime oderDate;
	private double totalAmount;
	private String status;
	private String payMethod;
	public Order() {
		
	}
	
	public Order(int orderId, int userId, LocalDateTime oderDate, double totalAmount, String status, String payMethod) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.oderDate = oderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.payMethod = payMethod;
	}
	 public Date getOrderDateAsDate() {
	        return (Date) Date.from(oderDate.atZone(ZoneId.systemDefault()).toInstant());
	    }
	
	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDateTime getOderDate() {
		return oderDate;
	}
	public void setOderDate(LocalDateTime oderDate) {
		this.oderDate = oderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
