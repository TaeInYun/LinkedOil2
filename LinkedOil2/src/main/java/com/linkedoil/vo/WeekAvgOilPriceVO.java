package com.linkedoil.vo;

public class WeekAvgOilPriceVO {

		private String week;
		private String oil_code;
		
		private double premium_gas_price;
		private double gas_price;
		private double diesel_price;
		private double lpg_price;
		private double price;
		
		public WeekAvgOilPriceVO() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public WeekAvgOilPriceVO(String week, String oil_code, double price) {
			super();
			this.week = week;
			this.oil_code = oil_code;
			this.price = price;
		}

		public WeekAvgOilPriceVO(String week, double premium_gas_price, double gas_price, double diesel_price) {
			super();
			this.week = week;
			this.premium_gas_price = premium_gas_price;
			this.gas_price = gas_price;
			this.diesel_price = diesel_price;
		}
		
		
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getLpg_price() {
			return lpg_price;
		}

		public void setLpg_price(double lpg_price) {
			this.lpg_price = lpg_price;
		}

		public String getWeek() {
			return week;
		}

		public void setWeek(String week) {
			this.week = week;
		}

		public String getOil_code() {
			return oil_code;
		}

		public void setOil_code(String oil_code) {
			this.oil_code = oil_code;
		}

		public double getPremium_gas_price() {
			return premium_gas_price;
		}

		public void setPremium_gas_price(double premium_gas_price) {
			this.premium_gas_price = premium_gas_price;
		}

		public double getGas_price() {
			return gas_price;
		}

		public void setGas_price(double gas_price) {
			this.gas_price = gas_price;
		}

		public double getDiesel_price() {
			return diesel_price;
		}

		public void setDiesel_price(double diesel_price) {
			this.diesel_price = diesel_price;
		}
		

		
}
