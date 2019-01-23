package com.rookie.training.springdemo.entity;

import java.util.Date;

public class Movie {
	private String name;
	private int year;
	private Long id;
		
	public Movie(String name, int year) {
		super();
		this.name = name;
		this.year = year;
		this.id = generateId();
	}
	private long generateId() {
		return new Double(Math.random() * 1000).longValue();
	}
	private Object Date() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
