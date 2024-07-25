<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
.aside{
	width: 50%;
	height: 95%;
	float: left;
	
}
.aside img{
	width: 100%;
	height: auto;
	margin-top: 20%;
}



.section{
	width: 50%;
	height: 95%;
	float: left;
	
	
}
.section h3{
	text-align: center;
	margin-top: 35%;
	margin-bottom: 50px;
	font-size: 35px;
}

table {
	width: 80%;
    
}
 td {
    padding: 10px;
 }
 input[type="text"], input[type="password"] {
    width: 100%;
    padding: 5px;
    border: 1px solid #ccc;
  	border-radius: 4px;
}
input[type="submit"]{
	width: 30%;
	height: 50px;
	margin-top: 20px;
	background-color: #ffc2d1;
	font-size: 20px;
	font-weight: bold;
	border: none;
	border-radius: 4px;
}
label{
	font-weight: bold;
}
.icon{
	width: 24px;
	height: 24px
}
.footer{
	width: 100%;
	height: 5%;
	float: left;
	text-align: center;
	margin-top: 100px;
	
}
.footer p{
	font-size: 35px;
	color: #ffc2d1;
	font-weight: bolder;
	font-style: oblique;
	font-family: "Sofia", sans-serif;
}

</style>
</head>
<body>
	<div class="tong">
			<div class="aside">
			 	<img alt="khong hien thi duoc" src="images/background_register.jpg">
			</div>
			<div class="section">
						<h3>ĐĂNG NHẬP</h3>
				<div class="formDangKy">
					<form action="LoginServlet" method="post"  accept-charset="UTF-8">
						 <table>
					            
					            <tr>
					                <td><img alt="khong hien thi duoc" src="icons/phone-call.png" class="icon"></td>
					                <td><input type="text" id="soDienThoai" name="phone" placeholder="Số điện thoại"></td>
					            </tr>
					           
					            <tr>
					                <td><img alt="khong hien thi duoc" src="icons/padlock.png" class="icon"></td>
					                <td><input type="password" id="matKhau" name="password" placeholder="Mật khẩu"></td>
					            </tr>
					           
					            <tr>
					                <td></td>
					                <td><p>Bạn chưa có tài khoản? <a href="#">Đăng ký</a> </p></td>
					            </tr>
					            <tr>
					                <td colspan="2" style="text-align: center;">
					                    <input type="submit" value="Đăng nhập">
					                </td>
					            </tr>
					       </table>
					</form>
					
				</div>
			
					
				
			</div>
			<div class="footer">
						<p>YourDream Perfume</p>
			</div>
	</div>
	
</body>
</html>