<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>æ³¨åä¿¡æ¯</title>
	<link rel="stylesheet" type="text/css" href="css/UserRegistration.css">
	// <script type="text/javascript">
	// var req=false;
	// // å¤çè¯·æ±
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
	// 				document.getElementById("res").innerHTML="å¯ä»¥ä½¿ç¨";
	// 			}else{
	// 				document.getElementById("res").innerHTML="å·²ç»è¢«å ç¨";
	// 				document.getElementById("username").focus();
	// 			}
	// 		}
	// 	}
	// }
	// </script> 
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
			<font color = "blue" size = "2"><b>æ³¨åä¿¡æ¯</b></font>
			<hr>
			<font color = "grey" size = "1">æ³¨ï¼æ æ<font color = "red">*</font>å¤ï¼ä¸ºå¿å¡«é¡¹</font>
					<h5>ç»å½ä¿¡æ¯</h5>
					<table width = '100%'>
						<tr>
							<td width = '10%'><font color = "red">*</font>ç»éåï¼</td>
							<td width = '75%'><input type="text" id = "username" name="username" required = "true" onblur="processRequest()"><font color = "grey">ç±å­æ¯ãæ°å­æâ_âç»æï¼é¿åº¦ä¸å°äº6ä½ï¼ä¸å¤äº30ä½</font></td><td><font color = "red"><span id = "res"></span></font></td>
						</tr>
						<tr>
							<td><font color = "red">*</font>å¯ç ï¼</td>
							<td><input type="password" id = "psw1" required = "true" name="password"onkeyup="checkStrength()"><font color = "grey">ä¸å°äº6ä½å­ç¬¦</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "strength"></span></td>	
						</tr>
						<tr>
							<td><font color = "red">*</font>ç¡®è®¤å¯ç ï¼</td>
							<td><input type="password" id = "psw2" required = "true" onblur="checkPSW()"><font color = "grey">è¯·åæ¬¡è¾å¥å¯ç </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "pswInfo"></span></td>
						</tr>
					</table>
				</div>
				<div style = padding:1px;width = 600px>
				 	<h5>è¯¦ç»ä¿¡æ¯</h5>
				 	<table width = '100%'>
				 		<tr>
				 			<td width="15%"><font color = "red">*</font>çå®å§åï¼</td>
				 			<td width ="85%"><input type="text" id = "realname" name="realname" required = "true"></td>
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>æ§å«ï¼</td>
				 			<td>
				 				<input id="sex" type="radio" checked="checked" name="sex" value="1"/>ç·
				 				<input id="sex" type="radio"  name="sex" value="2"/>å¥³
				 			</td>
				 		</tr>
				 		<tr> 					
				 			<td><font color = "red">*</font>çä»½ï¼</td>
				 			<td>
				 			<select id = "province" name="province">
				 				<option value = "çä»½" selected = "selected">çä»½</option>
				 			</select>
							åå¸ï¼
				 			<select id = "city" name="city">
				 				<option value = "åå¸" selected = "selected">åå¸</option>
				 			</select>	 						
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>è¯ä»¶ç±»åï¼</td>
				 			<td>
				 				<select id = "certType" name="certType">
				 					<option value = "1">äºä»£èº«ä»½è¯</option>
				 					<option value = "2">æ¸¯æ¾³éè¡è¯</option>
				 					<option value = "3">å°æ¹¾éè¡è¯</option>
				 					<option value = "4">æ¤ç§</option>
				 				</select>
				 			</td>
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>è¯ä»¶å·ç ï¼</td>
				 			<td><input type="text" id = "certNumber" required = "true" name="cert"></td>
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>åºçæ¥æ</td>
				 			<td><input type="date" id = "birth" required = "true" name="birth"></td>
				 		</tr>
				 		<tr>
				 			<td><font color = "red">*</font>æå®¢ç±»åï¼</td>
				 			<td>
				 				<select id = "userType" name="userType">
				 					<option value = "1">æäºº</option>
				 					<option value = "2">å¿ç«¥</option>
				 					<option value = "3">å­¦ç</option>
				 					<option value = "4">æ®ç¾åäººãä¼¤æ®äººæ°è­¦å¯</option>
				 				</select>
				 			</td>
				 		</tr>	
				 		<tr>
				 			<td>å¤æ³¨ï¼</td>
				 			<td><textarea rows="6" cols="60"></textarea></td>
				 		</tr>
				 	</table>

				</div>
				<center>
					<input type="submit" value = "æäº¤">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value = "éç½®">
				</center>
				
		</fieldset>
	</form>
</div>
				
		</fieldset>
	</form>
	<script type="text/javascript" src = "js/register.js"></script>
</body>
</html>