<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "hrd_02.DBConnect" %>  	

<%
	String sql = "select custno,custname,phone,address,joindate,decode(grade,'A','VIP','B','일반','C','직원'),city from member_tbl_02";
	Connection conn = DBConnect.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();

%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h2>회원목록조회/수정</h2>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			
			<%
				while(rs.next()){
			%>
			
			<tr>
				<td style="color: blue;">
				<a href="update.jsp?custno=<%= rs.getString("custno")%>">
				<%= rs.getInt(1) %></a></td>
				<td><%= rs.getString(2) %></td>
				<td><%= rs.getString(3) %></td>
				<td><%= rs.getString(4) %></td>
				<td><%= rs.getString(5) %></td>
				<td><%= rs.getString(6) %></td>
				<td><%= rs.getString(7) %></td>
			</tr>
			
			<%
				}
			%>
		</table>
	</section>

	<footer id="footer">
		<jsp:include page="../include/footer.jsp"></jsp:include>
	</footer>
</body>
</html>