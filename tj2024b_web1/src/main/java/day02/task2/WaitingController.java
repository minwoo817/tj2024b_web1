package day02.task2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/waiting")
public class WaitingController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		int people = Integer.parseInt(req.getParameter("people"));
		
		boolean result = WaitingDao.getInstance().regist(phone, people);
		System.out.println(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int wno = Integer.parseInt(req.getParameter("wno"));
		
		boolean result = WaitingDao.getInstance().delete(wno);
		System.out.println(result);
	}
}
