<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../css/andreas09.css" title="andreas09" media="screen,projection" />
	<title>汽车修理系统</title>
</head>
<body>
<div id="container">
	<jsp:include page="../include/top.jsp"></jsp:include>
		<div id="wrap">
		<jsp:include page="../include/left.jsp"></jsp:include>
		<jsp:include page="../include/right.jsp"></jsp:include>
		

		<div id="content">
			
			<h3>部门管理-增加新部门</h3>
            <form action="add.do" method="post">
            <table width="100%"  border="0">
                          <tr>
                            <td width="20%">部门编码</td>
                            <td width="74%"><input type="text" name="id"></td>
                          </tr>
                          <tr>
                            <td>部门名称</td>
                            <td><input type="text" name="name"></td>
                          </tr>
                          <tr>
                            <td>部门地址</td>
                            <td><input type="text" name="addr"></td>
                          </tr>
                          <tr>
                            <td>部门电话</td>
                            <td><input type="text" name="tel"></td>
                          </tr>
                          <tr>
                            <td colspan="2"><div align="center">
                                <input type="submit" name="Submit" value="提交">
                                <input type="reset" name="Submit2" value="重置">
                            </div></td>
                            </tr>
             </table>
			</form>
			<div><a href="tomain.do">返回</a> </div>
			
			
		</div>
	<div class="clearingdiv">&nbsp;</div>
	</div>
</div>

<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>