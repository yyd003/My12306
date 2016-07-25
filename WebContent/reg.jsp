<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注册信息</title>
	<link rel="stylesheet" type="text/css" href="css/UserRegistration.css">
	 <script type="text/javascript">
	// var req=false;
	// // 处理请求
	// function processRequest(){
	// 	if(window.XMLHttpRequest){
	// 		req =new XMLHttpRequest();
	// 	}else if(window.ActiveXObject){
	// 	req =new ActiveXObject("Microsoft.XMLHTTP");
	// 	}
	// 	if(req){
	// 		var url="register?action=check";
	// 		req.open("post",url,false);
	// 		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	// 		var username=document.getElementById("username").value;
	// 		req.onreadystatechange=updatePage;
	// 		req.send("username="+username);
	// 	}
	// }

	// function updatePage(){
	// 	if(req.readysta==4){
	// 		if(req.status==200){
	// 			var res=req.responseText;
	// 			if(res == 1){
	// 				document.getElementById("res").innerHTML="可以使用";
	// 			}else{
	// 				document.getElementById("res").innerHTML="已经被占用";
	// 				document.getElementById("username").focus();
	// 			}
	// 		}
	// 	}
	// }
	 </script> 
</head>
<body>
	<form action="register" method="post">
		<fieldset>			
				<div id = "header" class="box">
				head
				</div>

				<div id = "leftera" class = "box fl">
					left
				</div>

				<div id = "rightera" class = "box fr">
				<form>
		<fieldset>
			<div style = padding:1px;width = 600px>
			<font color = "blue" size = "2"><b>注册信息</b></font>
			<hr>
			<font color = "grey" size = "1">注：标有<font color = "red">*</font>处，为必填项</font>
					<h5>登录信息</h5>
					<table width = '100%'>
						<tr>
							<td width = '10%'><font color = "red">*</font>登陆名：</td>
							<td width = '75%'><input type="text" id = "username" name="username" required = "true" onblur="processRequest()"><font color = "grey">由字母、数字或“_”组成，长度不少于6位，不多于30位</font></td><td><font color = "red"><span id = "res"></span></font></td>
						</tr>
						<tr>
							<td><font color = "red">*</font>密码：</td>
							<td><input type="password" id = "psw1" required = "true" name="password"onkeyup="checkStrength()"><font color = "grey">不少于6位字符</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "strength"></span></td>	
						</tr>
						<tr>
							<td><font color = "red">*</font>确认密码：</td>
							<td><input type="password" id = "psw2" required = "true" onblur="checkPSW()"><font color = "grey">请再次输入密码</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "pswInfo"></span></td>
						</tr>
					</table>
				</div>
				<div style = padding:1px;width = 600px>
				 	<h5>详细信息</h5>
				 	<table width = '100%'>
				 		<tr>
				 			<td width="15%"><font color = "red">*</font>真实姓名：</td>
				 			<td width ="85%"><input type="text" id = "realname" name="realname" required = "true"></td>
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>性别：</td>
				 			<td>
				 				<input id="sex" type="radio" checked="checked" name="sex" value="1"/>男
				 				<input id="sex" type="radio"  name="sex" value="2"/>女
				 			</td>
				 		</tr>
				 		<tr> 					
				 			<td><font color = "red">*</font>省份：</td>
				 			<td>
				 			<select id = "province" name="province">
				 				<option value = "省份" selected = "selected">省份</option>
				 			</select>
							城市：
				 			<select id = "city" name="city">
				 				<option value = "城市" selected = "selected">城市</option>
				 			</select>	 						
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>证件类型：</td>
				 			<td>
				 				<select id = "certType" name="certType">
				 					<option value = "1">二代身份证</option>
				 					<option value = "2">港澳通行证</option>
				 					<option value = "3">台湾通行证</option>
				 					<option value = "4">护照</option>
				 				</select>
				 			</td>
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>证件号码：</td>
				 			<td><input type="text" id = "certNumber" required = "true" name="cert"></td>
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>出生日期</td>
				 			<td><input type="date" id = "birth" required = "true" name="birth"></td>
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>旅客类型：</td>
				 			<td>
				 				<select id = "userType" name="userType">
				 					<option value = "1">成人</option>
				 					<option value = "2">儿童</option>
				 					<option value = "3">学生</option>
				 					<option value = "4">残疾军人、伤残人民警察</option>
				 				</select>
				 			</td>
				 		</tr>	
				 		<tr>
				 			<td>备注：</td>
				 			<td><textarea rows="6" cols="60"></textarea></td>
				 		</tr>
				 	</table>

				</div>
				<center>
					<input type="submit" value = "提交">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value = "重置">
				</center>
				
		</fieldset>
	</form>
</div>
				
		</fieldset>
	</form>
	<script type="text/javascript" src = "js/register.js"></script>
</body>
</html>