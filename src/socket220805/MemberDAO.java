package socket220805;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {

	private static MemberDAO dao = new MemberDAO();
	private MemberDAO(){}

	public static MemberDAO getInstance() {
		return dao;
	}

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.65:1521:xe", "test", "1111");
			if(conn!=null) System.out.println("db성공 ");
			else System.out.println("db실패 ");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return conn;
	}

	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				System.out.println(ex);				
			}
		}
		close(conn, ps);
	} // close

	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				System.out.println(ex);				
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println(ex);				
			}
		}
	} // close

	//table create 
	public void insert(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member(id,password) values(?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2,member.getPassword());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt);
		}
	}

	public Member findOne(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Member member = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
			}

		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt, rs);
		}

		return member;
	}

	public void update(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set password=? where id=?");
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getId());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt);
		}

	}

	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from member where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt);
		}
	}

	public ArrayList<Member> findAll() {

		ArrayList<Member> list = new ArrayList<Member>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Member member = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				list.add(member);
			}

		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}

}
