package day03.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class VisitDao {
	
	private Connection conn;
	private static VisitDao instance = new VisitDao();
	private VisitDao() {
		try {
		// DB 연동 코드 : 코드 작성전에 필수 : 프로젝트의 jdbc.jar build 
		// 라이브러리 폴더 경로 : src -> main -> webapp -> web-inf -> lib 폴더
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mydb016",
				"root", "1234");
		}catch (Exception e) {System.out.println(e);}
	}
	public static VisitDao getInstance() {return instance;}
	
	// 1. 방문록 등록 SQL 처리 메소드
	public boolean write(VisitDto visitDto) {
		try {
		String sql = "insert into visit(content,age) values(?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, visitDto.getContent());
		ps.setInt(2, visitDto.getAge());
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 4. 방문록 삭제 SQL 처리 메소드
	public boolean delete(int num) {
		try {
		String sql = "delete from visit where num = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, num);
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
}