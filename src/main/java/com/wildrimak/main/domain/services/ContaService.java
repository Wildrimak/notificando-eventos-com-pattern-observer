package com.wildrimak.main.domain.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.wildrimak.main.domain.events.ContaCriadaEvent;
import com.wildrimak.main.domain.models.Conta;
import com.wildrimak.main.domain.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public Conta salvar(Conta conta) {
		Conta save = contaRepository.save(conta);
		applicationEventPublisher.publishEvent(new ContaCriadaEvent(save));
		return save;
	}

	public Optional<Conta> getConta(Integer idConta) {

		Conta conta = contaRepository.getConta(idConta);
		Optional<Conta> contaOptional = Optional.of(conta);

		return contaOptional;

	}

	public void sacar(Conta conta, BigDecimal valor) {
		BigDecimal saldoFinal = conta.getSaldo().subtract(valor);
		conta.setSaldo(saldoFinal);
		Conta update = contaRepository.update(conta);
		applicationEventPublisher.publishEvent(new ContaCriadaEvent(update));
	}

	public void depositar(Conta conta, BigDecimal valor) {
		BigDecimal saldoFinal = conta.getSaldo().add(valor);
		conta.setSaldo(saldoFinal);
		Conta update = contaRepository.update(conta);
		applicationEventPublisher.publishEvent(new ContaCriadaEvent(update));
	}

	public void tranferir(Conta minhaConta, Conta outraConta, BigDecimal valor) {

		BigDecimal meuSaldoFinal = minhaConta.getSaldo().subtract(valor);
		minhaConta.setSaldo(meuSaldoFinal);
		contaRepository.update(minhaConta);

		BigDecimal saldoFinal = outraConta.getSaldo().add(valor);
		outraConta.setSaldo(saldoFinal);
		contaRepository.update(outraConta);

	}

}
