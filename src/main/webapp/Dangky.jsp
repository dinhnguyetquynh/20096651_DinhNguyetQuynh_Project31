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
	margin-top: 15%;
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
#district{
	width: 100%;
    padding: 5px;
    border: 1px solid #ccc;
  	border-radius: 4px;
}

</style>
<script>
function validateForm() {
    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;
    var password = document.getElementById("password").value;
    var rePassword = document.getElementById("rePassword").value;
    var address = document.getElementById("address").value;
    var district = document.getElementById("district").value;
    var city = document.getElementById("city").value;

    if (name == "" || phone == "" || password == "" || rePassword == "" || address == "" || district == "0" || city == "") {
        alert("Vui lòng điền đầy đủ thông tin");
        return false;
    }
    if (password !== rePassword) {
        alert("Mật khẩu không khớp");
        return false;
    }
    var phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(phone)) {
        alert("Số điện thoại không hợp lệ");
        return false;
    }
    return true;
}
</script>

</head>
<body>
	<div class="tong">
			<div class="aside">
			 	<img alt="khong hien thi duoc" src="images/background_register.jpg">
			</div>
			<div class="section">
						<h3>TẠO TÀI KHOẢN</h3>
				<div class="formDangKy">
					<form action="RegisterForm" method="post" accept-charset="UTF-8" onsubmit="return validateForm()">
						 <table>
					            <tr>
					                <td><img alt="khong hien thi duoc" src="icons/user.png" class="icon"></td>
					                <td><input type="text" id="name" name="name" placeholder="Họ tên"></td>
					            </tr>
					            
					        
					            
					            <tr>
					                <td><img alt="khong hien thi duoc" src="icons/phone-call.png" class="icon"></td>
					                <td><input type="tel" id="phone" name="phone" placeholder="Số điện thoại"></td>
					            </tr>
					            	     
					           
					            <tr>
					                <td><img alt="khong hien thi duoc" src="icons/padlock.png" class="icon"></td>
					                <td><input type="password" id="password" name="password" placeholder="Mật khẩu"></td>
					            </tr>
					            <tr>
					                <td><img alt="khong hien thi duoc" src="icons/key.png" class="icon"></td>
					                <td><input type="password" id="rePassword" name="rePassword" placeholder="Nhập lại mật khẩu"></td>
					            </tr>
					            
					             <tr>
					                <td><img alt="khong hien thi duoc" src="icons/maps-and-flags.png" class="icon"></td>
					                <td><input type="text" id="address" name="address" placeholder="Địa chỉ"></td>
					            </tr>
					            
					             <tr>
					                <td></td>
					                <td>
					                	<div >
					                		<select name="district" id="district" >
					                		<option value="0">Chọn Quận/Huyện:</option>
					                		<option value="1">Quận 1</option>
					                		<option value="2">Quận 2</option>
					                		<option value="3">Quận 3</option>
					                		<option value="4">Quận 4</option>
					                		<option value="5">Quận 5</option>
					                		<option value="6">Quận 6</option>
					                		<option value="7">Quận 7</option>
					                		<option value="8">Quận 8</option>
					                		<option value="9">Quận 9</option>
					                		<option value="10">Quận 10</option>
					                		<option value="11">Quận 11</option>
					                		<option value="12">Quận 12</option>
					                		<option value="TB">Quận Tân Bình</option>
					                		<option value="TP">Quận Tân Phú</option>
					                		<option value="BT">Quận Bình Tân</option>
					                		<option value="BTH">Quận Bình Thạnh</option>
					                		<option value="GV">Quận Gò Vấp</option>
					                		<option value="PN">Quận Phú Nhuận</option>
					                		<option value="BC">Huyện Bình Chánh</option>
					                		<option value="NB">Huyện Nhà Bè</option>
					                		<option value="HM">Huyện Hóc Môn</option>
					                		<option value="CC">Huyện Củ Chi</option>
					                		<option value="CG">Huyện Cần Giờ</option>
					                		
					                	</select>
					                	</div>
					                	
					                </td>
					            </tr>
					            
					            <tr>
					                <td></td>
					                <td><input type="text" id="city" name="city" value="TPHCM"></td>
					            </tr>
					         			
					            <tr>
					                <td></td>
					                <td><p>Bạn đã có tài khoản? <a href="#">Đăng nhập</a> </p></td>
					            </tr>
					            <tr>
					                <td colspan="2" style="text-align: center;">
					                	<input type="hidden" value="true" name="userRole">
					                    <input type="submit" value="Đăng ký">
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