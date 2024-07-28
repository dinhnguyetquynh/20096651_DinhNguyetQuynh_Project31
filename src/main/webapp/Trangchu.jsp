<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

.dropbtn2{
	cursor: pointer;
}
.dropdown2{
	position: relative;
	display: inline-block;
}
.dropdown-content2 {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 150px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
.dropdown-content2 a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}
.dropdown-content2 a:hover {background-color: #f1f1f1}
.dropdown2:hover .dropdown-content2 {
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
.search{
	width: 78%;
	height: 100px;
	float: left;
	
}
.search_form{
	margin-left: 30px;
	margin-top: 30px;
}
.search_form input[type="text"]{
	width: 50%;
	height:30px;
	border: 2px solid grey;
	border-radius: 4px;
}
.search_form input[type="submit"]{
	width: 15%;
	height: 30px;
	background-color: black;
	color: white;
	border-radius: 4px;
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
	background-color:  #F5F3F3;
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
	height: 1000px;
	float: left;
	display: flex;
	flex-wrap: wrap;
    gap: 20px; 
   	overflow: auto;

 
}
.product{
	width: 300px;
	height: 386px;
	background-color: #F5F3F3;
	margin-top: 20px;
}
.product img{
	width: 280px;
	height: 254px;
	padding: 10px;
	margin-left: 10px;
	margin-top: 10px;
}

.info_product{
	margin-left: 18px;
	
}
.product_name{
	width: 100%;
	height: 50px;
}
.info_product a{
	text-decoration: none;
	color: #FF3469;
}
.info_product a:hover{
	background-color:#D3D3D3;
	
}
.info_product h3,p{
	padding-bottom: 5px;
}
#price{
	font-weight: bolder;
}

.btn_Add{
	width:90%;
	margin-top: 10px;
	margin-left: 15px;
	background-color: #ffc2d1;
	border: none;
	padding:5px;
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
						<a href="/20096651_DinhNguyetQuynh_Project31/ProductCategoryServlet?categoryId=1">
							Nước hoa nữ
						</a>
						<a href="/20096651_DinhNguyetQuynh_Project31/ProductCategoryServlet?categoryId=2">Nước hoa nam</a>
					</div>
				</div>
				
				<div class="YourDream">
					<p>Your Dream</p>
				</div>
				
				<div class="menu2">
					<ul>
						<li>
							
							
						</li>
						<li>
							<div class="dropdown2">
								<img alt="ko" src="icons/user.png" class="dropbtn2">
								<div class="dropdown-content2">
									<a href="/20096651_DinhNguyetQuynh_Project31/CustomerInfoServlet">Tài Khoản</a>
									<a href="Dangnhap.jsp">Đăng nhập</a>
									<a href="Dangky.jsp">Đăng ký</a>
									<a href="LogoutServlet">Đăng xuất</a>
									
								</div>
							</div>
							
						</li>
						<li><a href="/20096651_DinhNguyetQuynh_Project31/IconCartServlet"><img alt="ko" src="icons/cart.png"></a></li>
					</ul>
				</div>
				
			</div>
			
			<div class="aside">
				<div class="brand_filter">
				<form action="ProductFilterServlet" method="get">
					<p>THƯƠNG HIỆU</p>
					
					<input type="radio" id="channel" name="brand" value="1">
					<label for="channel">Channel</label>
					<br>
					<input type="radio" id="dior" name="brand" value="2">
					<label for="dior">Dior</label>
					<br>
					<input type="radio" id="lancome" name="brand" value="3">
					<label for="lancome">Lancome</label>
					<br>
					<input type="radio" id="tom" name="brand" value="4">
					<label for="tom">TomFord</label>
					<br>
					<br>
					<br>
					<hr>
					<p>MỨC GIÁ</p>
					<input type="radio" id="muc1" name="price" value="muc1">
					<label for="dior">1.000.000đ - 2.000.000đ</label>
					<br>
					<input type="radio" id="muc2" name="price" value="muc2">
					<label for="dior">2.000.000đ - 4.000.000đ</label>
					<br>
					<input type="radio" id="muc3" name="price" value="muc3">
					<label for="dior">4.000.000đ - 6.000.000đ</label>
					<br>
					
					<input type="submit" value="Lọc" class="btn_submit">
				</form>
					
					
				<p><a href="/20096651_DinhNguyetQuynh_Project31/ProductListController">Tất cả sản phẩm</a>	
				</div>
			</div>
			
			<div class="search">
							<div class="search_form">
								<form action="ProductSearchServlet" method="get">
								    <input type="text" name="productName" placeholder="Nhập tên sản phẩm">
								    <input type="submit" value="Tìm kiếm">
								</form>
							</div>					
		   </div>
			<div class="section">	
				
				<c:forEach items="${ds}" var="sp">
				
					<form >
						<div class="product">
						<img alt="ko hien thi" src="${sp.imgURL }">
						<div class="info_product">
							<div class="product_name">
								<h3>${sp.productName }</h3>
							</div>
							
							<p id="price">Giá:<fmt:formatNumber value="${sp.price}" type="number"  groupingUsed="true" />đ</p>
							<p></p>
							<p><a href="ProductDetailServlet?id=${sp.productId}">Xem chi tiết</a></p>
						</div>
						
						
						<input type="hidden" name="productId" value="${sp.productId }" >
						
						</div>
					</form>
				</c:forEach>
				
					
		
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