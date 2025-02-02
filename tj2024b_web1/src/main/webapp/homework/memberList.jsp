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
    <h2>회원목록 조회/수정</h2>
    <table border="1">
        <thead>
            <tr>
                <th>회원번호</th>
                <th>회원성명</th>
                <th>회원전화</th>
                <th>회원주소</th>
                <th>가입일자</th>
                <th>고객등급</th>
                <th>도시코드</th>
                <th>수정</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="updateMemberForm.jsp">수정</a>
                    </td>
                </tr>
        </tbody>
    </table>
</section>
<%@ include file="footer.jsp" %>

</body>
</html>