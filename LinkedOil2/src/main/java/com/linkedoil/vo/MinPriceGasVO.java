package com.linkedoil.vo;

public class MinPriceGasVO {

	
	 private String station_no;
	 private String station_local; 
	 private String station_name;
	 private String station_addr;
	 private String oil_b027;
	public MinPriceGasVO(String station_no, String station_local, String station_name, String station_addr,
			String oil_b027) {
		super();
		this.station_no = station_no;
		this.station_local = station_local;
		this.station_name = station_name;
		this.station_addr = station_addr;
		this.oil_b027 = oil_b027;
	}
	public MinPriceGasVO() {
		super();
	}
	public String getStation_no() {
		return station_no;
	}
	public void setStation_no(String station_no) {
		this.station_no = station_no;
	}
	public String getStation_local() {
		return station_local;
	}
	public void setStation_local(String station_local) {
		this.station_local = station_local;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getStation_addr() {
		return station_addr;
	}
	
	public void setStation_addr(String station_addr) {
		this.station_addr = station_addr;
	}
	public String getOil_b027() {
		return oil_b027;
	}
	public void setOil_b027(String oil_b027) {
		this.oil_b027 = oil_b027;
	}
	
}
