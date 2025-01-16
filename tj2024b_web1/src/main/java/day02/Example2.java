package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1단계 : extends HttpServlet
// 2단계 : @WebServlet("주소정의")
// 3단계 : http method(get/post/put/delete)의 메소드를 재정의한다
@WebServlet("/day02/example2") // http://localhost:8080/tj2024b_web1/day02/example2
public class Example2 extends HttpServlet{
	// 1. doget + 자동완성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1] 사용자가 서버로부터 get 메소드로 요청했습니다.");
		
		// 쿼리스트링의 매개변수를 가져오기
			// http://localhost:8080/tj2024b_web1/day02/example2?name=장민우
			// .getParameter("URL 경로상의 매개변수명"); 	// 매개변수명의 값(String 타입) 반환 함수, 없으면 NULL
		System.out.print("1] URL ? 뒤에 있는 name 매개변수명 가진 변수의 값 가져오기 : ");
		System.out.println(req.getParameter("name"));
		
			// http://localhost:8080/tj2024b_web1/day02/example2?name=장민우&age=26
		System.out.print("1] URL ? 뒤에 age 매개변수명을 가진 변수의 값 가져오기 : ");
		System.out.println(req.getParameter("age"));
	}
	
	// 2. dopost + 자동완성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2] 사용자가 서버로부터 post 메소드로 요청했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s, age : %s", name, age);
	}
	// 3. doput + 자동완성
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3] 사용자가 서버로부터 put 메소드로 요청했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s, age : %s", name, age);
	}
	// 4. dodelete + 자동완성
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4] 사용자가 서버로부터 delete 메소드로 요청했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s, age : %s", name, age);
	}
}
