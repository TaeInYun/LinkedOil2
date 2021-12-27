package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.LikeStationVO;

public class LikeStationDAO {
	
	public int getNextNo() {
		int no = 0;
		String sql = "select nvl(max(no),0)+1 from likeStation ";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return no;
	}
	
	public int insertLikeGasStation(LikeStationVO l) {
		int re =1;
		String sql = "insert into likeStation values(?,null,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, l.getLike_no());			 
			pstmt.setInt(2, l.getNo());
			pstmt.setString(3, l.getStation_no());			 
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		}catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public int deleteLikeGasStation(int like_no) {
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "delete board where like_no = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, like_no);		 
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		return re;
	}	
	
}
