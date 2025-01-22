const boardwrite = () => {
	let titleInput = document.querySelector('.titleInput')
	let contentInput = document.querySelector('.contentInput')
	let writerInput = document.querySelector('.writerInput')
	let pwInput = document.querySelector('.pwInput')
	
	let btitle = titleInput.value;
	let bcontent = contentInput.value;
	let bwriter = writerInput.value;
	let bpw = pwInput.value;
	
	let dataObj = {btitle : btitle, bcontent : bcontent, bwriter : bwriter, bpw : bpw}
	
	const option = {
		method : 'POST',
		Headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch('/tj2024b_web1/day05/board', option)
		.then(response => response.json())
		.then(data => {
			if(data == true){alert('글쓰기완료');location.href ="/tj2024b_web1/day05/board.jsp";}
			else{alert('글쓰기실패')}
		})
		.catch(error =>{alert('시스템오류 : 관리자에게 문의')})
}