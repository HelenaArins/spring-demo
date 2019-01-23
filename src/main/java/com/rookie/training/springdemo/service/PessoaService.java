package com.rookie.training.springdemo.service;

import org.springframework.stereotype.Service;

import com.rookie.training.springdemo.entity.Pessoa;

@Service
public class PessoaService {
	public Pessoa getNewPessoa() {
		return new Pessoa("Fulano", 22);
	} 
}
