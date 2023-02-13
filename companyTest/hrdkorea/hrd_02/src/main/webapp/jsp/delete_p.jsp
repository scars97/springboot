<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="hrd_02.DBConnect"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sql = "delete from member_tbl_02 where custno=?";
	
	Connection conn = DBConnect.getConnection(); //DB연결
	PreparedStatement pstmt = conn.prepareStatement(sql); //쿼리문 담아서 보내줌

	pstmt.setInt(1, Integer.parseInt(request.getParameter("custno")));
	
	pstmt.executeUpdate(); //insert,update,delete 쿼리문 사용
	
	response.sendRedirect("member_list.jsp");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <jsp:forward page="member_list.jsp"></jsp:forward> --%>
</body>
</html>