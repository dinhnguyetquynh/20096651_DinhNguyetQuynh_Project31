package model;

public class CartDetail {
	private int cartDetail_Id;
	private int cartId;
	private int productId;
	private int quantity;
	private float unitPrice;
	private float totalPrice;
	private String productName;
	private String imgURL;
	
	
	
	public CartDetail() {
		
		
	}
	
	public CartDetail(int cartDetail_Id, int cartId, int productId, int quantity, float unitPrice, float totalPrice,
			String productName, String imgURL) {
		
		this.cartDetail_Id = cartDetail_Id;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.imgURL = imgURL;
	}





	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCartDetail_Id() {
		return cartDetail_Id;
	}
	public void setCartDetail_Id(int cartDetail_Id) {
		this.cartDetail_Id = cartDetail_Id;
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

}
