<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="rightside">
			<h1>登录用户</h1>
			<br/>
			<c:if test="${employee!=null}">
			<h3>${employee.name}</h3>
			</c:if>
			<c:if test="${employee==null}">
			<h3>未登录</h3>
			</c:if>
			
			
		
			<h1>便捷操作</h1>
			<ul class="linklist">
				<li><a href="../employee/tochangepassword.do">修改密码</a></li>
				<li><a href="../logout.do">注销登录</a></li>
				<li><a href="../download/cityoaweb.zip">项目代码下载</a></li>
			</ul>
</div>