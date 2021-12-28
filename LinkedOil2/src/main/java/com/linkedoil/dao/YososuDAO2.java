package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.EvStationVO;
import com.linkedoil.vo.YososuVO;

public class YososuDAO2 {
	
	
	public int insertYososuVO(String name, String addr, String inventory, String color, int price, double lat, double lng) {
		int re = -1;
		String sql="insert into yososu values(?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, inventory );
			pstmt.setString(4, color);
			pstmt.setInt(5, price);
			pstmt.setDouble(6, lat);
			pstmt.setDouble(7, lng);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e1) {
			System.out.println("예외발생:"+e1.getMessage());
		}
		return re;
	}
}
