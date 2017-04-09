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
			
			<h3>员工管理-查看员工</h3>
           
            <table width="100%"  border="0">
                          <tr>
                            <td width="10%">员工编号</td>
                            <td width="74%">${ev.empid}</td>
                          </tr>
                        
                         <tr>
                            <td>部门编号</td>
                            <td>${ev.depid }</td>
                          </tr>
                          <tr>
                            <td>员工姓名</td>
                            <td>${ev.name }</td>
                          </tr>
                          <tr>
                            <td>员工性别</td>
                            <td>${ev.sex }</td>
                          </tr>
                          <tr>
                            <td>电话号码</td>
                            <td>${ev.tel}</td>
                          </tr>
                          
                          <tr>
                            <td>邮箱</td>
                            <td>${ev.email }</td>
                          </tr>
                          
                        
                       
                         
             </table>
			
			<div><a href="tomain.do">返回</a> </div>
			
			
		</div>
	<div class="clearingdiv">&nbsp;</div>
	</div>
</div>

<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>