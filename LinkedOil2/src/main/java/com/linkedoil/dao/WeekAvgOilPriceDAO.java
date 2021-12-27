package com.linkedoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.linkedoil.db.ConnectionProvider;
import com.linkedoil.vo.WeekAvgOilPriceVO;

public class WeekAvgOilPriceDAO {
	
	public static void main(String[] args) {
		/*
		WeekAvgOilPriceDAO dao = new WeekAvgOilPriceDAO();
		int premiumGas = dao.insertWeekAvgPremiumGas();
		int gas = dao.insertWeekAvgGas();
		int diesel = dao.insertWeekAvgDiesel();
		int lpg = dao.insertWeekAvgLpg();
		*/
		//System.out.println("������ ����ֹ��� ���ڵ� ��:" + premiumGas);
		//System.out.println("������ �ֹ��� ���ڵ� ��:" + gas);
		//System.out.println("������ ���� ���ڵ� ��:" + diesel);
		//System.out.println("������ lpg ���ڵ� ��:" + lpg);
	}
	
	//�޼ҵ�
	
	//���ڵ尡������
	
	
	//����ֹ��� �ְ�������� ������ ����
	public int insertWeekAvgPremiumGas(){
		CsvDAO dao = new CsvDAO();
		ArrayList<WeekAvgOilPriceVO> csv = dao.loadOilCsv("�ְ�����ǸŰ���(����ֹ���,�ֹ���,����)");
		int re = 0;
		
		String sql = "insert into WeekAvgOilPrice values((select nvl(count(*),0) + 1 from WeekAvgOilPrice), "
					+ "'B034',?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(WeekAvgOilPriceVO w : csv) {
				pstmt.setString(1, w.getWeek());
				pstmt.setDouble(2, w.getPremium_gas_price());
				re += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			ConnectionProvider.close(conn, pstmt);
		}
		
		return re;
	}
	
	//�ֹ��� �ְ�������� ������ ����
	public int insertWeekAvgGas(){
		CsvDAO dao = new CsvDAO();
		ArrayList<WeekAvgOilPriceVO> csv = dao.loadOilCsv("�ְ�����ǸŰ���(����ֹ���,�ֹ���,����)");
		int re = 0;
		
		String sql = "insert into WeekAvgOilPrice values((select nvl(count(*),0) + 1 from WeekAvgOilPrice), "
				+ "'B027',?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(WeekAvgOilPriceVO w : csv) {
				pstmt.setString(1, w.getWeek());
				pstmt.setDouble(2, w.getGas_price());
				re += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			ConnectionProvider.close(conn, pstmt);
		}
		
		return re;
	}
	
	//���� �ְ�������� �����ͻ���
	public int insertWeekAvgDiesel(){
		CsvDAO dao = new CsvDAO();
		ArrayList<WeekAvgOilPriceVO> csv = dao.loadOilCsv("�ְ�����ǸŰ���(����ֹ���,�ֹ���,����)");
		int re = 0;
		
		String sql = "insert into WeekAvgOilPrice values((select nvl(count(*),0) + 1 from WeekAvgOilPrice), "
				+ "'D047',?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(WeekAvgOilPriceVO w : csv) {
				pstmt.setString(1, w.getWeek());
				pstmt.setDouble(2, w.getDiesel_price());
				re += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			ConnectionProvider.close(conn, pstmt);
		}
		
		return re;
	}
	
	//LPG �ְ�������� �����ͻ���
	public int insertWeekAvgLpg(){
		CsvDAO dao = new CsvDAO();
		ArrayList<WeekAvgOilPriceVO> csv = dao.loadLpgCsv("�ְ�����ǸŰ���(LPG)");
		int re = 0;
		
		String sql = "insert into WeekAvgOilPrice values((select nvl(count(*),0) + 1 from WeekAvgOilPrice), "
				+ "'K015',?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(WeekAvgOilPriceVO w : csv) {
				pstmt.setString(1, w.getWeek());
				pstmt.setDouble(2, w.getLpg_price());
				re += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			ConnectionProvider.close(conn, pstmt);
		}
		
		return re;
	}
}
