<%@ page language="java" contentType="text/html; charset=UTF8"	pageEncoding="UTF8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="css/Login.css">
</head>
<body>
<form action="login" method="post">
    <center>  
   	<!-- <img src="image/1.jpg" alt=""> -->
   	<div style="position: absolute; z-index: 2; left: 150px; top: 30px"></div>
     	<div style="position: relative;">
		<img src="image/1.jpg" />
        <div style="position: absolute; z-index: 2; left: 650px; top: 150px">
			<table width="50%">
				<tr>
					<td width="20%">用户名：</td>
					<td width="30%"><input type="text" id="username" required = "true" autofocus = "true" name="username"></td>
				</tr>
				<tr>
					<td width="20%">密码：</td>
					<td width="30%"><input type="password" id="password" required = "true" name="password"></td>
				</tr>
				<tr>
					<td width="20%">验证码：</td>
					<td width="30%"><input type="text" id="checkNum" required = "true" onblur="test()"></td>
					<td><label id="autoRandom" value=""></label>&nbsp<INPUT
								TYPE="button" VALUE="获取验证码"
								ONCLICK="autoRandom.innerHTML=createCode(4)"></td>
				</tr>
			</table>
			<table width="30%">
				<tr>	
					<td width="10%"><input type="checkbox" id="autoLoad"></td>
					<td width="20%">自动登录</td>
				</tr>
			</table>
			<table width="10%">
				<tr>
					<td width="10%"><input type="submit" value="登录"></td>
					<td width="10%"><input type="button" value="注册" onclick="document.location.href='UserRegistration.jsp'"></td>
				</tr>
			</table>
			</div>
		</div>
  </center>
</form>
	
</body>
</html>