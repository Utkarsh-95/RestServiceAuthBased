package com.bootrest.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class TokenNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TokenNotFoundException(String message) {
		super(message);
	}
}
