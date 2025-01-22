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
			
		})
		.catch(error => {console.log(error);})
	
}
boardView();
const boardDelete = ( ) => {
	let bno = new URL(location.href).searchParams.get('bno');
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_web1/day05/board?bno=${bno}`, option)
		.then(response => response.json())
		.then(data =>{
			if(data == true){alert('삭제성공');location.href ="/tj2024b_web1/day05/board.jsp";}
			else{alert('삭제실패');}
		})
		.catch(error => {console.log(error);})
}