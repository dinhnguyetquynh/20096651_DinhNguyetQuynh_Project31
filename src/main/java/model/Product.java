package model;

public class Product {
	private int productId;
	private String productName;
	private String description;
	private float price;
	private int stock;
	private String imgURL;
	private String categoryName;
	private String brandName;
	
	public Product() {
		
	}
	
	

	public Product(int productId, String productName, String description, float price, int stock, String imgURL) {
	
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.imgURL = imgURL;
	}



	public Product(int productId, String productName, String description, float price, int stock, String imgURL,
			String categoryName, String brandName) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.imgURL = imgURL;
		this.categoryName = categoryName;
		this.brandName = brandName;
	}



	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getBrandName() {
		return brandName;
	}



	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
	
	
	

}
