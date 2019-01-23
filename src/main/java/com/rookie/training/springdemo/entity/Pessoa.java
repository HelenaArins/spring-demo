package com.rookie.training.springdemo.entity;

public class Pessoa {
	private String name;
	private int idade;
		
	public Pessoa(String name, int idade) {
		super();
		this.name = name;
		this.idade = idade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

}
