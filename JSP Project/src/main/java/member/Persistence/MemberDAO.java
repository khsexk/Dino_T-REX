package member.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import member.Domain.MemberVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	
	private static Map<String, MemberVO> storage = new HashMap<>();
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "rhgustjr9402!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean join(MemberVO student) {
		try {
			storage.put(student.getId(), student);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public MemberVO read(String id) {
		connect();
		MemberVO vo = new MemberVO();
		StringBuilder sb = new StringBuilder("select * from dino_game where id = '").append(id).append("\'");
		String sql = sb.toString();
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setUsername(rs.getString("username"));
				vo.setNation(rs.getString("nation"));
				vo.setOld(rs.getString("olds"));
				vo.setMobile(rs.getString("mobile"));
				vo.setEmail(rs.getString("email"));
				vo.setScore(Integer.toString(rs.getInt("score")));
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}	// read
	
	public boolean add(MemberVO vo) {
		connect();
		String sql = "insert into dino_game values (?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  vo.getId());
			pstmt.setString(2,  vo.getPasswd());
			pstmt.setString(3,  vo.getUsername());
			pstmt.setString(4,  vo.getNation());
			pstmt.setString(5,  vo.getOld());
			pstmt.setString(6,  vo.getMobile());
			pstmt.setString(7,  vo.getEmail());
			pstmt.setInt(8,  0);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	// UPDATE
	public boolean update(MemberVO vo) {
		connect();
	
		StringBuilder sb = new StringBuilder("update dino_game set passwd = ?, username = ?, nation = ?, olds = ?, mobile = ?, email = ? ")
				.append("where id = '").append(vo.getId()).append("\'");
		String sql = sb.toString();
		// update student set passwd = '1111' where id='hyunseok';
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  vo.getPasswd());
			pstmt.setString(2,  vo.getUsername());
			pstmt.setString(3,  vo.getNation());
			pstmt.setString(4,  vo.getOld());
			pstmt.setString(5,  vo.getMobile());
			pstmt.setString(6,  vo.getEmail());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public boolean delete(MemberVO vo) {
		connect();
		StringBuilder sb = new StringBuilder("delete from dino_game where id = ?");
		String sql = sb.toString();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	// LIST
	public ArrayList<MemberVO> getMemberList() {
		connect();
		
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "select * from dino_game order by score DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setUsername(rs.getString("username"));
				vo.setNation(rs.getString("nation"));
				vo.setOld(rs.getString("olds"));
				vo.setMobile(rs.getString("mobile"));
				vo.setEmail(rs.getString("email"));
				vo.setScore(Integer.toString(rs.getInt("score")));
				
				memberList.add(vo);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return memberList;
	}
	
	//SAVE
	public boolean saveScore(MemberVO vo) {
		connect();
	
		StringBuilder sb = new StringBuilder("update dino_game set score = ? ")
				.append("where id = '").append(vo.getId()).append("\'");
		String sql = sb.toString();
		// update student set passwd = '1111' where id='hyunseok';
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,  Integer.parseInt(vo.getScore()));
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
}
