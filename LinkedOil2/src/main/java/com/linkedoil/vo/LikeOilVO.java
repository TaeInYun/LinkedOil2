package com.linkedoil.vo;

public class LikeOilVO {
	private int like_oil_no;
	private int no;
	private String oil_code;
	
	public LikeOilVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeOilVO(int like_oil_no, int no, String oil_code) {
		super();
		this.like_oil_no = like_oil_no;
		this.no = no;
		this.oil_code = oil_code;
	}

	public LikeOilVO(int no, String oil_code) {
		super();
		this.no = no;
		this.oil_code = oil_code;
	}

	public int getLike_oil_no() {
		return like_oil_no;
	}

	public void setLike_oil_no(int like_oil_no) {
		this.like_oil_no = like_oil_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOil_code() {
		return oil_code;
	}

	public void setOil_code(String oil_code) {
		this.oil_code = oil_code;
	}
	
	
}
