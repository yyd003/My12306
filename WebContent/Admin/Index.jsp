<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<meta charset="UTF-8">
	<title>Admin</title>
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
	<script src="../bootstrap/js/jquery.min.js"></script>
	<script   src="../bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
			    <div class="col-md-3 column">
					<div class="panel-group" id="panel-267760">
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title" data-toggle="collapse" data-parent="#panel-267760" href="#panel-element-460944">用户数据维护</a>
							</div>
							<div id="panel-element-460944" class="panel-collapse collapse in">
								<div class="panel-body">
									用户管理
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title" data-toggle="collapse" data-parent="#panel-267760" href="#panel-element-776787">Collapsible Group Item #2</a>
							</div>
							<div id="panel-element-776787" class="panel-collapse collapse">
								<div class="panel-body">
									Anim pariatur cliche...
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-9 column">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>
									编号
								</th>
								<th>
									用户名
								</th>
								<th>
									真实名
								</th>
								<th>
									性别
								</th>
								<th>
									证件类型
								</th>
								<th>
									证件号码
								</th>
								<th>
									旅客类型
								</th>
								<th>
									所在城市
								</th>
							</tr>
						</thead>
						<tbody>
				<c:forEach items="${data.users}" var="s" varStatus="s1">
					<tr>
						<td>
							<c:out value="${s.id}" />
						</td>
						<td>
							<c:out value="${s.username}" />
						</td>
						<td>
							<c:out value="${s.realname}" />
						</td>
						<td>
							<c:out value="${s.sex}" />
						</td>
						<td>
							<c:out value="${s.cert_type.content}" />
						</td>
						<td>
							<c:out value="${s.cert}" />
						</td>
						<td>
							<c:out value="${s.user_type.content}" />
						</td>
						<td>
							<c:out value="${s.city.city}" />
						</td>
					</tr>
	        	</c:forEach>
							</tr>
						</tbody>
					</table>
				</div>	
			</div>
		</div>
	</div>
</div>
</body>
</html>
