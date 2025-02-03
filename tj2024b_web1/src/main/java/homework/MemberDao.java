package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao {
	private Connection conn;
	private static MemberDao instance = new MemberDao();
	private MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hrd",
					"root", "1234");
		}catch (Exception e) {System.out.println(e);}
	}
	public static MemberDao getInstance() {return instance;}
	
	public boolean signup(MemberDto memberDto) {
		try {
			String sql = "insert into MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberDto.getCustno());
			ps.setString(2, memberDto.getCustname());
			ps.setString(3, memberDto.getCustphone());
			ps.setString(4, memberDto.getAddress());
			ps.setString(5, memberDto.getJoindate());
			ps.setString(6, memberDto.getGrade());
			ps.setString(7, memberDto.getCity());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public ArrayList<MemberDto> findAll(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		try {
			String sql = "select * from MEMBER_TBL_02";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setCustno(rs.getInt("CUSTNO"));
				memberDto.setCustname(rs.getString("CUSTNAME"));
				memberDto.setCustphone(rs.getString("PHONE"));
				memberDto.setAddress(rs.getString("ADDRESS"));
				memberDto.setJoindate(rs.getString("JOINDATE"));
				memberDto.setGrade(rs.getString("GRADE"));
				memberDto.setCity(rs.getString("CITY"));
				list.add(memberDto);
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	public boolean update(MemberDto memberDto) {
		try {
			String sql = "update MEMBER_TBL_02 set CUSTNAME = ?, PHONE = ?, ADDRESS = ?, GRADE = ?, CITY = ? where CUSTNO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getCustname());
			ps.setString(2, memberDto.getCustphone());
			ps.setString(3, memberDto.getAddress());
			ps.setString(4, memberDto.getGrade());
			ps.setString(5, memberDto.getCity());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public ArrayList<SaleDto> sale(){
		ArrayList<SaleDto> list = new ArrayList<SaleDto>();
		try {
			String sql = "select m.CUSTNO, m.CUSTNAME, m.GRADE, SUM(mt.PRICE) as TOTAL_PRICE from MEMBER_TBL_02 m join MONEY_TBL_02 mt on m.CUSTNO = mt.CUSTNO group by m.CUSTNO, m.CUSTNAME, m.GRADE order by TOTAL_PRICE DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SaleDto saleDto = new SaleDto();
				saleDto.setCustno(rs.getInt("CUSTNO"));
				saleDto.setCustname(rs.getString("CUSTNAME"));
				saleDto.setGrade(rs.getString("GRADE"));
				saleDto.setPrice(rs.getInt("TOTAL_PRICE"));
				list.add(saleDto);
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
}
