package com.wildrimak.main.domain.repositories;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.wildrimak.main.domain.models.Extrato;

@Component
public class ExtratoRepository {

	private Set<Extrato> extratos = new HashSet<>();

	public Extrato save(Extrato extrato) {

		extrato.setId(extratos.size() + 1);
		extratos.add(extrato);

		return extrato;
	}

	public Extrato update(Extrato extratoToUpdate) {

		extratos.forEach(extrato -> {
			if (extrato.getId().equals(extratoToUpdate.getId())) {

				extrato.setOperacao(extratoToUpdate.getOperacao());
				extrato.setQuando(extratoToUpdate.getQuando());
				extrato.setSaldoAnterior(extratoToUpdate.getSaldoAnterior());
				extrato.setSaldoAtual(extratoToUpdate.getSaldoAtual());
			}
		});
		return extratoToUpdate;
	}

	public Extrato getExtrato(Integer idExtrato) {

		Extrato findExtrato = extratos.stream().filter(extrato -> idExtrato.equals(extrato.getId())).findAny()
				.orElse(null);

		return findExtrato;
	}

	public Set<Extrato> allExtratos() {
		return Collections.unmodifiableSet(this.extratos);
	}

}
