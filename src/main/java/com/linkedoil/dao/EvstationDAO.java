package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.EvStationVO;

public class EvstationDAO {
	
	public int insertEvstation(EvStationVO e) {
		int re = -1;
		String sql="insert into evstation values(?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getEv_id());
			pstmt.setInt(2, e.getChargerid());
			pstmt.setString(3, e.getAddr());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e1) {
			System.out.println("���ܹ߻�:"+e1.getMessage());
		}
		return re;
	}
}
