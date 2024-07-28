<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		box-sizing: border-box;
		margin: 0 auto;
	}
	.tong{
		width: 100%;
	}
	.aside{
		float: left;
		width: 20%;
		height: 1200px;
		background-color: #FFC2D1;
		
	}
	.admin, .perfume_icon,.sales,.signout{
		display: flex;
		text-align: center;
		
	}
	.admin img, .perfume_icon img, .sales img,.signout img{
		margin: 10px;
	}
	.admin p,.perfume_icon p,.sales p,.signout p{
		margin-left: 5px;
		margin-top: 25px;
		font-size: 20px;
		font-weight: bold;
	}
	.func_perfume{
		margin-left: 70px;
	}
	.func_perfume p{
		font-size: 16px;
		font-weight: bold;
		margin-bottom: 5px;
	}
	.sales a{
		text-decoration: none;
		color: black;
	}
	.signout{
		margin-top: 30px;
	}
	.section{
		float: left;
		width: 70%;
	}
	.mybrand{
		font-size: 40px;
		font-weight: bolder;
		color: #F55A88;
		margin-left: 45%;
		margin-bottom: 20px;
		margin-top: 20px;
	}
	.navbar{
		float: left;
		width: 100%;
		height: 100px;
		display: flex;
		gap: 100px; 
		
		
	}
	.btn_add input[type="submit"]{
		width: 100px;
		height: 30px;
		background-color: black;
		color: white;
		margin-bottom: 20px;
		margin-top: 20px;
		margin-left: 20px;
		font-size: 14px;
		border-radius: 5px;
		border: none;
	}
	.input_search{
		margin-right: -50px;
		margin-top: 20px;
	}
	.input_search label{
		font-size: 18px;
		font-weight: bold;
	}
	.input_search input[type="text"]{
		width: 300px;
		height: 30px;
		border-radius: 4px;
	}
	#btn_search{
		width: 100px;
		height: 30px;
		background-color:black;
		color: white;
		margin-bottom: 20px;
		font-size: 14px;
		border-radius: 5px;
		border: none;
	}

	.navbar a{
		text-decoration: none;
		color: black;
		font-weight: bold;	
		margin-top: 25px;
		font-size: 18px;	
		
	}
	.table_product{
		background-color: #F3ECEC;
		margin-left: 60px;
	}
	.table_product .header{
		text-align: center;
		font-weight: bold;
		background-color: #D9D9D9;
		
	}
	 .table_product td{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="tong">
		<div class="aside">
			<div class="admin">
				<img alt="khong" src="icons/setting.png" style="width: 44px; height: 44px;">
				<p>Admin01</p>
				
			</div>
			<hr>
			<div class="perfume">
				<div class="perfume_icon">
					<img alt="" src="icons/perfume.png" style="width: 44px; height: 44px;">
					<p>Nước hoa</p>
				</div>
				
				<div class="func_perfume">
					<p><a>>Thương hiệu</a></p>
					<br>
					<p><a>>Sản phẩm</a></p>
					
				</div>
			</div>
			<div class="sales">
				<img alt="" src="icons/increase.png"  style="width: 44px; height: 44px;">
				<p><a href="DoanhThu.jsp">Doanh thu</a></p>
			</div>
			
			<div class="signout">
				<img alt="" src="icons/logout.png" style="width: 44px; height: 44px;">
				<p><a href="/20096651_DinhNguyetQuynh_Project31/LogoutServlet">Đăng xuất</a></p>
			</div>
		</div>
		<div class="section">
			<p class="mybrand">Your Dream</p>
			
			
			
			<div class="navbar">
				<div class="btn_add">
				<form action="QLSanPhamServlet" method="post">
					<input type="submit" name="action" value="Add">
				</form>
				</div>
				
					
						<a href="reloadProducts">Tất cả sản phẩm</a>
				
				
				<div class="input_search">
				<form action="QL_TimKiemServlet" method="get">
					
					<input type="text" name="product_name">
					<input type="submit" value="Tìm kiếm" id="btn_search">
				</form>
				
				</div>
			
			</div>
			
			
		
			<div class="table">
				<table width="100%" class="table_product" border=1>
				<tr class="header">
					<td>STT</td>
					<td>Hình ảnh</td>
					<td>Tên sản phẩm</td>
					<td>Giá</td>
					<td>Số lượng còn</td>
					<td>Mô tả</td>
					<td>Chức năng</td>
				</tr>
				<c:forEach var="pro" items="${ds}">
				<form action="QLSanPhamServlet" method="post">
					<tr>
						<td>
							${pro.productId }
							<input type="hidden" name="productId" value="${pro.productId }">
						</td>
						<td><img alt="" src="${pro.imgURL }" style="width: 100px;height: 100px"></td>
						<td>${pro.productName }</td>
						<td><fmt:formatNumber value="${pro.price}" type="number"  groupingUsed="true" /></td>
						<td><input type="text" value="${pro.stock }" name="quantity"></td>
						<td>${pro.description}</td>
						<td>
							<input type="submit" name="action" value="Edit" size="3"> <br><br>
							<input type="submit" name="action" value="Delete" size="3">
							
						</td>
					</tr>
				</form>
				</c:forEach>
		

					
				</table>
		
				
			</div>
		</div>
		 
	</div>
	

</body>
</html>