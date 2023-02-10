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

	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>


	<!-- Content -->
	<h2 style="text-align: center;">홈쇼핑 회원 등록</h2>

	<form method="POST" action="enrolement.jsp" name="frml">
		<table border="2" style="margin-left: auto; margin-right: auto; width: 70%;">
			<tr>
				<th>회원번호(자동발생)</th>
				<td><input type="text" name="custno" ></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname" id="custname"></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="text" name="phone" id="phone"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address" id="address"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><input type="text" name="joindate" id="joindate"></td>
			</tr>
			<tr>
				<th>고객등급(A:VIP,B:일반,C:직원)</th>
				<td><input type="text" name="grade" id="grade"></td>
			</tr>
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city" id="city"></td>
			</tr>
			<tr>
				<td colspan="2" align= "center">
					<input type="submit" value="등록">
					<input type="button" onclick="location.href='lookup.jsp'" value="조회">
				</td>
			</tr>
		</table>
		
	</form>

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

<script>
	function insert(){

		if(frml.custname.value == ""){
			alert("회원성명이 입력되지 않았습니다.");
			frml.custname.focus();
			return false;
		}else if(frml.phone.value == ""){
			alert("회원전화가 입력되지 않았습니다.");
			frml.phone.focus();
			return false;
		}else if(frml.address.value == ""){
			alert("회원주소가 입력되지 않았습니다.");
			frml.address.focus();
			return false;
		}else if(frml.joindate.value == ""){
			alert("가입일자가 입력되지 않았습니다.");
			frml.joindate.focus();
			return false;
		}else if(frml.grade.value == ""){
			alert("고객등급 입력되지 않았습니다.");
			frml.grade.focus();
			return false;
		}else if(frml.city.value == ""){
			alert("도시코드가 입력되지 않았습니다.");
			frml.city.focus();
			return false;
		}else{
			alert("회원등록이 완료 되었습니다.");
		}
		
	}
</script>
</body>
</html>