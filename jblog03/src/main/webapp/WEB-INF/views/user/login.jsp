<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo" style="background:url(${pageContext.request.contextPath}/assets/images/logo.jpg) no-repeat 0 0">JBlog</h1>
		<ul class="menu">
			<c:choose>
				<c:when test="${empty authUser }">
					<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>	
					<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/blog-main">내블로그</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<form id="login-form" name="loginform" method="post" action="${pageContext.request.contextPath }/user/auth">
      		<label>아이디</label> <input type="text" name="id"><br/><br/>
      		<label>패스워드</label> <input type="text" name="password">
      		<c:if test='${result == "fail" }'>
						<p>잘못된 ID 혹은 PASSWORD 입니다.</p>
			</c:if>
      		<input type="submit" value="로그인">
		</form>
	</div>
</body>
</html>
