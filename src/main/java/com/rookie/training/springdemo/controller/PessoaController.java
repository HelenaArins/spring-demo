package com.rookie.training.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rookie.training.springdemo.entity.Pessoa;
import com.rookie.training.springdemo.service.PessoaService;

@RequestMapping("/pessoa")
@ResponseBody
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping("/get")
	public Pessoa getPessoa() {
		
		return pessoaService.getNewPessoa();
	}
	
}
