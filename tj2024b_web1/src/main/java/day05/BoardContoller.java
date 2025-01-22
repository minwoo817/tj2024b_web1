package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board")
public class BoardContoller extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로부터 요청(request)받은 HTTP header BODY(본문)를 파싱(가져)오기
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		// 2. DAO 처리
		boolean result = BoardDao.getInstance().write(boardDto);
		// 3. DAO 결과를 HTTP header BODY(본문)으로 응답(response) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. X
		// 2. DAO 처리
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
		// 3. DAO 결과를 HTTP header BODY(본문)으로 응답(response) 보내기
			// 자바객체(DTO) --> JSON 타입변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로부터 요청(request)받은 HTTP header BODY(본문)를 파싱(가져)오기
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		// 2. DAO 처리
		boolean result = BoardDao.getInstance().update(boardDto);
		// 3. DAO 결과를 HTTP header BODY(본문)으로 응답(response) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로부터 요청(request)받은 HTTP queryString 의 매개변수 가져오기 
		int bno = Integer.parseInt(req.getParameter("bno"));
		// 2. DAO 처리
		boolean result = BoardDao.getInstance().delete(bno);
		// 3. DAO 결과를 HTTP header BODY(본문)으로 응답(response) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
}
