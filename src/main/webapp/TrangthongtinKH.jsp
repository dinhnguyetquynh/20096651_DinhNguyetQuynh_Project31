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
	
    align-items: center;
    padding: 10px;
    justify-content: center;

}

.YourDream p{
	font-size: 35px;
	color: 686262;
	font-weight: bolder;
	font-style: oblique;
	font-family: "Sofia", sans-serif;
	margin-left: 45%;
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
.orders{
	margin-top: 20px;
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
			
				
				<div class="YourDream">
					<p>Your Dream</p>
				</div>
				
				<div class="menu2">
					<ul>
				
					</ul>
				</div>
				
			</div>
			
			<div class="aside">
				<div class="aside_link">
					<p><a href="ProductListController">Trang chủ</a>>><a>Trang thông tin khách hàng</a></p>
				</div>
			
				
			</div>
			

			
			<div class="section">
				<div class="info">
		            <h2>Thông tin khách hàng</h2>
		            <p><strong>Họ và tên:</strong> ${user.fullName}</p>
		            <p><strong>Điện thoại:</strong> ${user.phone}</p>
		            <p><strong>Địa chỉ:</strong> ${user.address}</p>
		            <p><strong>Quận/Huyện:</strong> ${user.district}</p>
		            <p><strong>Thành phố:</strong> ${user.city}</p>
		        </div>
		        <div class="orders">
		            <h2>Lịch sử mua hàng</h2>
		            <table width="100%" border=1>
		                <tr>
		                    <th>Mã đơn hàng</th>
		                    <th>Ngày đặt</th>
		                    <th>Tổng tiền</th>
		                    <th>Trạng thái</th>
		                    <th>Phương thức thanh toán</th>
		                </tr>
		                <c:forEach var="order" items="${orders}">
		                    <tr>
		                        <td>${order.orderId}</td>
		                        <td>${order.oderDate}</td>
		                        <td><fmt:formatNumber value="${order.totalAmount}" type="currency" currencySymbol="đ" /></td>
		                        <td>${order.status}</td>
		                        <td>${order.payMethod}</td>
		                    </tr>
		                </c:forEach>
		            </table>
		        </div>
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