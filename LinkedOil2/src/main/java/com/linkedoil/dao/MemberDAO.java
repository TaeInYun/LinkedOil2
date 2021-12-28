package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.MemberVO;
 
public class MemberDAO {
	
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
		String sql = "insert into member values(?,?,?,?,?)";
		 
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getNo());
			pstmt.setString(2, m.getEmail());
		//	pstmt.setString(3, m.getPwd());
			pstmt.setString(4, m.getName());
			pstmt.setString(5, m.getNickname());
			
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
	
	public String findPwd(String nickname, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pwd = "";
		boolean re = false;
		String sql = "select pwd member where nickname=? and email=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setString(2, email);
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
		
		return pwd;
	}
}
