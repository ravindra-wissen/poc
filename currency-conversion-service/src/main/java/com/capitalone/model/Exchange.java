package com.capitalone.model;

public class Exchange {

	private String exchangeFrom;
	private String exchangeTo;
	private Float rate;   
	private Float totalCalculatedAmount;
	
	public String getExchangeFrom() {      
		return exchangeFrom; 
	}

	public void setExchangeFrom(String exchangeFrom) {
		this.exchangeFrom = exchangeFrom;
	}

	public String getExchangeTo() {
		return exchangeTo;
	}

	public void setExchangeTo(String exchangeTo) {
		this.exchangeTo = exchangeTo;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(Float totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	

}
