
/* 마커에 클릭 이벤트 등록하기 */
//var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
//    mapOption = { 
//        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
//        level: 3 // 지도의 확대 레벨
//    };

//var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
  
// 마커를 표시할 위치입니다 
//var position =  new kakao.maps.LatLng(33.450701, 126.570667);

// 마커를 생성합니다
//var marker = new kakao.maps.Marker({
//  position: position,
//  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
//});

// 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
// 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
// marker.setClickable(true);

// 마커를 지도에 표시합니다.
//marker.setMap(map);

// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
//var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
//    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// 인포윈도우를 생성합니다
//var infowindow = new kakao.maps.InfoWindow({
//    content : iwContent,
//    removable : iwRemoveable
//});

// 마커에 클릭이벤트를 등록합니다
//kakao.maps.event.addListener(marker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
//      infowindow.open(map, marker);  
//});

// [2] 마커에 클릭이벤트 등록하기
/* 
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
  
// 마커를 표시할 위치입니다 
var position =  new kakao.maps.LatLng(33.450701, 126.570667);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
  position: position,
  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
});

// 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
// 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
// marker.setClickable(true);

// 마커를 지도에 표시합니다.
marker.setMap(map);

// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    content : iwContent,
    removable : iwRemoveable
});

// 마커에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      infowindow.open(map, marker);  
	  alert('마커를 클릭했습니다')
});

*/
/*
// [3] 여러개 마커 표기하기

// (1) HTML의 div를 가져오기
var mapContainer = document.querySelector('#map'), // 지도를 표시할 div  
    mapOption = { // (2) 처음에 지도가 열렸을때 중심 좌표와 확대레벨 설정 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨, 0(최대 확대)~ 14(최대축소)
    };
// (3) 설정된 지도 정보를 map 변수에 저장 1.지도를 표시할 div, 2.중심 좌표/지도확대축소
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// 마커를 표시할 위치와 title 객체 배열입니다 // fetch 활용하여 마커에 표시할 위도 경도

var positions = [
    {
        title: '카카오', 
        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
    },
    {
        title: '생태연못', 
        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
    },
    {
        title: '텃밭', 
        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
    },
    {
        title: '근린공원',
        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
    },
	{
		title: '더조은 컴퓨터학원 부평점',
		latlng: new kakao.maps.LatLng(37.4910841087311, 126.72057774665798)
	}
];

// (5) 마커 이미지의 이미지 주소입니다(배포된 이미지 HTTP 경로)
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 

// (6) 자료 정보들을 반복문 이용하여 마커를 하나씩 만들기    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
	
	// (6-4) 마커에 이벤트 등록
	// 마커에 클릭이벤트 등록합니다.
	kakao.maps.event.addListener(marker, 'click', function() {
	      console.log(marker);
		// 마커 위에 인포윈도우를 표시합니다
	      // infowindow.open(map, marker);  
		  alert(`${positions[i].title}클릭했습니다.`)
	});
}*/

// [4] 마커 클러스터러 사용하기
// +jQuery(JS라이브러리) + &libraries=clusterer

// (1) 카카오지도 중심좌표(지도의 시작 좌표)와 확대 레벨 설정 
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 // Geolocation API: 사용자의 현재 위치를 가져오는 API
        level : 14 // 지도의 확대 레벨 
    });
    
    // (2) 마커 클러스터러(여러개 마커들을 하나의 도형)를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 14 // 클러스터 할 최소 지도 레벨, 지도 레벨이 지정한 레벨일때 마커 클러스터 동작 
    });
 
    // (3) $(jquery문법) = http 통신 함수들, $.get('http주소', function(data){ }) vs fetch() vs axios() vs ajaxs()
	// $.get('통신할 http주소', function(data){ })
	// fetch('통신할 http주소', {}).then().then()
		// 1. 서블릿 주소 2. 
    // $.get("https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=10&serviceKey=nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D", function(data) {
		fetch('https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=35&serviceKey=nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D')
			.then(response => response.json())
			.then(data => {console.log(data); // 통신된 response 값
				/*    
				let markers = []
				for(let index = 0; index <= data.data.length-1; index++){
					let position = data.data[index];
					// 데이터에서 좌표 값을 가지고 마커를 표시합니다
					// 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
					let marker = new kakao.maps.Marker({position : new kakao.maps.LatLng(position.위도, position.경도)});
					markers.push(marker)
				}     
				*/
				/*
				let markers = [];
				data.data.forEach((position) => {
					let marker = new kakao.maps.Marker({position : new kakao.maps.LatLng(position.위도, position.경도)});
					markers.push(marker)
				})
				*/
				
				let markers = data.data.map((position) =>{
					// 1개 마커 생성
					let marker = new kakao.maps.Marker({position : new kakao.maps.LatLng(position.위도, position.경도)});
					// 위 변수의 저장된 마커의 클릭 이벤트 등록
					kakao.maps.event.addListener(marker, 'click', function() {  
						  //alert(`${position.약국명}를 클릭했습니다`)
						  
						  // 클릭한 약국의 정보를 특정한(사이드바) html에 대입
						  document.querySelector('.pharmacy').innerHTML = position.약국명;
						  document.querySelector('.phone').innerHTML = position.전화번호;
						  document.querySelector('.address').innerHTML = position.소재지도로명주소;
						  
						  // 사이드바 버튼을(JS 클릭이벤트) 강제 클릭
						  document.querySelector('.sidebar').click();
						  	// .click(); : DOM 객체의 클릭 이벤트 실행
				});
				// 위 변수의 생성된 마커 이벤트 등록후 반환/리턴
				return marker;
				});
        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    })
	.catch(e => {console.log(e)});		