package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Content;
import vo.Cont;

public class ContDao {

	private ContDao() {
	}

	private static ContDao cDao = new ContDao();

	public static ContDao getInstance() {
		System.out.println("get instance");
		return cDao; 
	}

	public List<Cont> selectAll() {
		String sql = "select * from cont";

		List<Cont> list = new ArrayList<Cont>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cont Cont = new Cont();
				Cont.setCno(rs.getInt("cno"));
				Cont.setName(rs.getString("name"));
				Cont.setReview(rs.getString("review"));
				Cont.setStore_name(rs.getString("store_name"));
				Cont.setPoint(rs.getInt("point"));
				Cont.setCat(rs.getString("cat"));
				list.add(Cont);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	public List<Cont> selectAll_New() {
		String sql = "select * from cont order by cno desc";

		List<Cont> list = new ArrayList<Cont>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cont Cont = new Cont();
				Cont.setCno(rs.getInt("cno"));
				Cont.setName(rs.getString("name"));
				Cont.setReview(rs.getString("review"));
				Cont.setStore_name(rs.getString("store_name"));
				Cont.setPoint(rs.getInt("point"));
				Cont.setCat(rs.getString("cat"));
				Cont.setWriter("writer");
				list.add(Cont);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}

	
	public List<Cont> selectAll_writer(String writer) {
		String sql = "select * from cont where writer='"+writer+"' order by cno desc";

		List<Cont> list = new ArrayList<Cont>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cont Cont = new Cont();
				Cont.setCno(rs.getInt("cno"));
				Cont.setName(rs.getString("name"));
				Cont.setReview(rs.getString("review"));
				Cont.setStore_name(rs.getString("store_name"));
				Cont.setPoint(rs.getInt("point"));
				Cont.setCat(rs.getString("cat"));
				Cont.setWritedate(rs.getDate("writedate"));
				Cont.setWriter(rs.getString("writer"));
				list.add(Cont);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	
	
	public List<Cont> selectAll_pop() {
		String sql = "select * from cont order by views desc";

		List<Cont> list = new ArrayList<Cont>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cont Cont = new Cont();
				Cont.setCno(rs.getInt("cno"));
				Cont.setName(rs.getString("name"));
				Cont.setReview(rs.getString("review"));
				Cont.setStore_name(rs.getString("store_name"));
				Cont.setPoint(rs.getInt("point"));
				Cont.setCat(rs.getString("cat"));
				list.add(Cont);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	
	public List<Cont> selectCat(String cat) { // 카테고리별 리스트
		String sql = "select * from cont where cat='" + cat + "' order by cno desc";
		List<Cont> list = new ArrayList<Cont>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(sql);

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// ps.setString(1, cat);
			// int n=ps.executeUpdate();

			while (rs.next()) {
				Cont Cont = new Cont();
				Cont.setCno(rs.getInt("cno"));
				Cont.setName(rs.getString("name"));
				Cont.setReview(rs.getString("review"));
				Cont.setStore_name(rs.getNString("store_name"));
				Cont.setPoint(rs.getInt("point"));
				Cont.setCat(rs.getNString("cat"));
				list.add(Cont);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}

//	public List<Content> selectAll(int start, int end){
//		String oracle_sql2= "select * from (select b1.*, rownum rn from "
//				+ "(select /*+ INDEX_DESC(M_BOARD BNO_IDX) */ "
//				+ "bno,title,writer,readcount,writedate,replycount from m_board) b1 "
//				+ "where rownum<=?) "
//				+ "where rn>? ";
//		List<Board> list = new ArrayList<Board>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBConn.getConn();
//			pstmt = conn.prepareStatement(oracle_sql2);
//			pstmt.setInt(1,end);
//			pstmt.setInt(2,start);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				Board board = new Board();
//				board.setBno(rs.getInt("bno"));

//				board.setTitle(rs.getString("title"));
//				//board.setContent(rs.getString("content"));
//				board.setWriter(rs.getString("writer"));
//				board.setReadcount(rs.getInt("readcount"));
//				board.setWritedate(rs.getTimestamp("writedate"));
//				//board.setImage_name(rs.getNString("image_name"));
//				board.setReplycount(rs.getInt("replycount"));
//				list.add(board);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConn.close(conn, pstmt, rs);
//		}
//		return list;
//	}

	public boolean insert(Cont cont) {
		boolean flag = false;
		String sql = "insert into cont(cno, name, review, store_name, point, cat, writer, map) values(cont_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("dao");
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);

			ps.setString(1, cont.getName());
			ps.setString(2, cont.getReview());
			ps.setString(3, cont.getStore_name());
			ps.setInt(4, cont.getPoint());
			ps.setString(5, cont.getCat());
			ps.setString(6, cont.getWriter());
			ps.setString(7, cont.getMap());

			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
				System.out.println("게시글이 DB에 저장되었습니다");
			} else {
				System.out.println("게시글 DB 저장 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}

	public boolean updateReadCount(int cno) {
		boolean flag = false;
		String sql = "update cont set views=views+1 where cno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, cno);
			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
				System.out.println("조회수 업데이트 성공");
			} else {
				System.out.println("조회수 업데이트 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}

	
	

	public Cont selectOne(int cno) {
		String sql = "select * from cont where cno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cont cont=null;

		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			rs = ps.executeQuery();
			if (rs.next()) {
				cont = new Cont();
				cont.setCno(rs.getInt("cno"));
				cont.setName(rs.getString("name"));
				cont.setReview(rs.getString("review"));
				cont.setStore_name(rs.getNString("store_name"));
				cont.setPoint(rs.getInt("point"));
				cont.setCat(rs.getNString("cat"));
				cont.setMap(rs.getString("map"));
				cont.setWriter(rs.getString("writer"));
				cont.setWritedate(rs.getDate("writedate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return cont;
	}

	public boolean updateContent(Content content) {
		boolean flag = false;
		String sql = "update f_content set cname=?,point=?,imagename=?,atemenu=?,review=? where cno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, content.getCname());
			ps.setInt(2, content.getPoint());
			ps.setString(3, content.getImagename());
			ps.setString(4, content.getAtemenu());
			ps.setString(5, content.getReview());
			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
				System.out.println("글 업데이트 성공");
			} else {
				System.out.println("글 업데이트 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}

	public boolean deleteContent(int cno) {
		boolean flag = false;
		String sql = "delete from f_content where cno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
				System.out.println("글 삭제 성공");
			} else {
				System.out.println("글 삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public int getContentCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from cont";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return count;
	}
	
	
	
	
	public List<Cont> selectAll(int start, int end, String category){
		String oracle_sql2= "select * from (select b1.*, rownum rn from "
				+ "(select /*+ INDEX_DESC(CONT CNO_IDX) */"
				+ "cno, name, review, store_name, point, cat, views, writer, writedate from cont where cat='"+category+"' order by cno desc) b1 "
				+ "where rownum<=?) "
				+ "where rn>? ";
		List<Cont> list = new ArrayList<Cont>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(oracle_sql2);
			pstmt.setInt(1,end);
			pstmt.setInt(2,start);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cont cont = new Cont();
				cont.setCno(rs.getInt("cno"));
				cont.setName(rs.getString("name"));
				cont.setReview(rs.getString("store_name"));
				cont.setPoint(rs.getInt("point"));
				cont.setCat(rs.getString("cat"));
				cont.setViews(rs.getInt("views"));
				cont.setWriter(rs.getString("writer"));
				cont.setWritedate(rs.getDate("writedate"));

				list.add(cont);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	
	
	

}
