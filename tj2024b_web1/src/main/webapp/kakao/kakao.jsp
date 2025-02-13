<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- header.jsp 임포트 -->
	<jsp:include page="/header.jsp"></jsp:include>
	
	<div id="map" style="width:100%;height:860px;"></div>
	
<button style="display: none;" class="btn btn-primary sidebar" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
  Button with data-bs-target
</button>

<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasExampleLabel">약국 상세정보</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
   		<div class="pharmacy"></div>
   		<div class="phone"></div>
   		<div class="address"></div> 
   
  </div>
</div>
	
	<!-- JQUERY 라이브러리 : 카카오지도에 필요한 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 카카오 지도의 클러스터 기능을 사용하기 위해 앱키 뒤 &libraries=clusterer 추가 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5d525bd42308b9de0ef0a121eb59e01b&libraries=clusterer"></script>
	
	<script src="kakao.js"></script>
	
	
</body>
</html>