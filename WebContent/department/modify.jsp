<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/andreas09.css"
	title="andreas09" media="screen,projection" />
<title>汽车修理管理系统</title>
</head>
<body>

<div id="container">
		<jsp:include page="../include/top.jsp"></jsp:include>
		<div id="wrap">
			<jsp:include page="../include/left.jsp"></jsp:include>
			<jsp:include page="../include/right.jsp"></jsp:include>


			<div id="content">

				<h3>部门管理-修改部门</h3>
				<form action="modify.do" method="post">
					<table width="100%" border="0">

						<tr>
							<td>部门编号</td>
							<td><input type="text" name="depid" value="${dv.depid}"></td>
						</tr>
						<tr>
							<td>部门名称</td>
							<td><input type="text" name="depname" value="${dv.depname}"></td>
						</tr>
						<tr>
							<td>地址</td>
							<td><input type="text" name="depaddr" value="${dv.depaddr}"></td>
						</tr>
						<tr>
			

						<tr>
							<td>电话号码</td>
							<td><input type="text" name="deptel" value="${dv.deptel}"></td>
						</tr>

					</table>
					<br /> <br /> <input type="submit" value="提交">
				</form>
				<br /> <br />
				<div>
					<a href="tomain.do">返回</a>
				</div>


			</div>
			<div class="clearingdiv">&nbsp;</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp"></jsp:include>



</body>
</html>