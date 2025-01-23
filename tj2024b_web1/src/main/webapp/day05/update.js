// 수정하기 전 정보를 조회
const boardView = ( ) => {
	let bno = new URL(location.href).searchParams.get('bno');
	const option = {method : 'GET'}
	fetch(`/tj2024b_web1/day05/board/view?bno=${bno}`, option)
		.then(response => response.json())
		.then(data => {
			// 4. fetch 응답에 따른 화면 출력
				// 마크업 주요 속성
					// 1. innerHTML : 시작마크업과 끝마크업 사이에 <마크업> innerHTML </마크업> HTMl 문자열
						// --> div, span, table 등등 , 불가능 : <input /> <img />
					// 2. value : 마크업의 입력 속성값 <마크업 value="" /> 대입/호출
						// --> input, select, textarea , 불가능 : 레이아웃 div, span, table 등등
			document.querySelector('.titleInput').value = `${data.btitle}`
			document.querySelector('.contentInput').value = `${data.bcontent}`
			boardInfo = data; // - 다른 함수에서 게시물 정보를 이용하기 위해 게시물정보를 전역변수로 이동
		})
		.catch(error => {console.log(error);})
}
boardView();

// 수정 처리
const boardUpdate = ( ) => {
	let bno = new URL (location.href).searchParams.get('bno')
	let titleInput = document.querySelector('.titleInput')
	let contentInput = document.querySelector('.contentInput')
	let btitle = titleInput.value;
	let bcontent = contentInput.value;
	let dataObj = {bno : bno, btitle : btitle, bcontent : bcontent}
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch(`/tj2024b_web1/day05/board`, option)
		.then(response => response.json())
		.then(data => {
			if(data == true){alert('수정성공'); location.href=`view.jsp?bno=${bno}`;}
			else{alert('수정실패')}
		})
		.catch(e => {console.log(e);})
}