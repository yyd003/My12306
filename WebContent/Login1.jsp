<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12306订票系统</title>
<link rel="stylesheet" type="text/css" href="css/Login.css">

<script type="text/javascript">
	function createCode(len)  
        {  
            var seed = new Array(  
                    'abcdefghijklmnopqrstuvwxyz',  
                    'ABCDEFGHIJKLMNOPQRSTUVWXYZ',  
                    '0123456789'  
            );               //创建需要的数据数组  
            var idx,i;  
            var result = '';   //返回的结果变量  
            for (i = 0; i < len; i++) //根据指定的长度  
            {  
                idx = Math.floor(Math.random()*3); //获得随机数据的整数部分-获取一个随机整数  
                result += seed[idx].substr(Math.floor(Math.random()*(seed[idx].length)), 1);//根据随机数获取数据中一个值  
            }  
            return result; //返回随机结果  
        }  

        function test() {  
            var inputRandom=document.getElementById("inputRandom").value;  
            var autoRandom=document.getElementById("autoRandom").innerHTML;  
            if(inputRandom != autoRandom) {  
                alert("验证码输入错误");  
            } 
  
        }  	
	</script>
</head>
<body>
	<form action="login" method="post">
		<fieldset>
			<div id="header" class="box">head</div>

			<div id="leftera" class="box fl">left</div>

			<div id="rightera" class="box fr">
				<center>
					<h4>
						<font size="6" color="black">Login</font><font color="red">用户登录</font>
					</h4>
					</br>
					<table width=100%>
						<tr>
							<td width='20%'>用户名：</td>
							<td width='40%'><input type="text" id="username"
								name="username" required="true"></td>
						</tr>
						<tr>
							<td width='20%'>密码：</td>
							<td width='40%'><input type="password" id="password"
								name="password" required="true"></td>
						</tr>
						<tr>
							<td width='20%'>验证码：</td>
							<td width='40%'><input type="text" id="inputRandom"
								required="true" onblur="test()"></td>
							<td><label id="autoRandom" value=""></label>&nbsp<INPUT
								TYPE="button" VALUE="获取验证码"
								ONCLICK="autoRandom.innerHTML=createCode(4)"></td>
						</tr>
					</table>
					</br>
					</br> <input type="submit" value="登录"> &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="注册新用户"
						onclick="document.location.href='UserRegistration.jsp'">
					<!-- window.location.href ='register?action=show'; -->
				</center>
			</div>

		</fieldset>
	</form>
</body>
</html>