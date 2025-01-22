const boardFindAll = ( ) => {
	let tbody = document.querySelector('tbody')
	
	let html = '';
	
	const option = {method : 'GET'}
	
	fetch('/tj2024b_web1/day05/board', option)
		.then(response => response.json())
		.then(data => {
			
			data.forEach(board => {
				html += `<tr>
							<td> ${board.bno} </td> 
							<td> <a href="view.jsp?bno=${board.bno}">${board.btitle}</a>  </td>  
							<td> ${board.bwriter} </td> 
							<td> ${board.bview} </td> 
							<td> ${board.bdate} </td>  
						</tr>`
				
			});
			tbody.innerHTML = html;
		})
		.catch(error => {console.log(error);})
	
};
boardFindAll();