package com.wildrimak.main.api.models;

import java.math.BigDecimal;

public class TransferenciaModel {

	private Integer idOutraConta;
	private BigDecimal value;

	public Integer getIdOutraConta() {
		return idOutraConta;
	}

	public void setIdOutraConta(Integer idOutraConta) {
		this.idOutraConta = idOutraConta;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
