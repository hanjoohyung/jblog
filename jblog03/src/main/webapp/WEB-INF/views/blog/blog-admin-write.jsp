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
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${vo.title}</h1>
			<ul>
			<c:choose>
				<c:when test="${empty authUser }">
					<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>	
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/blog-admin-basic/${authUser.id}">블로그 관리</a></li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath}/blog/blog-main/${authUser.id}/${categoryVo.no}/${postVo.no}">블로그</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/blog-admin-basic/${authUser.id}">기본설정</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/blog-admin-category/${authUser.id}">카테고리</a></li>
					<li class="selected">글작성</li>
				</ul>
				<form action="${pageContext.request.contextPath}/blog/add/${authUser.id}" method="post">
				
			      	<table class="admin-cat-write">
			      		<tr>
			      			<td class="t">제목</td>
			      			<td>
			      				<input type="text" size="60" name="title">
				      			<select name="category">
				      				<c:set var='no' value='${fn:length(list) }' />
										<c:forEach items='${list }' var='categoryVo' varStatus='status'>										
												<option value="${categoryVo.no}">${categoryVo.name}</option>
										</c:forEach>
				      			</select>
				      		</td>
			      		</tr>
			      		<tr>
			      			<td class="t">내용</td>
			      			<td><textarea name="contents"></textarea></td>
			      		</tr>
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td class="s"><input type="submit" value="포스트하기"></td>
			      		</tr>
			      	</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>