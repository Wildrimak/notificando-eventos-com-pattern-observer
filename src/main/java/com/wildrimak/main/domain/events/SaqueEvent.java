package com.wildrimak.main.domain.events;

import com.wildrimak.main.domain.models.Conta;

public class SaqueEvent {
	
	private Conta conta;

	public SaqueEvent(Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}
}
