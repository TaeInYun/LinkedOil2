package com.linkedoil.vo;

import java.util.Date;

public class DetailStationVO {
	private	String	amount_remain	;
	private	String	carwash	;
	private	String	charger_method_name	;
	private	String	charger_status_name	;
	private	String	charger_type_name	;
	private	String	conveniene_store	;
	private	String	ev_addr	;
	private	int	ev_id	;
	private	String	ev_name	;
	private	String	ev_price	;
	private	String	logo	;
	private	String	maintenance	;
	private	Date	oil_date	;
	private	String	oil_name	;
	private	int	oil_price	;
	private	String	quality_certification	;
	private	String	station_addr_road	;
	private	String	Station_phone	;
	private	int	stock	;
	private	String	station_name	;
	private	int	     review_cnt	;
	private	double	asterion_avg	;
	private	int	asterion_count	;
	private	int	no	;
	public DetailStationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailStationVO(String amount_remain, String carwash, String charger_method_name, String charger_status_name,
			String charger_type_name, String conveniene_store, String ev_addr, int ev_id, String ev_name,
			String ev_price, String logo, String maintenance, Date oil_date, String oil_name, int oil_price,
			String quality_certification, String station_addr_road, String station_phone, int stock,
			String station_name, int review_cnt, double asterion_avg, int asterion_count, int no) {
		super();
		this.amount_remain = amount_remain;
		this.carwash = carwash;
		this.charger_method_name = charger_method_name;
		this.charger_status_name = charger_status_name;
		this.charger_type_name = charger_type_name;
		this.conveniene_store = conveniene_store;
		this.ev_addr = ev_addr;
		this.ev_id = ev_id;
		this.ev_name = ev_name;
		this.ev_price = ev_price;
		this.logo = logo;
		this.maintenance = maintenance;
		this.oil_date = oil_date;
		this.oil_name = oil_name;
		this.oil_price = oil_price;
		this.quality_certification = quality_certification;
		this.station_addr_road = station_addr_road;
		Station_phone = station_phone;
		this.stock = stock;
		this.station_name = station_name;
		this.review_cnt = review_cnt;
		this.asterion_avg = asterion_avg;
		this.asterion_count = asterion_count;
		this.no = no;
	}
	
	

	
	public DetailStationVO(String ev_addr, int ev_id, String ev_name, int review_cnt, double asterion_avg) {
		super();
		this.ev_addr = ev_addr;
		this.ev_id = ev_id;
		this.ev_name = ev_name;
		this.review_cnt = review_cnt;
		this.asterion_avg = asterion_avg;
	}
	public String getAmount_remain() {
		return amount_remain;
	}
	public void setAmount_remain(String amount_remain) {
		this.amount_remain = amount_remain;
	}
	public String getCarwash() {
		return carwash;
	}
	public void setCarwash(String carwash) {
		this.carwash = carwash;
	}
	public String getCharger_method_name() {
		return charger_method_name;
	}
	public void setCharger_method_name(String charger_method_name) {
		this.charger_method_name = charger_method_name;
	}
	public String getCharger_status_name() {
		return charger_status_name;
	}
	public void setCharger_status_name(String charger_status_name) {
		this.charger_status_name = charger_status_name;
	}
	public String getCharger_type_name() {
		return charger_type_name;
	}
	public void setCharger_type_name(String charger_type_name) {
		this.charger_type_name = charger_type_name;
	}
	public String getConveniene_store() {
		return conveniene_store;
	}
	public void setConveniene_store(String conveniene_store) {
		this.conveniene_store = conveniene_store;
	}
	public String getEv_addr() {
		return ev_addr;
	}
	public void setEv_addr(String ev_addr) {
		this.ev_addr = ev_addr;
	}
	public int getEv_id() {
		return ev_id;
	}
	public void setEv_id(int ev_id) {
		this.ev_id = ev_id;
	}
	public String getEv_name() {
		return ev_name;
	}
	public void setEv_name(String ev_name) {
		this.ev_name = ev_name;
	}
	public String getEv_price() {
		return ev_price;
	}
	public void setEv_price(String ev_price) {
		this.ev_price = ev_price;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}
	public Date getOil_date() {
		return oil_date;
	}
	public void setOil_date(Date oil_date) {
		this.oil_date = oil_date;
	}
	public String getOil_name() {
		return oil_name;
	}
	public void setOil_name(String oil_name) {
		this.oil_name = oil_name;
	}
	public int getOil_price() {
		return oil_price;
	}
	public void setOil_price(int oil_price) {
		this.oil_price = oil_price;
	}
	public String getQuality_certification() {
		return quality_certification;
	}
	public void setQuality_certification(String quality_certification) {
		this.quality_certification = quality_certification;
	}
	public String getStation_addr_road() {
		return station_addr_road;
	}
	public void setStation_addr_road(String station_addr_road) {
		this.station_addr_road = station_addr_road;
	}
	public String getStation_phone() {
		return Station_phone;
	}
	public void setStation_phone(String station_phone) {
		Station_phone = station_phone;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
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
	public int getAsterion_count() {
		return asterion_count;
	}
	public void setAsterion_count(int asterion_count) {
		this.asterion_count = asterion_count;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "DetailStationVO [charger_method_name=" + charger_method_name + ", charger_status_name="
				+ charger_status_name + ", charger_type_name=" + charger_type_name + ", ev_name=" + ev_name
				+ ", review_cnt=" + review_cnt + ", asterion_avg=" + asterion_avg + "]";
	}
	
	
	
}
