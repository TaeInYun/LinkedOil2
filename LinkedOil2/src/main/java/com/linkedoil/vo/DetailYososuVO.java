package com.linkedoil.vo;

public class DetailYososuVO {

	private String name;
	private String addr;
    private String inventory;
    private String color;
    private int price;
    private String tel;
	private	int	review_cnt;	
	private	double	asterion_avg;
	
	public DetailYososuVO(String name, String addr, String inventory, String color, int price, String tel,
			int review_cnt, double asterion_avg) {
		super();
		this.name = name;
		this.addr = addr;
		this.inventory = inventory;
		this.color = color;
		this.price = price;
		this.tel = tel;
		this.review_cnt = review_cnt;
		this.asterion_avg = asterion_avg;
	}

	public DetailYososuVO() {
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getReview_cnt() {
		return review_cnt;
	}

	public void setReview_cnt(int review_cnt) {
		this.review_cnt = review_cnt;
	}

	public double getAsterion_avg() {
		return asterion_avg;
	}

	public void setAsterion_avg(double asterion_avg) {
		this.asterion_avg = asterion_avg;
	}
	
	
    
	
	
}
