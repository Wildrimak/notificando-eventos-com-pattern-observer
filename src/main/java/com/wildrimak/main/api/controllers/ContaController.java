package com.wildrimak.main.api.controllers;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wildrimak.main.api.models.SaqueDepositoModel;
import com.wildrimak.main.api.models.TransferenciaModel;
import com.wildrimak.main.domain.models.Conta;
import com.wildrimak.main.domain.repositories.ContaRepository;
import com.wildrimak.main.domain.services.ContaService;

@RestController
@RequestMapping("contas")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ContaService contaService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Set<Conta> getAllContas() {
		return contaRepository.allContas();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Conta saveConta(@RequestBody Conta conta) {
		return contaService.salvar(conta);
	}

	@GetMapping("{idConta}/sacar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void saque(@PathVariable Integer idConta, @RequestBody SaqueDepositoModel saqueDepositoModel) {

		Optional<Conta> contaOptional = contaService.getConta(idConta);
		contaOptional.ifPresent(conta -> contaService.sacar(conta, saqueDepositoModel.getValue()));

	}

	@GetMapping("{idConta}/depositar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void depositar(@PathVariable Integer idConta, @RequestBody SaqueDepositoModel saqueDepositoModel) {
		Optional<Conta> contaOptional = contaService.getConta(idConta);
		contaOptional.ifPresent(conta -> contaService.depositar(conta, saqueDepositoModel.getValue()));
	}

	@GetMapping("{idMyConta}/transferir/{idOtherConta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void trasnferencia(@PathVariable Integer idMyConta, @PathVariable Integer idOtherConta,
			@RequestBody TransferenciaModel transferenciaModel) {

	}

}
