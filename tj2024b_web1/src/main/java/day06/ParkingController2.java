package day06;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day06/parking2")
public class ParkingController2 extends HttpServlet {

	
	//입차 조회
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ObjectMapper mapper = new ObjectMapper();
		ParkingDto parkingDto = mapper.readValue(req.getReader(),ParkingDto.class);
		boolean result = ParkingDao.getInstance().carIn(parkingDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
	
	//전체조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<ParkingDto>result=ParkingDao.getInstance().allCar();
		ObjectMapper mapper = new ObjectMapper();
		String result1 = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(result1);
	}
	
}
