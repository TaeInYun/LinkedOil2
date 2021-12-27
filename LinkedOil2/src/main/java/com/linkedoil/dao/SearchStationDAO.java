package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.EvStationVO;
import com.linkedoil.vo.SearchStationVO;

public class SearchStationDAO {
	
	public static int pageSIZE = 10;	//�� ȭ�鿡 ������ ���ڵ��� ��
	public static int totalRecord;		//��ü ���ڵ��� ��
	public static int totalPage;		//��ü �������� ��
	
	
	//��ü ���ڵ��� ���� ��ȯ�ϴ� �޼ҵ带 ����
	public int getTotalRecord() {
		int n = 0;
		String sql = "select count(*) from ev_station";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		return n;
	}
	
	//������ �˻� ����Ʈ
	public	ArrayList<SearchStationVO> searchEvStationList(int pageNUM){
		
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE);
		System.out.println("��ü���ڵ� �� : "+totalRecord);
		System.out.println("��ü������ �� : "+totalPage);
		
		int start  = (pageNUM-1)* SearchStationDAO.pageSIZE + 1;
		int end = start + SearchStationDAO.pageSIZE - 1; 
		
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		
	ArrayList<SearchStationVO> list = new ArrayList<SearchStationVO>();
		
		try {
			Connection conn = ConnectionProvider.getConnection();
	
			String sql="select ev_id,ev_name,ev_addr,"
					+"(select count(*) from review,ev_station e where review.ev_id=e.ev_id) review_cnt,"
					+"(select nvl(avg(ASTERION),0) from review,ev_station e where review.ev_id=e.ev_id) asterion_avg"
					+" from ( select rownum n,ev_id,ev_name,ev_addr,"
					+"(select count(*) from review,ev_station e where review.ev_id=e.ev_id) review_cnt,"
					+"(select nvl(avg(ASTERION),0) from review,ev_station e where review.ev_id=e.ev_id) asterion_avg from (select*from ev_station) ) "   
					+" where n between ? and ?";

			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SearchStationVO vo = new SearchStationVO();
				vo.setEv_id(rs.getInt(1));
				vo.setEv_name(rs.getString(2));
				vo.setEv_addr(rs.getString(3));
				vo.setReview_cnt(rs.getInt(4));
				vo.setAsterion_avg(rs.getDouble(5));
				list.add(vo);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
				
		return list;
		
	}
}
