package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.EvStationVO;
import com.linkedoil.vo.GasStationVO;
import com.linkedoil.vo.SearchStationVO;

public class SearchStationDAO {
	
	public static int pageSIZE = 10;	//�� ȭ�鿡 ������ ���ڵ��� ��
	public static int totalRecord;		//��ü ���ڵ��� ��
	public static int totalPage;		//��ü �������� ��
	public static int pageGroup = 10; // �� ȭ�鿡 ������ �������� ���� 10����
	
	public static int startPage;
	public static int endPage;


	
	public int getTotalEvRecord(String sido1, String gugun1) {
		int n= 0 ;
		String sql ="select count(*) from ev_station ";		
		
		if(sido1 != null && gugun1 != null) {
			sql += "  where ev_addr like '%"+sido1+"%'  and ev_addr like '%"+gugun1+"%'    ";
		} 
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					n = rs.getInt(1);
				}
				ConnectionProvider.close(conn, pstmt,rs);
			}catch(Exception e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
			}	
			return n;
			
		}
	
	//������ �˻� ����Ʈ
	public	ArrayList<SearchStationVO> searchEvStationList(int pageNUM, String sido1, String gugun1){
		
		totalRecord = getTotalEvRecord(sido1, gugun1);
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE);
		System.out.println("��ü���ڵ� �� : "+totalRecord);
		System.out.println("��ü������ �� : "+totalPage);
		
		int start  = (pageNUM-1)* SearchStationDAO.pageSIZE + 1;
		int end = start + SearchStationDAO.pageSIZE - 1; 
		
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		
		startPage = (int)Math.floor( (pageNUM-1)/pageGroup) *pageGroup + 1;
		endPage = startPage + pageGroup - 1;
		
		System.out.println("startPage:"+startPage);
		System.out.println("endPage:"+endPage);
		
		// �߰��� ���� ����
		if( totalPage < pageNUM) {
			pageNUM = totalPage;
		}

		if ( endPage > totalPage) {
		endPage = totalPage;
		}
		
		
		
	ArrayList<SearchStationVO> list = new ArrayList<SearchStationVO>();
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			String sql2 = "select * from ev_station";
			
			if(sido1 != null && gugun1 != null) {
				sql2 += "  where ev_addr like '%"+sido1+"%'  and ev_addr like '%"+gugun1+"%'    ";
			}
			
			
			String sql="select ev_id,ev_name,ev_addr,"
					+"(select count(*) from review,ev_station e where review.ev_id=e.ev_id) review_cnt,"
					+"(select nvl(avg(ASTERION),0) from review,ev_station e where review.ev_id=e.ev_id) asterion_avg"
					+" from ( select rownum n,ev_id,ev_name,ev_addr,"
					+"(select count(*) from review,ev_station e where review.ev_id=e.ev_id) review_cnt,"
					+"(select nvl(avg(ASTERION),0) from review,ev_station e where review.ev_id=e.ev_id) asterion_avg from ("+sql2+") ) "   
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
