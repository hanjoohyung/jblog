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
			<div id="content">
				<div class="blog-content">
					<c:set var='no' value='${fn:length(postlist1) }' />
						<c:forEach items='${postlist1 }' var='postVo' varStatus='status'>	
								<h4>${postVo.title }</h4>
								<p>${postVo.contents}</p>
						</c:forEach>
				</div>
				<ul class="blog-list">
					<c:set var='no' value='${fn:length(postlist) }' />
						<c:forEach items='${postlist }' var='postVo' varStatus='status'>	
								<li>
									<a href="${pageContext.request.contextPath}/blog/blog-main/${authUser.id}/${postVo.categoryNo}/${postVo.no}">${postVo.title}</a>
									<span>${postVo.regDate}</span>
								</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img id="logo" src="${pageContext.request.contextPath}${vo.logo}">
			</div>
		</div>
		<div id="navigation">
					<h2>카테고리</h2>
					<ul>
						<c:set var='no' value='${fn:length(list) }' />
							<c:forEach items='${list }' var='categoryVo' varStatus='status'>	
									<tr>
										<td><a href="${pageContext.request.contextPath}/blog/blog-main/${authUser.id}/${categoryVo.no}/${postVo.no}">
											${categoryVo.name}</a></td></br>
									</tr>
							</c:forEach>
					</ul>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>