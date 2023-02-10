<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>메뉴</title>
<style type="text/css">
nav {
	text-align: center;
	font-size: 2em;
	color: white;
	background-color: black;
	height: 60px;
	line-height: 60px;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	background-color: gray;
}

ul:after {
	content: '';
	display: block;
	clear: both;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}
</style>
</head>
<body>
	<header style="margin-bottom: 30px;">
		<!-- Title -->
		<nav>쇼핑몰 회원 관리 ver 1.0</nav>
		
		<!-- List -->
		<ul>
			<li><a href="enroll.jsp">회원등록</a>
			<li><a href="lookup.jsp">회원목록/조회/수정</a>
			<li><a href="salesCheck.jsp">회원매출 조회</a>
			<li><a href="index.jsp">홈으로</a>
		</ul>
	</header>
</body>
</html>