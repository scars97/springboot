<%@page import="member.MemberDTO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		int custno = 0;
		String custname = null;
		String phone = null;
		String address = null;
		String joindate = null;
		String grade = null;
		String city = null;
		
		if(request.getParameter("custno") != null){
			custno = Integer.parseInt(request.getParameter("custno"));
		}
		if(request.getParameter("custname") != null){
			custname = (String)request.getParameter("custname");
		}
		if(request.getParameter("phone") != null){
			phone = (String)request.getParameter("phone");
		}
		if(request.getParameter("address") != null){
			address = (String)request.getParameter("address");
		}
		if(request.getParameter("joindate") != null){
			joindate = (String)request.getParameter("joindate");
		}
		if(request.getParameter("grade") != null){
			grade = (String)request.getParameter("grade");
		}
		if(request.getParameter("city") != null){
			city = (String)request.getParameter("city");
		}
		
		MemberDAO memberDao = new MemberDAO();
		int result = memberDao.join(custno, custname, phone, address, joindate, grade, city);
		if(result == -1){
			%>
			<script>
				alert("이미 존재하는 회원입니다. 입력 오류");
				history.back();
				frml.custname.focus();
			</script>
			<% 
		}else {
			session.setAttribute("custno", custno);
			%>
			<script>
				alert("회원등록이 완료되었습니다.");
				location.href="index.jsp";
			</script>
			<% 
		}
		%>
</body>
</html>