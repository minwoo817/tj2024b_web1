package web.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	// [1] 게시물 쓰기 컨트롤러
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// JSON 문자열 --> 특정한 자바 객체 타입으로 변환 기능을 제공하는 라이브러리 객체 생성
		ObjectMapper mapper = new ObjectMapper();
		// HTTP의 request Body 로 부터 JSON 문자열을 읽어와서 BoardDto 타입으로 변환하는 readValue 함수 실행
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		// + 현재 로그인된 회원번호를 세션에서 찾아 boardDto 담아주기
		// 요청 정보의 세션 객체 호출
		HttpSession session = req.getSession();
		// 세션 객체내 특정한 속성(로그인된 회원번호)의 값 꺼내기 , .getAttribute("속성명"); , 모든 세션 객체내 속성은 Objecct 타입
		Object object = session.getAttribute("loginMno");
		if(object != null) {
			// Object 타입 --> int/Integer 타입으로 변환하기
			int loginMno = (Integer)object;
			// boardDto에 로그인된 회원번호 담아주기 , 게시물 작성자 == 로그인된 회원
			boardDto.setMno(loginMno);
		}
		boolean result = BoardDao.getInstance().write(boardDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	// [2] 게시물 전체 조회 컨트롤러
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
	}
	 // [4] 게시물 개별 수정 컨트롤러 
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println(" board put ok ");
            // [1] 
            ObjectMapper mapper = new ObjectMapper(); 
            // [2]
            BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
            // [3]
            boolean result = BoardDao.getInstance().update( boardDto );
            // [4]
            resp.setContentType("application/json");
            resp.getWriter().print(result);
    }
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// [1] HTTP queryString 매개변수를 가져오기 , URL?bno=1 , req.getParameter("매개변수명") : 반환타입 문자열 이므로 타입변환 필요할 수 있다.
		// Integer.parseInt( "문자열") : 문자열 타입 --> 정수 타입 변환 함수.
		int bno = Integer.parseInt( req.getParameter("bno") ) ;
		// [2] Dao 에게 삭제할 번호를 전달하고 결과 받기 
		boolean result = BoardDao.getInstance().delete( bno );
		// [3] 결과를 HTTP의 response 로 응답하기 
		resp.setContentType("application/json");        
		resp.getWriter().print(result);  
	}
	
}
