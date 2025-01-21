package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example5")
public class Example5 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = true;						// 1. 응답할 자료 준비
		resp.setContentType("application/json");	// 2. HTTP를 이용한 응답 헤더 정보 추가, .setContentType();
		resp.getWriter().print(result);				// 3. HTTP를 이용한 요청에 따른 응답 자료 보내기
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "java";
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 30;
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataDto result = new DataDto("유재석", 40);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
}
