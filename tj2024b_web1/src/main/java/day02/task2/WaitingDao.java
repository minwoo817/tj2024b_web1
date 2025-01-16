package day02.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
	
	public boolean regist(String phone, int people) {
		try {
		String sql = "insert into waiting(phone, people) values (?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, phone);
		ps.setInt(2, people);
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
