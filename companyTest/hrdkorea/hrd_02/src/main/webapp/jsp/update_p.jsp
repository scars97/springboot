<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="hrd_02.DBConnect"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sql = "update member_tbl_02 set custname=?, phone=?,address=?,joindate=?,grade=?,city=? where custno=" + Integer.parseInt(request.getParameter("custno"));
	
	Connection conn = DBConnect.getConnection(); //DB연결
	PreparedStatement pstmt = conn.prepareStatement(sql); //쿼리문 담아서 보내줌

	//update될 값들 받아서 넣어줌.
	pstmt.setString(1, request.getParameter("custname"));
	pstmt.setString(2, request.getParameter("phone"));
	pstmt.setString(3, request.getParameter("address"));
	pstmt.setString(4, request.getParameter("joindate"));
	pstmt.setString(5, request.getParameter("grade"));
	pstmt.setString(6, request.getParameter("city"));

	pstmt.executeUpdate(); //insert,update,delete 쿼리문 사용
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="member_list.jsp"></jsp:forward>
</body>
</html>