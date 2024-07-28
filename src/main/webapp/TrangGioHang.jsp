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
.table_cart{
	margin-top: 50px;
}
.tbl_header{
	font-size: 20px;
	font-weight: bolder;
	background-color: black;
	color: white;
}
.product_img{
	width: 50px;
	height: 50px;
	
}
.form_order{
	display: flex;
}
.form_order h2{
	margin-left: 0px;
}
.form_order input[type="submit"]{
	margin-right: ;
}
.btn_order{
	width:200px;
	background-color: #FF3469;
	color: white;
	border: none;
	padding:10px;
	border-radius: 4px;
	margin-top: 20px;
	font-size: 18px;
	font-weight: bolder;
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
				
			
				
			</div>
			
			<div class="aside">
				<div class="aside_link">
					<p><a href="/20096651_DinhNguyetQuynh_Project31/ProductListController">Quay lại trang chủ</a>
					</p>
				</div>
		
				
			</div>
			

			
			<div class="section">
				<c:if test="${not empty cart.cartDetails}">
				
							<table width="100%" border=1 class="table_cart">
					<tr class="tbl_header">
						<td>Hình ảnh</td>
						<td>Tên sản phẩm</td>
						<td>Số lượng</td>
						<td>Giá</td>
						<td>Thành tiền</td>
						<td></td>
					</tr>
					<c:forEach var="detail" items="${cart.cartDetails}">
						<form name="item" method="post" action="UpdateToCartServlet">
							<tr>
								
								<td><img alt="kho" src="${detail.imgURL }" class="product_img"></td>
								<td>
									
									${detail.productName}
								</td>
		                        <td>
		                        	<input type="hidden" name="cd_id" value="${detail.cartDetail_Id}">
		                        	<input type="hidden" name="userId" value="${cart.userId}">
		                        	<input type="text" name="quantity" value="${detail.quantity}" >
		                        	<input type="submit" name="action" value="Edit" size="3">
		                        </td>
		                        <td><p><fmt:formatNumber value="${detail.unitPrice}" type="number"  groupingUsed="true" /></p></td>
		                        <td><fmt:formatNumber value="${detail.totalPrice}" type="number"  groupingUsed="true" /></td>
		                        <td>
		                        	<input type="submit" name="action" value="Delete" size="3">
		                        </td>
							</tr>
						</form>
						
					</c:forEach>
					
				</table>
				<br>
				<div class="form_order">
					<h2>Tổng tiền: <fmt:formatNumber value="${cart.totalAll}" type="number"  groupingUsed="true" />đ</h2>
					<form action="CheckoutServlet" method="post">
				 		<input type="submit" name="btn_order" value="Tiến hành đặt hàng" class="btn_order">
					</form>
				</div>
				 
			
				</c:if>
				 <c:if test="${empty cart.cartDetails}">
			        <p>Giỏ hàng của bạn đang trống.</p>
			    </c:if>
				
		
	
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