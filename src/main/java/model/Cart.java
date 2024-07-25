package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int cartId;
	private int userId;
	private float totalAll;
	private List<CartDetail> cartDetails;
	public Cart() {
		
	}

	public Cart(int cartId, int userId, float totalAll) {
	
		this.cartId = cartId;
		this.userId = userId;
		this.totalAll = totalAll;
		this.cartDetails = new ArrayList<>();
	}
	
	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}
	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}
	public void addCartDetail(CartDetail cartDetail) {
		this.cartDetails.add(cartDetail);
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getTotalAll() {
		return totalAll;
	}
	public void setTotalAll(float totalAll) {
		this.totalAll = totalAll;
	}
	
	
	

}
