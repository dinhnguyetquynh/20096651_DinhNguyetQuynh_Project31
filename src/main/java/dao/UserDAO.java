package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectMariaDB.connectDB;
import model.User;

public class UserDAO {
	
	
	public void addUser(String fullName,String phone,String userPassword,String address,String district,String city,boolean userRole) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = connectDB.getConnection();
			
			String sql ="INSERT INTO user(FullName,Phone,UserPassword,Address,District,City,UserRole) values(?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, fullName);
			ps.setString(2,phone);
			ps.setString(3,userPassword);
			ps.setString(4,address);
			ps.setString(5,district);
			ps.setString(6,city);
			ps.setBoolean(7,userRole);
			
			ps.executeUpdate();
			
			
		} finally {
            // Đóng các resource (Connection và PreparedStatement) sau khi hoàn thành
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
		
	}
	public User validateUser(String phone,String password) {
		Connection connection = null;
		PreparedStatement ps = null;
		User user = null;
		try {
			connection = connectDB.getConnection();
			String sql="select * from user where Phone=? and UserPassword=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				int id= rs.getInt("UserID");
				String fullName = rs.getString("FullName");
				String address = rs.getString("Address");
				String district = rs.getString("District");
				String city = rs.getString("City");
				boolean userRole = rs.getBoolean("UserRole");
				user = new User(id, fullName, phone, password, address, district, city, userRole);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}
	
}
