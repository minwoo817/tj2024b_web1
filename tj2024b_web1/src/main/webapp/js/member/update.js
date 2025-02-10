console.log('update.js open');

// [1] 대부분 수정은 기존의 데이터를 먼저 보여줘야한다.
const getMyInfo = ( ) => {
	const option = {method : 'GET'}
	fetch('/tj2024b_web1/member/info', option)
		.then(r => r.json())
		.then(data => {
			if(data != null){
				document.querySelector('.mid').value = data.mid;
				document.querySelector('.mname').value = data.mname;
				document.querySelector('.mphone').value = data.mphone;
				document.querySelector('.mimg').src = `/tj2024b_web1/upload/${data.mimg}`;
			}
		})
		.catch(e => {console.log(e);})	
}
getMyInfo();

// [2] 수정 요청 함수
const onUpdate = ( ) => {
	// 입력받은 자료 가져오기
	const mpwd = document.querySelector('.mpwd').value;
	const mname = document.querySelector('.mname').value;
	const mphone = document.querySelector('.mphone').value;
	// 객체화
	const obj = {
		mpwd : mpwd , mname : mname, mphone : mphone
	}
	// fetch
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(obj)
	}
	fetch('/tj2024b_web1/member/info', option)
		.then(r => r.json())
		.then(data => {
			if(data == true){alert('회원정보 수정 성공'); location.href="info.jsp";}
			else{alert('회원정보 수정 실패')}
		})
		.catch(e => {console.log(e)})	
}