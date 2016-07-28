<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>我的12306 ｜ 系统管理</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script src="../bootstrap/js/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/admin.js"></script>
</head>
<body>
	<form class="form-horizontal">
		<div id="title" align="center"></div>
		<hr>
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-6">
				<input type="hidden" name="uId" id="uId" value="${userData.id}">
				<input type="text" class="form-control" name="username"
					id="username" value="${userData.username}" placeholder="请输入名字"><span
					id="uCheck"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="realname" class="col-sm-2 control-label">真实名</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="realname"
					id="realname" value="${userData.realname}" placeholder="请输入真实名">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">请选择角色</label>
			<div class="col-sm-6">
				<select class="form-control" name="rule" id="rule">
					<option value="1">管理员</option>
					<option value="2">普通用户</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">性别</label>
			<div class="col-sm-6">
				<select class="form-control" name="sex" id="sex">
					<option value="1">男</option>
					<option value="０">女</option>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">省</label>
			<div class="col-sm-2">
				<select class="form-control" id="province" name="province">
					<c:forEach items="${provinceData.data}" var="s" varStatus="s1">
						<option value="<c:out value="${s.provinceId}" />"><c:out
								value="${s.province}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<label for="lastname" class="col-sm-2 control-label">市</label>
			<div class="col-sm-2">
				<select class="form-control" id="city" name="city">
					<option value="1">管理员</option>
					<option value="2">普通用户</option>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">证件类型</label>
			<div class="col-sm-6">
				<select class="form-control" id="certType" name="certType">
					<c:forEach items="${certTypeData.data}" var="s" varStatus="s1">
						<option value="<c:out value="${s.id}" />"><c:out
								value="${s.content}" />
						</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">证件号码</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="cert" value="${userData.cert}" name="cert"
					placeholder="请输入证件号码">
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">出生日期</label>
			<div class="col-sm-6">
				<input type="date" class="form-control" id="birthday"
					value="${userData.birthday}"  name="birthday">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">旅客类型</label>
			<div class="col-sm-6">
				<select class="form-control" id="userType" name="userType">
					<c:forEach items="${userTypeData.data}" var="s" varStatus="s1">
						<option value="<c:out value="${s.id}" />"><c:out
								value="${s.content}" />
						</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">备注</label>
			<div class="col-sm-6">
				<textarea class="form-control" rows="3" id="content" value="${userData.content}" name="content"></textarea>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-7">
				<button type="button" class="btn btn-danger btn-large btn-block"
					id="uEditAddBtn">添加用户</button>
			</div>
		</div>
	</form>

</body>
</html>