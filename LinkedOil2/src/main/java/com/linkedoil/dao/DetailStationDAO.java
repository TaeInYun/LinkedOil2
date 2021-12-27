package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.DetailStationVO;
import com.linkedoil.vo.EvStationVO;

public class DetailStationDAO {
	
	//주유소 정보
	public DetailStationVO getEvStation(int ev_id){
		
		DetailStationVO vo = null;

		try {
			Connection conn = ConnectionProvider.getConnection();
			
			String sql = "select ev_addr,ev_id,ev_name ,(select count(*) from review,ev_station e where review.ev_id=e.ev_id) review_cnt,"
					+ "(select nvl(avg(ASTERION),0) from review,ev_station e where review.ev_id=e.ev_id) asterion_avg "
					+ "from ev_station e where ev_id =?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ev_id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				/*vo = new DetailStationVO();
				vo.setEv_name(rs.getString(1));
				vo.setReview_cnt(rs.getInt(2));
				vo.setAsterion_avg(rs.getDouble(3));*/
				
				vo = new DetailStationVO(rs.getString(1),rs.getInt(2),rs.getString(3), rs.getInt(4), rs.getDouble(5));
				
				}
			
			ConnectionProvider.close(conn, pstmt,rs);	
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
				
		return vo;
		
	}
	
	//충전기 정보
	public ArrayList<DetailStationVO> EvChargerlist(int ev_id){
		ArrayList<DetailStationVO> list = new ArrayList<DetailStationVO>();
		
		String sql = "select charger_status_name,charger_type_name, charger_method_name "
				+ "from ev_charger c, charger_method m, charger_status s, charger_type t "
				+ "where c.charger_method_no=m.charger_method_no and "
				+ "c.charger_type = t.charger_type and "
				+ "c.charger_status_code=s.charger_status_code and ev_id=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ev_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				DetailStationVO vo = new DetailStationVO();
				vo.setCharger_status_name(rs.getString(1));
				vo.setCharger_type_name(rs.getString(2));
				vo.setCharger_method_name(rs.getString(3));
				list.add(vo);
				}
			
			ConnectionProvider.close(conn, pstmt,rs);	
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
				
		return list;
		
	}
	
	
}
