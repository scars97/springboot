<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "hrd_02.DBConnect" %>  

<%
	request.setCharacterEncoding("UTF-8");
	String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?)";

	Connection conn = DBConnect.getConnection(); //DB연결
	PreparedStatement pstmt = conn.prepareStatement(sql); //쿼리문 담아서 보내줌
	
	//타입이 text로 보내지고 들어가야하는 값은 int로 들어가야하기때문에 형변화 해준 것 
	pstmt.setInt(1, Integer.parseInt(request.getParameter("custno")));
	pstmt.setString(2, request.getParameter("custname"));
	pstmt.setString(3, request.getParameter("phone"));
	pstmt.setString(4, request.getParameter("address"));
	pstmt.setString(5, request.getParameter("joindate"));
	pstmt.setString(6, request.getParameter("grade"));
	pstmt.setString(7, request.getParameter("city"));
	
	pstmt.executeUpdate(); //insert,update,delete 쿼리문 사용

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="index.jsp"></jsp:forward>
</body>
</html>