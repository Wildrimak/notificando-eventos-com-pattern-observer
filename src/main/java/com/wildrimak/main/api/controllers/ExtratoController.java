package com.wildrimak.main.api.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildrimak.main.domain.models.Extrato;
import com.wildrimak.main.domain.repositories.ExtratoRepository;

@RestController
@RequestMapping("extrato")
public class ExtratoController {

	@Autowired
	private ExtratoRepository extratoRepository;

	@GetMapping
	public Set<Extrato> getAll() {
		return extratoRepository.allExtratos();
	}

}
