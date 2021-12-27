package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
