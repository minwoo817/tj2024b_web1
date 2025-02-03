<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h1>메인 페이지</h1>
	<!-- 부트스트랩 캐러셀 -->
	<div id="carouselExample" class="carousel slide">
	<!-- 이미지 본문들 -->
  <div class="carousel-inner">
  	<!-- 각 이미지 항목 -->
    <div class="carousel-item active">
      <img src="/tj2024b_web1/img/img1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/tj2024b_web1/img/img2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/tj2024b_web1/img/img3.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/tj2024b_web1/img/img4.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <!-- 왼쪽 버튼 -->
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <!-- 오른쪽 버튼 -->
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</body>
</html>