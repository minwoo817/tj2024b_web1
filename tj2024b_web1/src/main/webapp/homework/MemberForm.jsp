<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원관리</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
	<%@ include file="header.jsp" %>
<section>
    <h2>회원등록</h2>
    <form id="memberForm" action="MemberController" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="action" value="add">
        <label for="name">회원성명:</label>
        <input type="text" name="name" id="name"><br>

        <label for="phone">회원전화:</label>
        <input type="text" name="phone" id="phone"><br>

        <label for="address">회원주소:</label>
        <input type="text" name="address" id="address"><br>

        <label for="joinDate">가입일자:</label>
        <input type="date" name="joinDate" id="joinDate"><br>

        <label for="grade">고객등급:</label>
        <select name="grade" id="grade">
            <option value="A">VIP</option>
            <option value="B">일반</option>
            <option value="C">직원</option>
        </select><br>

        <label for="cityCode">도시코드:</label>
        <input type="text" name="cityCode" id="cityCode"><br>

        <button type="submit">등록</button>
    </form>
</section>
<%@ include file="footer.jsp" %>
	
</body>
</html>