package com.linkedoil.vo;

public class TodayOilVO {
	private String oil_name;
	private double price;
	private double diff;
	private String api_diff;
	
	public TodayOilVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TodayOilVO(String oil_name, double price, double diff) {
		super();
		this.oil_name = oil_name;
		this.price = price;
		this.diff = diff;
	}
	public TodayOilVO(String oil_name, double price, String api_diff) {
		super();
		this.oil_name = oil_name;
		this.price = price;
		this.api_diff = api_diff;
	}
	public String getOil_name() {
		return oil_name;
	}
	public void setOil_name(String oil_name) {
		this.oil_name = oil_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiff() {
		return diff;
	}
	public void setDiff(double diff) {
		this.diff = diff;
	}
	public String getApi_diff() {
		return api_diff;
	}
	public void setApi_diff(String api_diff) {
		this.api_diff = api_diff;
	}
	
	
}
