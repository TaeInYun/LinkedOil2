package com.linkedoil.vo;

public class YososuVO {

	private String name;
	private String addr;
    private String inventory;
    private String color;
    private int price;
    private double lat;
    private double lng;
    private String tel;
    
    
    
	public YososuVO(String name, String addr, String inventory, String color, int price, double lat, double lng,
			String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.inventory = inventory;
		this.color = color;
		this.price = price;
		this.lat = lat;
		this.lng = lng;
		this.tel = tel;
	}


	public YososuVO() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getInventory() {
		return inventory;
	}


	public void setInventory(String inventory) {
		this.inventory = inventory;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLng() {
		return lng;
	}


	public void setLng(double lng) {
		this.lng = lng;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
    
	

	
	
}
