package day05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
	private Connection conn;
	private static BoardDao instance = new BoardDao();
	private BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0122",
					"root", "1234");
		}catch (Exception e) {System.out.println(e);}
	}
	public static BoardDao getInstance() {return instance;}
	
	public boolean write(BoardDto boardDto) {
		try {
			String sql = "insert into board(btitle, bcontent, bwriter, bpw) values (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setString(3, boardDto.getBwriter());
			ps.setString(4, boardDto.getBpw());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public ArrayList<BoardDto> findAll(){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select * from board";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBwriter(rs.getString("bwriter"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBdate(rs.getString("bdate"));
				list.add(boardDto);
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public boolean update(BoardDto boardDto) {
		try {
			String sql = "update board set btitle = ?, bcontent = ? where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getBno());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean delete(int bno) {
		try {
			String sql = "delete from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public BoardDto findOne(int bno){
		
		try {
			String sql = "select * from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBwriter(rs.getString("bwriter"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBpw(rs.getString("bpw"));
				boardDto.setBdate(rs.getString("bdate"));
				return boardDto;
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
}
