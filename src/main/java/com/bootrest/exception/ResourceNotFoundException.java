package com.bootrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

	/*
	 * Removing trace field from exception response
	 */
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}
