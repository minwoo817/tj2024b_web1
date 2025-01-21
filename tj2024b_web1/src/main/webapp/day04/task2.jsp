<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>DAY03 WAITING2 화면 구현</h3>
	<div>
		<div> 대기표 작성 </div>
		핸드폰번호 : <input class = "phoneInput"/><br/>
		인원수 : <input class = "peopleInput"/><br/>
		<button type="button" onclick="waitingregist()">등록</button>
	</div>
	
		<div> 대기표 목록 </div>
		<table border = "1">			
			<thead>		
				<tr>	 
				<th>num</th> 
				<th>phone</th> 
				<th>people</th> 
				<th>etc</th> 
				</tr>
			</thead>
			<tbody>		
				
			</tbody>
		</table>
	
	<script src="task2.js"></script>
</body>
</html>