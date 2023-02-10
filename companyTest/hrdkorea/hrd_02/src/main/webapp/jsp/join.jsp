<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="hrd_02.DBConnect" %>	

<%
	String sql = "select max(custno) from member_tbl_02";
	Connection conn = DBConnect.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	rs.next();
	int maxCustno = rs.getInt(1)+1;
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


	<section class="section">
		<h2>홈쇼핑 회원 등록</h2>
		<form name="join" method="post" onsubmit="return chkVal()" 
			action="join_p.jsp">
			<table class="joinTable">
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input style="background-color: gray; color: white;"
						type="text" name="custno" value="<%= maxCustno %>" readonly></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" size="20"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" size="20"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" size="20"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" size="20"></td>
				</tr>
				<tr>
					<th>고객등급</th>
					<td><input type="text" name="grade" size="20"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" size="20"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록하기">
						<button type="button" onclick="location.href='member_list.jsp'">조회하기</button>
					</td>
				</tr>
			</table>
		</form>

	</section>

	<footer id="footer">
		<jsp:include page="../include/footer.jsp"></jsp:include>
	</footer>
	
<script>
	function chkVal(){
		
		if(join.custname.value == ""){
			alert("회원성명이 입력되지 않았습니다.");
			join.custname.focus();
			return false;
		}else if(join.phone.value == ""){
			alert("전화번호가 입력되지 않았습니다.");
			join.phone.focus();
			return false;
		}else if(join.address.value == ""){
			alert("주소가 입력되지 않았습니다.");
			join.address.focus();
			return false;
		}else if(join.joindate.value == ""){
			alert("가입일자가 입력되지 않았습니다.");
			join.joindate.focus();
			return false;
		}else if(join.grade.value == ""){
			alert("고객등급이 입력되지 않았습니다.");
			join.grade.focus();
			return false;
		}else if(join.city.value == ""){
			alert("도시코드가 입력되지 않았습니다.");
			join.city.focus();
			return false;
		}
		
		alert("회원등록이 완료되었습니다.");
		return true;
	}
</script>
</body>
</html>