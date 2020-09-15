package com.wildrimak.main.domain.events;

import com.wildrimak.main.domain.models.Conta;

public class TransferenciaEvent {

	private Conta conta;

	public TransferenciaEvent(Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}
	
}
