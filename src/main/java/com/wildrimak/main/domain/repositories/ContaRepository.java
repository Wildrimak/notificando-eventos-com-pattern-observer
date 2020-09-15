package com.wildrimak.main.domain.repositories;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.wildrimak.main.domain.models.Conta;

@Component
public class ContaRepository {

	private Set<Conta> contas = new HashSet<>();

	public Conta save(Conta conta) {

		conta.setId(contas.size() + 1);
		contas.add(conta);

		return conta;
	}

	public Conta update(Conta contaToUpdate) {

		contas.forEach(conta -> {
			if (conta.getId().equals(contaToUpdate.getId())) {
				conta.setAgencia(contaToUpdate.getAgencia());
				conta.setConta(contaToUpdate.getConta());
				conta.setDigito(contaToUpdate.getDigito());
				conta.setSaldo(contaToUpdate.getSaldo());
				conta.setTitular(contaToUpdate.getTitular());
			}
		});
		return contaToUpdate;
	}

	public Conta getConta(Integer idConta) {

		Conta findConta = contas.stream().filter(conta -> idConta.equals(conta.getId())).findAny().orElse(null);

		return findConta;
	}
	
	public Set<Conta> allContas() {
		return Collections.unmodifiableSet(this.contas);
	}

}
