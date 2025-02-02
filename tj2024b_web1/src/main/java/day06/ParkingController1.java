//package day06;
//
//import java.io.IOException;
//import java.rmi.server.RMIClassLoaderSpi;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//@WebServlet("/day06/parking1")
//public class ParkingController1 extends HttpServlet {
//
//	//출차 조회
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		ObjectMapper mapper = new ObjectMapper();
//		ParkingDto parkingDto = mapper.readValue(req.getReader(),ParkingDto.class);
//		boolean result = ParkingDao.getInstance().carout(parkingDto);
//		resp.setContentType("application/json");
//		resp.getWriter().print(result);
//		
//	}
//	
//	
//	//요금조회
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		
//		try {
//	        String carNumber = req.getParameter("carNumber");
//	        ArrayList<ParkingDto> timeList = ParkingDao.getInstance().findTime();
//	        
//	        int charge = 0;
//	        for (ParkingDto parking : timeList) {
//	            if (parking.getCarnumber() != null && parking.getCarnumber().equals(carNumber)) {
//	                long parkingSeconds = calculateParkingTime(parking.getCarin(), parking.getCarout());
//	                // 하루(24시간) 제한
//	                long maxSeconds = 24 * 60 * 60;
//	                parkingSeconds = Math.min(parkingSeconds, maxSeconds);
//	                // 초당 100원
//	                charge = (int) (parkingSeconds * 100);
//	                break;
//	            }
//	        }
//	        
//	        ObjectMapper mapper = new ObjectMapper();
//	        resp.setContentType("application/json");
//	        resp.setCharacterEncoding("UTF-8");
//	        
//	        ParkingDto response = new ParkingDto();
//	        response.setCharge(String.valueOf(charge));
//	        
//	        mapper.writeValue(resp.getWriter(), response);
//	        
//	    } catch (Exception e) {
//	        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//	        resp.getWriter().write("Error calculating parking fee: " + e.getMessage());
//	    }
//	}
//
//	private long calculateParkingTime(String inTime, String outTime) {
//	    try {
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        Date in = sdf.parse(inTime);
//	        Date out = sdf.parse(outTime);
//	        
//	        // 초 단위 계산
//	        return (out.getTime() - in.getTime()) / 1000;
//	    } catch (ParseException e) {
//	        throw new RuntimeException("Error parsing date", e);
//	    }
//		
//	}
//	
//	
//}
