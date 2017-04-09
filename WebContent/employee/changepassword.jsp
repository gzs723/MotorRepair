<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="description" content="城市学院OA管理系统" />
	<meta name="keywords" content="OA JavaEE MVC" />
	<meta name="author" content="吕海东" />
	<link rel="stylesheet" type="text/css" href="../css/andreas09.css" title="andreas09" media="screen,projection" />
	<title>城市学院OA系统</title>
</head>
<body>
<div id="container">
	<jsp:include page="../include/top.jsp"></jsp:include>
		<div id="wrap">
		<jsp:include page="../include/left.jsp"></jsp:include>
		<jsp:include page="../include/right.jsp"></jsp:include>
		

		<div id="content">
			
			<h3>员工管理-增加新员工</h3>
			<c:if test="${employee!=null}">
            <form action="changepassword.do" method="post">
            <table width="100%"  border="0">
                          <tr>
                            <td width="10%">原密码</td>
                            <td width="74%"><input type="text" name="oldpassword"></td>
                          </tr>
                          <tr>
                            <td>新密码</td>
                            <td><input type="text" name="newpassword"></td>
                          </tr>
                         
                          <tr>
                            <td>新密码确认</td>
                            <td><input type="text" name="newpasswordconfirm"></td>
                          </tr>
                          
                          <tr>
                            <td colspan="2"><div align="center">
                                <input type="submit" name="Submit" value="提交">
                                <input type="reset" name="Submit2" value="重置">
                            </div></td>
                          </tr>
             </table>
			</form>			
			</c:if>
			<c:if test="${employee==null}">
			   <h3>对不起，您没有登录，无法修改密码</h3>
			</c:if>
			<div><a href="tomain.do">返回</a> </div>
			
			
		</div>
	<div class="clearingdiv">&nbsp;</div>
	</div>
</div>

<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>