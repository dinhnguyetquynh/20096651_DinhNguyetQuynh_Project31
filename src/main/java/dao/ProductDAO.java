package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.text.NumberFormatter;

import connectMariaDB.connectDB;
import model.Product;

public class ProductDAO {
	private static final List<Product> ds = new ArrayList<Product>();
	
	public static List<Product> queryProducts(){
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = connectDB.getConnection();
			String query = "select Product_ID,Name,Description,Price, Stock, imgURL from Products";
			ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id= rs.getInt("Product_ID");
				String name = rs.getString("Name");
				String description = rs.getString("Description");
				float price = rs.getFloat("Price");
				int stock = rs.getInt("Stock");
				String imgURL = rs.getString("imgURL");
				//Định dạng price
				
				
				Product p = new Product(id, name, description, price, stock, imgURL);
				ds.add(p);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
	public Product getProductById(int id) {
        Product product = null;
        String query = "SELECT p.Product_ID, p.Name, p.Description, p.Price, p.Stock, p.imgURL, " +
                "c.CategoryName, b.BrandName " +
                "FROM Products p " +
                "LEFT JOIN Categories c ON p.Category_ID = c.Category_ID " +
                "LEFT JOIN Brand b ON p.Brand_ID = b.Brand_ID " +
                "WHERE p.Product_ID = ?";
        try (Connection conn = connectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("Product_ID"));
                product.setProductName(rs.getString("Name"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getFloat("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setImgURL(rs.getString("imgURL"));
                product.setCategoryName(rs.getString("CategoryName"));
                product.setBrandName(rs.getString("BrandName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
	
	public static List<Product> filterProducts(String brand, String priceRange) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connect = null;
        PreparedStatement ps = null;
        int brandId = Integer.parseInt(brand);
        ResultSet rs = null;

        try {
            connect = connectDB.getConnection();
            //lấy brandName từ brandId
            
            String query = "SELECT * FROM Products WHERE 1=1";
            
            if (brandId != 0) {
                query += " AND Brand_ID = ?";
            }
            
            if (priceRange != null && !priceRange.isEmpty()) {
                switch (priceRange) {
                    case "muc1":
                        query += " AND Price BETWEEN 1000000 AND 2000000";
                        break;
                    case "muc2":
                        query += " AND Price BETWEEN 2000000 AND 4000000";
                        break;
                    case "muc3":
                        query += " AND Price BETWEEN 4000000 AND 6000000";
                        break;
                }
            }
            
            ps = connect.prepareStatement(query);

            int paramIndex = 1;
            ps.setInt(paramIndex++, brandId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("Product_ID");
                String productName = rs.getString("Name");
                String description = rs.getString("Description");
                float price = rs.getFloat("Price");
                int stock = rs.getInt("Stock");
                String imgURL = rs.getString("imgURL");
                Product product = new Product(productId, productName, description, price, stock, imgURL);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }

        return products;
    }
	 public static List<Product> getProductsByCategory(int categoryId) {
	        List<Product> products = new ArrayList<>();
	        String query = "SELECT * FROM Products WHERE Category_ID = ?";

	        try (Connection con = connectDB.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            
	            ps.setInt(1, categoryId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Product product = new Product();
	                product.setProductId(rs.getInt("Product_ID"));
	                product.setProductName(rs.getString("Name"));
	                product.setDescription(rs.getString("Description"));
	                product.setPrice(rs.getFloat("Price"));
	                product.setStock(rs.getInt("Stock"));
	                product.setImgURL(rs.getString("imgURL"));
	                products.add(product);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return products;
	    }
	 
	 public static List<Product> searchProductsByName(String productName) {
	        List<Product> products = new ArrayList<>();
	        String query = "SELECT * FROM Products WHERE Name LIKE ?";

	        try (Connection con = connectDB.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            
	            ps.setString(1, "%" + productName + "%");
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Product product = new Product();
	                product.setProductId(rs.getInt("Product_ID"));
	                product.setBrandName(rs.getString("Name"));
	                product.setDescription(rs.getString("Description"));
	                product.setPrice(rs.getFloat("Price"));
	                product.setStock(rs.getInt("Stock"));
	                product.setImgURL(rs.getString("imgURL"));
	                products.add(product);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return products;
	    }

}
