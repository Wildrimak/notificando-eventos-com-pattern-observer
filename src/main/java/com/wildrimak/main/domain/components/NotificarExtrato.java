package com.wildrimak.main.domain.components;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.wildrimak.main.domain.events.ContaCriadaEvent;
import com.wildrimak.main.domain.models.Conta;
import com.wildrimak.main.domain.models.Extrato;
import com.wildrimak.main.domain.repositories.ExtratoRepository;

@Component
public class NotificarExtrato {

	@Autowired
	private ExtratoRepository extratoRepository;
	
	@EventListener
	public void contaCriada(ContaCriadaEvent contaCriadaEvent) {
		
		Conta conta = contaCriadaEvent.getConta();
		Extrato extrato = new Extrato();
		
		extrato.setConta(conta);
		extrato.setOperacao("CONTA CRIADA COM SUCESSO!");
		extrato.setQuando(new Date());
		extrato.setSaldoAnterior(BigDecimal.ZERO);
		extrato.setSaldoAtual(BigDecimal.ZERO);
		
		extratoRepository.save(extrato);
		
	}
	
}
