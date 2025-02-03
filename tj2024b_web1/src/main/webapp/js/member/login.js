console.log('login.js open');

// [1] 로그인 요청 함수
const onLogin = ( ) => {
	
	// 1. HTML INPUT DOM 가져오기
	const midinput = document.querySelector('.midinput');
		console.log(midinput);
	const mpwdinput = document.querySelector('.mpwdinput');
		console.log(mpwdinput);
	// 2. INPUT 입력값 가져오기
	const mid = midinput.value;
	const mpwd = mpwdinput.value;
	// 3. 유효성검사
	// 4. fetch
	// * 보낼 데이터를 객체(JSON)화
	const obj = {mid : mid, mpwd : mpwd}	
	const option = {
		method : 'POST', // 요청할 http method 선택
		headers : {'Content-Type' : 'application/json'}, // 요청할 http body 타입 설정
		body : JSON.stringify(obj) // 요청할 http 자료 , 자료를 JSON형식의 문자열 타입으로 변환
	}
	// * fetch
	fetch('/tj2024b_web1/member/login', option)
		.then(response => response.json())
		.then(data => {
			if(data > 0){alert('로그인 성공'); location.href="../index.jsp"}
			else{alert('로그인 실패');}
		})
		.catch(error => {console.log(error);})
}