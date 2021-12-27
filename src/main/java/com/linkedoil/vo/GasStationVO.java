package com.linkedoil.vo;

public class GasStationVO {
	
	private String no1;
	private String no2;
	
	private String local;
	private String name;
	private String addr;
	private String brand;
	
	private String self;
	private String oil_price_b034;  //고급
	private String oil_price_b027;	//휘발유
	private String oil_price_d047;	//경유
	private String oil_price_c004;	//실내 등유
	
	public GasStationVO(String no1, String no2, String local, String name, String addr, String brand, String self,
			String oil_price_b034, String oil_price_b027, String oil_price_d047, String oil_price_c004) {
		super();
		this.no1 = no1;
		this.no2 = no2;
		this.local = local;
		this.name = name;
		this.addr = addr;
		this.brand = brand;
		this.self = self;
		this.oil_price_b034 = oil_price_b034;
		this.oil_price_b027 = oil_price_b027;
		this.oil_price_d047 = oil_price_d047;
		this.oil_price_c004 = oil_price_c004;
	}
	public GasStationVO() {
		super();
	}
	public String getNo1() {
		return no1;
	}
	public void setNo1(String no1) {
		this.no1 = no1;
	}
	public String getNo2() {
		return no2;
	}
	public void setNo2(String no2) {
		this.no2 = no2;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getOil_price_b034() {
		return oil_price_b034;
	}
	public void setOil_price_b034(String oil_price_b034) {
		this.oil_price_b034 = oil_price_b034;
	}
	public String getOil_price_b027() {
		return oil_price_b027;
	}
	public void setOil_price_b027(String oil_price_b027) {
		this.oil_price_b027 = oil_price_b027;
	}
	public String getOil_price_d047() {
		return oil_price_d047;
	}
	public void setOil_price_d047(String oil_price_d047) {
		this.oil_price_d047 = oil_price_d047;
	}
	public String getOil_price_c004() {
		return oil_price_c004;
	}
	public void setOil_price_c004(String oil_price_c004) {
		this.oil_price_c004 = oil_price_c004;
	}
	 
	 
	
	

}