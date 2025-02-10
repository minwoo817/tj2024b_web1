package books.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import books.model.dao.BookDao;
import books.model.dto.BookDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/view")
public class BookViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bno = Integer.parseInt(req.getParameter("bno"));
		BookDto bookDto = BookDao.getInstance().findOne(bno);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(bookDto);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
}
