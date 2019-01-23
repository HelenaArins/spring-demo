package com.rookie.training.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Movie!!!!!")
public class InvalidMovieException extends IllegalArgumentException{

	private static final long serialVersionUID = 1L;
	
	public InvalidMovieException() {
		super("Invalid Product!");
	}

}
