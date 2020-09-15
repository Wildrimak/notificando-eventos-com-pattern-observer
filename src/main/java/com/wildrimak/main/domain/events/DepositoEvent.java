package com.wildrimak.main.domain.events;

import com.wildrimak.main.domain.models.Conta;

public class DepositoEvent {

	private Conta conta;

	public DepositoEvent(Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}
	
}
