const boardView = ( ) => {
	// 1. 현재 URL의 쿼리스트링 매개변수 가져온다
		// * 내가 board.jsp에서 클릭한 게시물 번호가 존재하면 쿼리스트링
	let bno = new URL(location.href).searchParams.get('bno');
	
	// 2. fetch 옵션
	const option = {method : 'GET'}
	
	// 3. fetch 통신
	fetch(`/tj2024b_web1/day05/board/view?bno=${bno}`, option)
		.then(response => response.json())
		.then(data => {
			// 4. fetch 응답에 따른 화면 출력
			document.querySelector('.bdatebox').innerHTML = `${data.bdate}`
			document.querySelector('.bwriterbox').innerHTML = `${data.bwriter}`
			document.querySelector('.bviewbox').innerHTML = `${data.bview}`
			document.querySelector('.btitlebox').innerHTML = `${data.btitle}`
			document.querySelector('.bcontentbox').innerHTML = `${data.bcontent}`
			boardInfo = data; // - 다른 함수에서 게시물 정보를 이용하기 위해 게시물정보를 전역변수로 이동
		})
		.catch(error => {console.log(error);})
	
}
boardView();

let boardInfo = null; // 게시물 정보 객체 전역변수
const boardDelete = ( ) => {
	let bno = new URL(location.href).searchParams.get('bno');
	let passwordCheck = prompt('게시물 비밀번호 :')
		if(boardInfo.bpw != passwordCheck){
			alert('비밀번호가 일치하지 않습니다.');
			return;
		}	
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_web1/day05/board?bno=${bno}`, option)
		.then(response => response.json())
		.then(data =>{
			if(data == true){alert('삭제성공');location.href ="/tj2024b_web1/day05/board.jsp";}
			else{alert('삭제실패');}
		})
		.catch(error => {console.log(error);})
}

// 게시물 수정 페이지 이동
const boardUpdate = ( ) => {
	// 1. 비밀번호 일치 유효성 검사
	let passwordCheck = prompt('게시물 비밀번호 : ')
	if(boardInfo.bpw != passwordCheck){
		alert('비밀번호가 일치하지 않습니다.');
		return;
	}
	// 2. 일치하면 수정 페이지로 이동
		// - location.href = "경로" : 페이지 이동 함수
		location.href = `update.jsp?bno=${boardInfo.bno}`
}