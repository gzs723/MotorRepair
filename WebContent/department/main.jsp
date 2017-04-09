<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../css/andreas09.css" title="andreas09" media="screen,projection" />
	<title>汽车修理管理系统</title>
</head>
<body>
<div id="container">
	<jsp:include page="../include/top.jsp"></jsp:include>
	
 
	<div id="wrap">
		<jsp:include page="../include/left.jsp"></jsp:include>
		<jsp:include page="../include/right.jsp"></jsp:include>
		

		<div id="content">
			
			<h3>部门管理</h3>
                        <table width="100%" class=MsoTableGrid id="table1"  border="1"  style="BORDER-RIGHT: medium none; BORDER-TOP: medium none; BORDER-LEFT: medium none; BORDER-BOTTOM: medium none; BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0>
                          <tr bgcolor="#99CCFF">
                            <td width="20%">部门编号</td>
                            <td width="20%">部门名称</td>
                            <td width="20%">部门地址</td>
                            <td width="20%">电话号码</td>
                            <td width="20%">操作</td>
                          </tr>
                          <c:forEach var="dv" items="${departmentList}">                          
                          <tr>
                            <td>${dv.depid}</td>
                            <td>${dv.depname }</td>
                            <td>${dv.depaddr }</td>
                            <td>${dv.deptel }</td>  
                             <td><a href="tomodify.do?no=${dv.depid}">修改</a> <a href="delete.do?no=${dv.depid}">删除</a></td>
                          </tr>
                          </c:forEach>
                        </table>
                        <div><a href="toadd.do">增加新部门</a> </div>  
			
			
		</div>
	<div class="clearingdiv">&nbsp;</div>
	</div>
</div>

<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>