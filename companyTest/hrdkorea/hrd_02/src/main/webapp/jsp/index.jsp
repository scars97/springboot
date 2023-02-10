<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="hrd_02.DBConnect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원가입 프로그램</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<header id="header">
		<jsp:include page="../include/header.jsp"></jsp:include>
	</header>
	
	<nav id="nav">
		<jsp:include page="../include/nav.jsp"></jsp:include>
	</nav>
	
	<!-- Content -->
	<section class="section">
		<h2>쇼핑몰 회원관리프로그램</h2>
		<p>
			쇼핑몰 회원정보와 회원 매출 정보 데이터베이스를 구축하고 회원 프로그램 작성하는 프로그램입니다. <br> 
			프로그램 작업 순서<br> 
			1. 회원 정보 테이블을 생성한다. <br> 
			2. 매출 정보 테이블을 생성한다. <br>
			3. 회원 정보, 매출 정보 테이블에 제시된 문제지외 정보 테이터를 추가 설정한다.<br> 
			4. 회원 정보 입력 화면 프로그램을 작성한다.<br> 
			5. 회원정보 조회 프로그램을 작성한다.<br> 
			6. 회원매출 정보조회프로그램을 작성한다.
	</section>

	<footer id="footer">
	<jsp:include page="../include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>