package com.capitalone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "exchange")
@Table(name = "exchange", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "exchangeFrom",
		"exchangeTo" }))
public class Exchange {

	private Long exchangeId;
	private String exchangeFrom;
	private String exchangeTo;
	private Float rate;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exchange_seq_generator")
	@SequenceGenerator(name = "exchange_seq_generator", sequenceName = "exchange_seq", allocationSize = 1)
	@Column(name = "exchangeId", unique = true, nullable = false)
	public Long getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(Long exchangeId) {
		this.exchangeId = exchangeId;
	}

	@Column(nullable = false)
	public String getExchangeFrom() {
		return exchangeFrom;
	}

	public void setExchangeFrom(String exchangeFrom) {
		this.exchangeFrom = exchangeFrom;
	}

	@Column(nullable = false)
	public String getExchangeTo() {
		return exchangeTo;
	}

	public void setExchangeTo(String exchangeTo) {
		this.exchangeTo = exchangeTo;
	}

	@Column(nullable = false)
	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

}
