// * 함수명 만들때 내장 함수와 겹치는 경우
// 1. 등록 함수 , 실행조건 : 등록버튼 클릭했을때
const visitWrite = ( ) => {
	// 1. HTML으로부터 input dom 객체 가져오기
		// - document.querySelector()
	let contentInput = document.querySelector('.contentInput')
	let ageInput = document.querySelector('.ageInput')
	// 2. 입력받은 값 가져오기
	// - value : 마크업의 value 속성 
	let content = contentInput.value;
	let age = ageInput.value;
	// 3. 객체화
	// - {속성명 : 값, 속성명 : 값}
	let dataObj = { 'content' : content, 'age' : age};
	// 4. fetch 통신
	let option = {
		method : 'POST',		// HTTP METHOD 방법 선택
		headers : {'Content-Type' : 'application/json'}, // HTTP 요청 HEADERS CONTENT-TYPE 
		body : JSON.stringify(dataObj) // 본문에 보낼 자료를 문자열 타입으로 변환
	}
	fetch('/tj2024b_web1/day03/visit2', option)
		.then(r => r.json()) // - 응답받은 body 자료를 json 타입으로 변환
		.then(data => { // - 변환된 body 자료
			// 5. 결과에 따른 화면 구현 
			if(data == true){alert('등록성공'); visitFindAll();} // 만약에 받은 자료가 true이면 성공 
			else{alert('등록실패');}
		}) 
		.catch(e => {console.log(e);})
	
	
}
// 2. 전체 조회 함수 , 실행조건 : 1. JS열릴때 2. 등록/수정/삭제 성공했을때 

const visitFindAll = ( ) => {
	// 1. 어디에 , tbody
	let tbody = document.querySelector('tbody')
	// 2. 무엇을 , fetch으로 받은 자료들을
	let html = '';
		// 2-1 fetch 이용한 서블릿에게 자료를 HTTP GET METHOD 요청
		const option = {method : 'GET'}
		// 2-2 fetch
		fetch('/tj2024b_web1/day03/visit2')
			.then(r => r.json()) // 통신 응답 성공시 json 타입으로 변환
			.then(data => {
				// 방법1 : for(let index = 0; index<=data.length-1; index++){}
				// 방법2 : data.forEach(obj => { }) 
				data.forEach(obj=>{
					
					html += `<tr>
							<td> ${obj.num} </td>
							<td> ${obj.content} </td>
							<td> ${obj.age} </td>
							<td> 
								<button onclick="visitUpdate(${obj.num})"> 수정 </button>
								<button onclick="visitDelete(${obj.num})" > 삭제 </button>
							 </td>
							</tr>`
					
				})
				// 3. 출력
					// .innerHTML : 마크업의 html 문자열 대입하는 속성
				tbody.innerHTML = html;
			})
			.catch(e => {console.log(e);}) // 통신 응답 오류/실패 시
	
}	
visitFindAll(); // 1. JS열릴때
// 3. 수정 함수, 누구를 수정할건지 = num[pk]
const visitUpdate = (num) => { // prompt() 험수로 수정할 content/age 받기
	// 1. 수정할 식별자(num)
	// 2. 수정할 내용 content/age
	let newContent = prompt('new Content : '); // prompt() 알람창에서 입력input 지원하는 함수
	let newAge = prompt('new Age : ');
	// 3. 객체화
	let dataObj = {num : num, content : newContent, age : newAge}
	// 4. fetch 이용한 서블릿에서 HTTP PUT METHOD 처리 요청, BODY
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch('/tj2024b_web1/day03/visit2', option)
		.then(r => r.json())
		.then(data => {
			if(data == true){alert('수정성공');visitFindAll();}
			else{alert('수정실패');}
		})
		.catch(e => {console.log(e);})
}
// 4. 삭제 함수, 누구를 삭제할건지 = num[pk]
const visitDelete = (num) => {
	// 1. 삭제할 식별자(num) 
	// 2. fetch 이용한 서블릿에게 HTTP DELETE METHOD 처리를 요청
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_web1/day03/visit2?num=${num}`, option)
		.then(r => r.json()) // 응답 결과를 json 타입으로 변환
		.then(data => {
			if(data == true){alert('삭제성공'); visitFindAll();} // 만약에 응답이 true이면 alert 안내 후 출력함수호출
			else{alert('삭제실패')}
		})
		.catch(e => {console.log(e);})	
}
