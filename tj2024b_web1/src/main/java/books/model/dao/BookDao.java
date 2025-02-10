package books.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import books.model.dto.BookDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BookDao extends Dao{
	@Getter
	private static BookDao instance = new BookDao();
	
	public boolean write(BookDto bookDto) {
		try {
			String sql = "insert into book(bname, bwriter, bpublisher) values(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookDto.getBname());
			ps.setString(2, bookDto.getBwriter());
			ps.setString(3, bookDto.getBpublisher());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public ArrayList<BookDto> findAll(){
		ArrayList<BookDto> result = new ArrayList<BookDto>();
		try {
			String sql = "select * from book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookDto bookDto = new BookDto();
				bookDto.setBno(rs.getInt("bno"));
				bookDto.setBname(rs.getString("bname"));
				bookDto.setBwriter(rs.getString("bwriter"));
				bookDto.setBpublisher(rs.getString("bpublisher"));
				bookDto.setBdate(rs.getString("bdate"));
				bookDto.setBupdate(rs.getString("bupdate"));
				result.add(bookDto);
			}
		}catch (Exception e) {System.out.println(e);}
		return result;
	}
	
	public boolean update(BookDto bookDto) {
		try {
			String sql = "update book set bname = ?, bwriter = ?, bpublisher = ? where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookDto.getBname());
			ps.setString(2, bookDto.getBwriter());
			ps.setString(3, bookDto.getBpublisher());
			ps.setInt(4, bookDto.getBno());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean delete(int bno) {
		try {
			String sql = "delete from book where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public BookDto findOne(int bno) {
		try {
			String sql = "select * from book where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				BookDto bookDto = new BookDto();
				bookDto.setBno(rs.getInt("bno"));
				bookDto.setBname(rs.getString("bname"));
				bookDto.setBwriter(rs.getString("bwriter"));
				bookDto.setBpublisher(rs.getString("bpublisher"));
				bookDto.setBdate(rs.getString("bdate"));
				bookDto.setBupdate(rs.getString("bupdate"));
				return bookDto;
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
}
