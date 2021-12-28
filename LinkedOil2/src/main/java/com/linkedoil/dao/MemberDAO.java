package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.MemberVO;
 
public class MemberDAO {
	public int getNo(String email, String nickname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int no = 0;
		
		String sql = "select no from member where email=? and nickname=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, nickname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
			}
					
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}finally {
			try {
				ConnectionProvider.close(conn, pstmt, rs);
			}catch (Exception e) {
			}
		}
		
		return no;
	}
	
	public boolean isMember(String email, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean re = false;
		String sql = "select * from member where email=? and pwd=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				re = true;
			}
					
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return re;
	}
	
	public int insertMember(MemberVO m) {
		int re = -1;
		String sql = "insert into member values((select nvl(max(no),0)+1000 from member), ?,?,?,?)";
		 
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getNickname());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		return re;
	}
	
	public int updateMember(MemberVO m) {
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "update member set pwd=?,nickname=? where email=? and pwd=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		//	pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getNickname());
			pstmt.setString(3, m.getEmail());
		//	pstmt.setString(4, m.getPwd());
			 
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		return re;
	}
	public int deleteMember(int no) {
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "delete board where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);		 
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		return re;
	}
	
 /*
	public String getId(String nickname, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String email = "";
		boolean re = false;
		String sql = "select email from member where nickname=? and name=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				re = true;
			}
					
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return email;
	}
	public boolean FindId(String nickName, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean re = false;
		String sql = "select * from member where nickName=? and name=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				re = true;
			}
					
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return re;
	}
	*/
	
	//탈퇴하기
	public boolean deleteId (String email, String pwd) {
		boolean result = false;
		String sql = "DELETE FROM member WHERE email=? AND pwd=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			result= 1 == pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return result;
	}
//아이디 찾기
	public String findId(String nickName, String name) {
		String email = "없음";
		
		try {
			String sql = "select email from member where nickname='"+nickName+"' and name='"+name+"'";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				email = rs.getString("email");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}
	
	//비밀번호 찾기
	public String findPwd(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pwd = "";
		String sql = "select pwd from member where email=?";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pwd = rs.getString(1);
				System.out.println(pwd);
			}
					
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}finally {
			try {
				ConnectionProvider.close(conn, pstmt, rs);
			}catch (Exception e) {
			}
		}
		
		return pwd;
	}
	
	//아이디 중복확인
	public boolean checkemail(String id) {
		boolean result = false;
		String sql = "select email from member where email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionProvider.close(conn, pstmt, rs);
		}
		return result;
	}
	
	//닉네임 중복확인
	public boolean checkNickname(String nickname) {
		boolean result = false;
		String sql = "select nickname from member where nickname=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionProvider.close(conn, pstmt, rs);
		}
		return result;
	}	
}
