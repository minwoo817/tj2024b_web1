package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WaitingDao {
	private Connection conn;
	private static WaitingDao instance = new WaitingDao();
	private WaitingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0116task2",
					"root", "1234");
		}catch (Exception e) {System.out.println(e);}
	}
	public static WaitingDao getInstance() {return instance;}
	
	public boolean regist(WaitingDto waitingDto) {
		try {
		String sql = "insert into waiting(phone, people) values (?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, waitingDto.getPhone());
		ps.setInt(2, waitingDto.getPeople());
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public ArrayList<WaitingDto> findAll(){
		ArrayList<WaitingDto> list = new ArrayList<WaitingDto>();
		try {
			String sql = "select * from waiting";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				WaitingDto waitingDto = new WaitingDto();
				waitingDto.setNum(rs.getInt("wno"));
				waitingDto.setPhone(rs.getString("phone"));
				waitingDto.setPeople(rs.getInt("people"));
				list.add(waitingDto);
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public boolean update(WaitingDto waitingDto) {
		try {
			String sql = "update waiting set phone = ?, people = ? where wno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPhone());
			ps.setInt(2, waitingDto.getPeople());
			ps.setInt(3, waitingDto.getNum());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean delete(int wno) {
		try {
		String sql = "delete from waiting where wno = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, wno);
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
}
