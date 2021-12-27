package com.linkedoil.vo;

public class EvStationVO {
	private String ev_id;
	private int chargerid;
	private String addr;
	
	public EvStationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEv_id() {
		return ev_id;
	}
	public void setEv_id(String ev_id) {
		this.ev_id = ev_id;
	}
	public int getChargerid() {
		return chargerid;
	}
	public void setChargerid(int chargerid) {
		this.chargerid = chargerid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public EvStationVO(String ev_id, int chargerid, String addr) {
		super();
		this.ev_id = ev_id;
		this.chargerid = chargerid;
		this.addr = addr;
	}
	
	
}
