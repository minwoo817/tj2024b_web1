<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="/tj2024b_web1/css/index.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg "> 
  <div class="container-fluid">
    <a class="navbar-brand" href="/tj2024b_web1/index.jsp">
      <img class="header_logo" src = "/tj2024b_web1/img/header_logo.jpg"/>
   </a>
   <!-- 반응형 토큰 : 디바이스가 작아지면 활성화 되는 버튼 -->
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <!-- 메뉴 -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <!-- 메뉴 목록 -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      <!-- 메뉴 항목 -->
        
        <li class="nav-item"><a class="nav-link "  href="#">게시판</a></li>
        
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        
      </ul>
      <ul class="navbar-nav me-end mb-2 mb-lg-0 loginmenu">
      
      	
        
      </ul>
      
    </div>
  </div>
</nav>
<!-- 부트스트랩 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- header JS -->
<script src="/tj2024b_web1/js/header.js"></script>
</body>
</html>