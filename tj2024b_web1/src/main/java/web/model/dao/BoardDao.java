package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE) // private 디폴트 생성자가 자동 생성
public class BoardDao extends Dao{
	
	@Getter // 싱글톤을 반환하는 메소드를 자동 생성, getInstance() 자동 생성
	private static BoardDao instance = new BoardDao();
	
	// [1] 게시물 글쓰기 SQL 처리 메소드
	public boolean write(BoardDto boardDto) {
		try {
			String sql = "insert into board (btitle, bcontent, mno, cno) values(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getMno());
			ps.setInt(4, boardDto.getCno());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// [2] 게시물 전체 조회 findAll SQL 처리 메소드
	public ArrayList<BoardDto> findAll(){
		ArrayList<BoardDto> result = new ArrayList<BoardDto>();
	      
	      try {
	         String sql = "select b.* , m.mid , c.cname from board b inner join member m , category c";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();
	         while( rs.next() ) {
	            BoardDto boardDto = new BoardDto();
	            boardDto.setBno(rs.getInt("bno"));
	            boardDto.setBtitle(rs.getString("btitle"));
	            boardDto.setBcontent(rs.getString("bcontent"));
	            boardDto.setBdate(rs.getString("bdate"));
	            boardDto.setBview(rs.getInt("bview"));
	            boardDto.setMid(rs.getString("mid"));
	            boardDto.setCname(rs.getString("cname"));
	            result.add(boardDto);
	         }
	      }catch( Exception e ) { System.out.println(e); }
	      return result;

	}
	// [3] 게시물 개별 삭제 delete SQL 메소드 
    public boolean delete( int bno ) {
            try {
                    String sql ="delete from board where bno = ? ";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt( 1 , bno);
                    int count = ps.executeUpdate();
                    if( count == 1 ) return true;
            }catch( Exception e ) { System.out.println( e );}
            return false;
    }
    // [4] 게시물 개별 수정 update SQL 메소드 
    public boolean update( BoardDto boardDto ) {
            try {
                    String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString( 1 , boardDto.getBtitle() );
                    ps.setString( 2 , boardDto.getBcontent() );
                    ps.setInt( 3 , boardDto.getBno() );
                    int count = ps.executeUpdate();
                    if( count == 1 ) return true;
            }catch(Exception e ) { System.out.println( e );}
            return false;
    }
 // [5] 게시물 개별 조회 findByBno SQL 메소드 
    public BoardDto findByBno( int bno ) {
            try {
                    // (1) 특정 게시물 테이블의 게시물 1개 조회 
                    // String sql = "select * from board where bno = ? ";
                    // (2) 게시물 테이블과 회원 테이블 교집합 구해서 회원아이디로 조회 가능
                    // String sql = "select * from board b inner join member m on b.mno = m.mno";
                    // (3) 게시물 테이블과 회원 테이블 과 카테고리 테이블 교집합 구해서 회원아이디 와 카테고리명 조회 가능 
                    String sql = "select * from board b "
                                    + " inner join member m on b.mno = m.mno "
                                    + " inner join category c on b.cno = c.cno "
                                    + " where bno = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt( 1 , bno);
                    ResultSet rs = ps.executeQuery();
                    if( rs.next() ) {
                            BoardDto boardDto = new BoardDto();
                            boardDto.setBno( rs.getInt("bno") );
                            boardDto.setBtitle( rs.getString("btitle") );
                            boardDto.setBcontent( rs.getString( "bcontent") );
                            boardDto.setBdate( rs.getString("bdate"));
                            boardDto.setBview( rs.getInt( "bview"));
                            boardDto.setMno( rs.getInt("mno"));
                            boardDto.setCno( rs.getInt("cno"));
                            boardDto.setMid( rs.getString("mid") ); // 회원테이블과 조인 한 결과 회원아이디 도 조회 가능하다.
                            boardDto.setCname( rs.getString( "cname") ); // 카테고리테이블 과 조인 한 결과 카테고리명 도 조회 가능하다.
                            return boardDto;
                    }
            }catch (Exception e) { System.out.println(e);}
            return null;
    }
}
