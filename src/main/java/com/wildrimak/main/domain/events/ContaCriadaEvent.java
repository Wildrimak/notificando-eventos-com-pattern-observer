package com.wildrimak.main.domain.events;

import com.wildrimak.main.domain.models.Conta;

public class ContaCriadaEvent {

	private Conta conta;

	public ContaCriadaEvent(Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}

}
