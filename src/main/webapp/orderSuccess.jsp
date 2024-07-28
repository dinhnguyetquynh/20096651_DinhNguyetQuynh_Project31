<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<style type="text/css">
*{
	box-sizing: border-box;
	margin: 0 auto;
}
.tong{
	width: 100%;
	height: 100%;
}
.header{
	width: 100%;
	height: 70px;
	float: left;
	background-color: #ffc2d1;
	display: flex;
    align-items: center;
    padding: 10px;
    justify-content: center;

}
.header img{
	width: 24px;
	height: 24px;
}
.dropbtn{
	cursor: pointer;

}
.dropdown{
	position: relative;
	display: inline-block;
	margin-left: 80px;
	
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}

.menu2 ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  display: flex; 
  margin-right: -180px;
}

.menu2 li {
  display: inline;
  margin-left: 20px;
}
.YourDream p{
	font-size: 35px;
	color: 686262;
	font-weight: bolder;
	font-style: oblique;
	font-family: "Sofia", sans-serif;
	margin-left: 100px ;
}
.aside{
	width: 20%;
	height: auto;
	float: left;
	padding: 10px;
	
}
.aside_link{
	width: 100%;
	height: 30px;
	background-color:  #F5F3F3;
}
.aside_info{
	margin-top: 20px;
	
}
.brand_filter p{
	font-size: 18px;
	font-weight: bolder;
	margin-top: 10px;
	margin-bottom: 10px;
}
.brand_filter input{
	margin-bottom: 20px;
}
.btn_submit{
	width: 30%;
	height: 30px;
	margin-top: 20px;
	background-color: #ffc2d1;
	font-size: 15px;
	font-weight: bold;
	border: none;
	border-radius: 4px;
}

.section{
	width: 78%;
	height: 610px;
	float: left;

}
.tbl_info{
	margin-left: 0px;
}
.product_img{
	width: 50px;
	height: 50px;
}
.btn_order{
	margin-top: 10px;
	width:20%;
	background-color: #FF3469;
	color: white;
	border: none;
	padding:10px;
	border-radius: 4px;
	font-size: 18px;
	
}
.table_cart{
	background-color: #F5F3F3;
}
h3{
	margin-top: 20px;
}
.tbl_header{
	background-color: #ffc2d1;
}
.footer{
	width: 100%;
	height: auto;
	float: left;
	margin-top: 40px;
	display: flex;
	background-color:  #ffc2d1;
	
}
.footer_info{
	padding: 10px;
}
.footer_social{
	padding: 10px;
}

.footer_info img{
	width: 24px;
	height: 24px;	
}
.footer_social img{
	width: 24px;
	height: 24px;	
}
</style>
</head>
<body>
	<div class="tong">
			<div class="header">
				<div class="dropdown">
					<img alt="khong hien thi duoc" src="icons/menu.png" class="dropbtn">
					<div class="dropdown-content">
						<a href="#">Nước hoa nữ</a>
						<a href="#">Nước hoa nam</a>
					</div>
				</div>
				
				<div class="YourDream">
					<p>Your Dream</p>
				</div>
				
				<div class="menu2">
					<ul>
						<li><a href="#"><img alt="ko" src="icons/search.png"></a></li>
						<li><a href="#"><img alt="ko" src="icons/user.png"></a></li>
						<li><a href="#"><img alt="ko" src="icons/cart.png"></a></li>
					</ul>
				</div>
				
			</div>
			
			<div class="aside">
				<div class="aside_link">
					<p><a href="Trangchu.jsp">Trang chủ</a>>><a>Trang chi tiết sản phẩm</a></p>
				</div>
				
				
			</div>
			

			
			<div class="section">
				<h2>Đặt hàng thành công!</h2>
				<a href="/20096651_DinhNguyetQuynh_Project31/ProductListController">Quay lại trang chủ</a>
	
			</div>
			
			<div class="footer">
				<div class="footer_info">
					<h4>THÔNG TIN CHUNG</h4>
					<p><img alt="khong" src="icons/email.png">:dquynhd202@gmail.com</p>
					<p><img alt="khong" src="icons/phone-call.png">:0399762636</p>
					<p><img alt="khong" src="icons/maps-and-flags.png">:136C Phan Văn Hớn, Hóc Môn , TPHCM</p>
				</div>
				<div class="footer_social">
					<h4>MẠNG XÃ HỘI</h4>
					<p><img alt="khong" src="icons/facebook.png">YourDream Perfume</p>
					<p><img alt="khong" src="icons/instagram.png">@yourdream_perfume</p>
					<p><img alt="khong" src="icons/Icon-Zalo.jpg">YourDream Perfume</p>
				</div>
			</div>
	
	</div>


</body>
</html>