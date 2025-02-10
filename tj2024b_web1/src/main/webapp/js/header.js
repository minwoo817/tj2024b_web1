
// [1] 로그인 정보 요청 함수
const getLoginInfo = ( ) => {
	// 1. 
	const option = {method : 'GET'} // get 은 생략가능
	
	let loginmenu = document.querySelector('.loginmenu');
	
	let html = ``;
	
	// 2. fetch
	fetch('/tj2024b_web1/member/info', option)
		.then(r => r.json())
		.then(data => {
			console.log(data); // 코드 변경 후 서버가 자동 재실행이 되면 세션 초기화
			if(data == null){console.log('비로그인상태');
				
				html += `				<li class="nav-item"><a class="nav-link "  href="/tj2024b_web1/member/login.jsp">로그인</a></li>
				        <li class="nav-item"><a class="nav-link "  href="/tj2024b_web1/member/signup.jsp">회원가입</a></li>`;
				
			}
			else{console.log('로그인상태');
				// 각 상태에 따라 로그인 메뉴 구성
				html += `	<li class="nav-item dropdown">
				             <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				             <img class="header_profile" src="/tj2024b_web1/upload/${ data.mimg }" /> ${ data.mid } 님 
				              </a>
				             <ul class="dropdown-menu">
				             <li class="nav-item"> <a class="nav-link" href="/tj2024b_web1/member/info.jsp">마이페이지</a> </li>
				           <li class="nav-item"> <a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a> </li>
				            </ul>
				            </li>`;
			}
			// 구성한 메뉴들 innerHTML
			loginmenu.innerHTML = html;
		})
		.catch(e => {console.log(e);})
	
};
getLoginInfo(); // JS가 열렸을때 최초 1번 실행

// [2] 로그아웃 요청 함수
const onLogOut = ( ) => {
	const option = {method : 'DELETE'}
	fetch('/tj2024b_web1/member/login', option)
		.then(response => {response.json()})
		.then(data => {
			if(data == true){alert('로그아웃합니다.'); location.href="/tj2024b_web1/member/login.jsp";}
			
		})
		.catch(e => {console.log(e);})
}
