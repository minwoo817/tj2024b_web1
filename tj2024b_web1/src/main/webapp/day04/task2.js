const waitingregist = () => {
	let phoneInput = document.querySelector('.phoneInput')
	let peopleInput = document.querySelector('.peopleInput')
	let phone = phoneInput.value;
	let people = peopleInput.value;
	let dataObj = {phone : phone, people : people};
	let option = {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch('/tj2024b_web1/day03/waiting2', option)
		.then(r => r.json())
		.then(data => {
			if(data == true){alert('등록성공'); waitingprint();}
			else{alert('등록실패');}
		})
		.catch(e => {console.log(e);})
}

const waitingprint = () => {
	let tbody = document.querySelector('tbody')
	let html = '';
		const option = {method : 'GET'}
		fetch('/tj2024b_web1/day03/waiting2')
			.then(r => r.json())
			.then(data =>{
				data.forEach(obj=>{
					html += `<tr>
							<td> ${obj.num} </td>
							<td> ${obj.phone} </td>
							<td> ${obj.people} </td>
							<td> 
								<button onclick="waitingUpdate(${obj.num})"> 수정 </button>
								<button onclick="waitingDelete(${obj.num})" > 삭제 </button>
							</td>
							</tr>`
				})
				tbody.innerHTML = html;
			})
			.catch(e => {console.log(e);})
}
waitingprint();

const waitingUpdate = (num) => {
	let newPhone = prompt('new Phone : ');
	let newPeople = prompt('new People : ');
	let dataObj = {num : num, phone : newPhone, people : newPeople}
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch('/tj2024b_web1/day03/waiting2', option)
		.then(r => r.json())
		.then(data => {
			if(data == true){alert('수정성공'); waitingprint();}
			else{alert('수정실패');}
		})
		.catch(e => {console.log(e);})
}

const waitingDelete = (num) => {
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_web1/day03/waiting2?wno=${num}`, option)
		.then(r => r.json())
		.then(data =>{
			if(data == true){alert('삭제성공'); waitingprint();}
			else{alert('삭제실패')}
		})
		.catch(e => {console.log(e);})
}