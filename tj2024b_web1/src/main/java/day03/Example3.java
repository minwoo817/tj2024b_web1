package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example3")
public class Example3 extends HttpServlet{
	
	@Override // HTTP POST BODY // http://localhost:8080/tj2024b_web1/day03/example3
	// content-type : application/json , body : {"data1" : "유재석", "data2" : "40"} 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// * JSON 자료의 문자열타입을 DTO로 변환해보기, (JSON은 JS언어에서 사용하는 타입, JAVA는 DTO를 사용한다.)
		System.out.println("[HTTP *POST 방식으로 요청이 있어요.]");
		// System.out.println(req.getReader().readLine());
		// 문자열 : {"data1" : "유재석", "data2" : "강호동"} --> DTO 변환
		// JSON 모양의 문자열 타입 자료를 DTO로 변환 라이브러리 : json 라이브러리
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper 인스턴스 생성
		// req.getReader() 객체의 자료(JSON)들을 DTO 객체로 변환 함수
		DataDto dataDto = mapper.readValue(req.getReader() , DataDto.class );
		System.out.println(dataDto);
		// DTO : DataDto [data1=유재석, data2=40]
		
	}
	
	@Override // HTTP PUT BODY // http://localhost:8080/tj2024b_web1/day03/example3
	// content-type : application/json , body : {"data1" : "유재석", "data2" : "40"} 
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		System.out.println("[HTTP *PUT 방식으로 요청이 있어요.]");
		ObjectMapper mapper = new ObjectMapper();
		DataDto dataDto = mapper.readValue(req.getReader() , DataDto.class );
		System.out.println(dataDto);
	}
}
