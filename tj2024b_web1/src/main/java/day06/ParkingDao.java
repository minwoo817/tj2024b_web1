package day06;

import java.lang.foreign.ValueLayout;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;


//입차
public class ParkingDao {

	private Connection conn;
	private static ParkingDao instance = new ParkingDao();
	private ParkingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingcar",
					"root","1234");
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
		
	}
	public static ParkingDao getInstance() {
		return instance;
	
	}
	//출차
	public boolean carout(ParkingDto parkingDto) {
		try {
			String sql="insert into parkingcar(carnumber)values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, parkingDto.getCarout());
			
			int count = ps.executeUpdate();
			if(count==1) {return true;}  
				
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	
	//입차조회
	public boolean carIn(ParkingDto parkingDto) {
		try {
			String sql = "insrt into parkingcar(carnumber,carlocation)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, parkingDto.getCarin());
			ps.setString(2, parkingDto.getCarlocation());
			int count = ps.executeUpdate();
			if(count==1) {return true;}  
					
		} catch (SQLException e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return false;
	}// fend
	
	//전체조회
	
	public ArrayList<ParkingDto>allCar(){
		ArrayList<ParkingDto>list = new ArrayList<ParkingDto>();
		try {
			String sql = "select * from parkingcar";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ParkingDto parkingDto = new ParkingDto();
				parkingDto.setNum(rs.getInt("num"));
				parkingDto.setCarnumber(rs.getString("carnumber"));
				parkingDto.setCarlocation(rs.getString("carlocation"));
				parkingDto.setCarin(rs.getString("carin"));
				parkingDto.setCarout(rs.getString("carout"));
				parkingDto.setCharge(rs.getString("charge"));
				list.add(parkingDto);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	//개별입차시간 조회
	
	public ArrayList<ParkingDto>findTime(){
		ArrayList<ParkingDto>list = new ArrayList<ParkingDto>();
		try {
			String sql = "select num from parkingcar";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ParkingDto parkingDto = new ParkingDto();
				parkingDto.setNum(rs.getInt("num"));
				
				list.add(parkingDto);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
}// class end
